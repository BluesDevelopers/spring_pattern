/* License

 Copyright(c) by Blues Developers

 Article 1 (Permissions/Conditions): 
 The third party [Which will be referred as "the user" from now on] has 
 permission to use, and redistribute this software on the following 
 conditions: You give credit to the contributors, and keep the licensing 
 and this disclaimer onto the redistributed copy of this software. 
 And, if you make your copy public, it must be open source.

 Article 2 (Limitations): 
 The First Party [Which will be referred as "Us/We" from now on] has added 
 a few limitations to the project, 1: No warranty is included with the 
 software. 2: We have NO liability for anything you do, this project is 
 purely for educational purposes. 
*/
package com.decorator.demo.service.strategy;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.decorator.demo.model.dto.ReportDTO;
import com.decorator.demo.model.dto.ReportFilterDTO;
import com.decorator.demo.service.IReportServiceStrategy;

@Service("companyReportServiceStrategy")
public class CompanyReportServiceStrategy implements IReportServiceStrategy {

	@Override
	public ByteArrayOutputStream exportExcel(ReportFilterDTO filter) {
		System.out.println("Call exportExcel of CompanyReportServiceStrategy");
		return null;
	}

	@Override
	public List<ReportDTO> searcher(ReportFilterDTO filter) {
		System.out.println("Call searcher of CompanyReportServiceStrategy");
		return null;
	}

}
