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

package com.decorator.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.decorator.demo.enumeration.EnumUser;
import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.ReportFilterDTO;
import com.decorator.demo.service.IPracticesService;
import com.decorator.demo.service.IReportServiceStrategy;
import com.decorator.demo.service.ci.factory.PracticeFactory;
import com.decorator.demo.service.strategy.ReportService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private PracticeFactory factory;
	
	@Autowired
	private ReportService reportService; 
		
	@Autowired
	@Qualifier("companyReportServiceStrategy")
	private IReportServiceStrategy companyReportServiceStrategy;
	
	@Autowired
	@Qualifier("regionalReportServiceStrategy")
	private IReportServiceStrategy regionalReportServiceStrategy;

	@Autowired
	@Qualifier("stateReportServiceStrategy")
	private IReportServiceStrategy stateReportServiceStrategy;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Strategy
		ReportFilterDTO reportFilterDTO = new ReportFilterDTO();
		reportFilterDTO.setState("State");
		reportFilterDTO.setCompanyType("Company");
		reportFilterDTO.setStatus("Status");
		reportService.addFilter(reportFilterDTO);
		
		System.out.println("Report call function search");
		reportService.searcher(companyReportServiceStrategy);
		reportService.searcher(regionalReportServiceStrategy);
		reportService.searcher(stateReportServiceStrategy);
		System.out.println("");
		
		
		// Factory 
		IPracticesService serviceFactory = factory.getService(EnumUser.COMPANY);
		
		//Decorator
		System.out.println("User to call function company");
		serviceFactory.validPractice(new PracticeDTO()); 
		serviceFactory.updatePractice(new PracticeDTO());
		serviceFactory.saveDraft(new PracticeDTO());
		serviceFactory.saveStatusPractice(Long.getLong("123456"), "ACTIVE");
		System.out.println("");
		
		serviceFactory = factory.getService(EnumUser.INTERMEDIARY);
		System.out.println("User to call function intermediary");
		serviceFactory.validPractice(new PracticeDTO()); 
		serviceFactory.updatePractice(new PracticeDTO());
		serviceFactory.saveDraft(new PracticeDTO());
		serviceFactory.saveStatusPractice(Long.getLong("123456"), "NO ACTIVE");
		System.out.println("");		
		
		serviceFactory = factory.getService(EnumUser.REGIONAL);
		System.out.println("User to call function regional");
		serviceFactory.validPractice(new PracticeDTO()); 
		serviceFactory.updatePractice(new PracticeDTO());
		serviceFactory.saveDraft(new PracticeDTO());
		serviceFactory.saveStatusPractice(Long.getLong("123456"), "ENDED");
		System.out.println("");
		
	}


}
