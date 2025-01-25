package com.decorator.demo.service.strategy;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.decorator.demo.model.dto.ReportDTO;
import com.decorator.demo.model.dto.ReportFilterDTO;
import com.decorator.demo.service.IReportServiceStrategy;

public class ReportServiceTest {

    @Mock
    private IReportServiceStrategy reportServiceStrategy;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddFilter() {
        ReportFilterDTO filter = new ReportFilterDTO();
        reportService.addFilter(filter);
        // Assuming addFilter method modifies some internal state, you can add assertions here
        assertNotNull(reportService);
    }

    @Test
    public void testSearcher() {
        ReportFilterDTO filter = new ReportFilterDTO();
        reportService.addFilter(filter);
        when(reportServiceStrategy.searcher(filter)).thenReturn(List.of(new ReportDTO()));

        List<ReportDTO> result = reportService.searcher(reportServiceStrategy);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(reportServiceStrategy).searcher(filter);
    }

    @Test
    public void testExportExcel() {
        ReportFilterDTO filter = new ReportFilterDTO();
        reportService.addFilter(filter);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(reportServiceStrategy.exportExcel(filter)).thenReturn(byteArrayOutputStream);

        ByteArrayOutputStream result = reportService.exportExcel(reportServiceStrategy);
        assertNotNull(result);
        verify(reportServiceStrategy).exportExcel(filter);
    }
}
