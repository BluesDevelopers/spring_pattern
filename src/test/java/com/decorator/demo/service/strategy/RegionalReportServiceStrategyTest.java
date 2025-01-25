package com.decorator.demo.service.strategy;


import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.decorator.demo.model.dto.ReportDTO;
import com.decorator.demo.model.dto.ReportFilterDTO;

public class RegionalReportServiceStrategyTest {

    @InjectMocks
    private RegionalReportServiceStrategy regionalReportServiceStrategy;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExportExcel() {
        ReportFilterDTO filter = new ReportFilterDTO();
        ByteArrayOutputStream result = regionalReportServiceStrategy.exportExcel(filter);
        assertNull(result);
    }

    @Test
    public void testSearcher() {
        ReportFilterDTO filter = new ReportFilterDTO();
        List<ReportDTO> result = regionalReportServiceStrategy.searcher(filter);
        assertNull(result);
    }
}
