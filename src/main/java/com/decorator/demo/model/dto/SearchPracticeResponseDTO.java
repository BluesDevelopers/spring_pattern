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
package com.decorator.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPracticeResponseDTO implements Serializable {

	private static final long serialVersionUID = 1221010014197951258L;

	private Long id;

	private Long idPratctice;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Rome")
	private Date dateInsert;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Rome")
	private Date dateStart;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Rome")
	private Date dateEnd;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Rome")
	private Date dateClosed;

	private String user;

	private String companyNameragioneSociale;

	private String fiscalCode;

	private String vatNumber;

	private String status;

}
