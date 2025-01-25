package com.decorator.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.decorator.demo.enumeration.EnumUser;
import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.ReportFilterDTO;
import com.decorator.demo.service.IPracticesService;
import com.decorator.demo.service.IReportServiceStrategy;
import com.decorator.demo.service.ci.factory.PracticeFactory;
import com.decorator.demo.service.strategy.ReportService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Mock
    private PracticeFactory factory;

    @Mock
    private ReportService reportService;

    @Mock
    @Qualifier("companyReportServiceStrategy")
    private IReportServiceStrategy companyReportServiceStrategy;

    @Mock
    @Qualifier("regionalReportServiceStrategy")
    private IReportServiceStrategy regionalReportServiceStrategy;

    @Mock
    @Qualifier("stateReportServiceStrategy")
    private IReportServiceStrategy stateReportServiceStrategy;

    @InjectMocks
    private DemoApplication demoApplication;

    @BeforeEach
    public void setUp() {
        // Initialize mocks before each test
    }

    @Test
    public void testRun() throws Exception {
        // Arrange
        ReportFilterDTO reportFilterDTO = new ReportFilterDTO();
        IPracticesService companyService = mock(IPracticesService.class);
        IPracticesService intermediaryService = mock(IPracticesService.class);
        IPracticesService regionalService = mock(IPracticesService.class);

        when(factory.getService(EnumUser.COMPANY)).thenReturn(companyService);
        when(factory.getService(EnumUser.INTERMEDIARY)).thenReturn(intermediaryService);
        when(factory.getService(EnumUser.REGIONAL)).thenReturn(regionalService);

        // Act
        demoApplication.run();

        // Assert
        verify(reportService).addFilter(any(ReportFilterDTO.class));
        verify(reportService).searcher(companyReportServiceStrategy);
        verify(reportService).searcher(regionalReportServiceStrategy);
        verify(reportService).searcher(stateReportServiceStrategy);

        verify(companyService).validPractice(any(PracticeDTO.class));
        verify(companyService).updatePractice(any(PracticeDTO.class));
        verify(companyService).saveDraft(any(PracticeDTO.class));
        verify(companyService).saveStatusPractice(any(), eq("ACTIVE"));

        verify(intermediaryService).validPractice(any(PracticeDTO.class));
        verify(intermediaryService).updatePractice(any(PracticeDTO.class));
        verify(intermediaryService).saveDraft(any(PracticeDTO.class));
        verify(intermediaryService).saveStatusPractice(any(), eq("NO ACTIVE"));

        verify(regionalService).validPractice(any(PracticeDTO.class));
        verify(regionalService).updatePractice(any(PracticeDTO.class));
        verify(regionalService).saveDraft(any(PracticeDTO.class));
        verify(regionalService).saveStatusPractice(any(), eq("ENDED"));
    }
	
}
