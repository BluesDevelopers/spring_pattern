package com.decorator.demo.service.strategy;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.decorator.demo.model.dto.ReportDTO;
import com.decorator.demo.model.dto.ReportFilterDTO;
import com.decorator.demo.service.IReportServiceStrategy;

@Service
public class ReportService {
	
	private ReportFilterDTO reportFilter;	
	
	public void addFilter(ReportFilterDTO reportFilter){
		this.reportFilter = reportFilter;
	}
	
	public List<ReportDTO> searcher(IReportServiceStrategy reportServiceStrategy){
		return reportServiceStrategy.searcher(this.reportFilter);
	}
	
	public ByteArrayOutputStream exportExcel(IReportServiceStrategy reportServiceStrategy){
		return reportServiceStrategy.exportExcel(this.reportFilter);
	}

}
