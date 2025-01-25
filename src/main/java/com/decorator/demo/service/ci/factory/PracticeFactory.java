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
package com.decorator.demo.service.ci.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.decorator.demo.enumeration.EnumUser;
import com.decorator.demo.service.IPracticesService;

@Component
public class PracticeFactory {

	@Autowired
	@Qualifier("ciCompanyDecoratorService")
	private IPracticesService ciCompanyDecoratorService;
	
	@Autowired
	@Qualifier("ciIntermDecoratorService")
	private IPracticesService ciIntermDecoratorService;
	
	@Autowired
	@Qualifier("ciRegDecoratorService")
	private IPracticesService ciRegDecoratorService;

	public PracticeFactory(IPracticesService ciCompanyDecoratorService, IPracticesService ciIntermDecoratorService, IPracticesService ciRegDecoratorService) {
		this.ciCompanyDecoratorService = ciCompanyDecoratorService;
		this.ciIntermDecoratorService = ciIntermDecoratorService;
		this.ciRegDecoratorService = ciRegDecoratorService;		
	}
	
	public IPracticesService getService(EnumUser user) {
		IPracticesService iPracticesService = null;
		if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
		}
		switch (user) {
		case COMPANY: {
			iPracticesService = ciCompanyDecoratorService;
			break;
		}
		case INTERMEDIARY: {
			iPracticesService = ciIntermDecoratorService;
			break;
		}
		case REGIONAL: {
			iPracticesService = ciRegDecoratorService;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + user.getCode());
		}
		
		return iPracticesService;
	}
	
}
