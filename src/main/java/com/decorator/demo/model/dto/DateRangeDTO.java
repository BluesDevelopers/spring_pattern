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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateRangeDTO implements Serializable {

	private static final long serialVersionUID = 3390629938116458104L;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Rome")
	private String dataStart;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Rome")
	private String dataEnd;

}
