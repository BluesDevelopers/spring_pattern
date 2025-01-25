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
package com.decorator.demo.service;

import java.util.List;

import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.PraticeValidDTO;
import com.decorator.demo.model.dto.RevocationPracticeDTO;
import com.decorator.demo.model.dto.SearchPracticeRequestDTO;
import com.decorator.demo.model.dto.SearchPracticeResponseDTO;

public interface IPracticesService {
	
	PraticeValidDTO validPractice (PracticeDTO praticaDTO);

	PracticeDTO updatePractice (PracticeDTO praticaDTO);

	void archivePractice (Long idPractice);

	void cancelPractice (Long idPractice);

	PracticeDTO saveDraft (PracticeDTO practiceDTO);

	void saveStatusPractice (Long idPractice, String statusPractice);

	Boolean deleteDraft (Long id);

	void revocationPractice (RevocationPracticeDTO revocationPracticeDTO);

	List<SearchPracticeResponseDTO> searchPractices (SearchPracticeRequestDTO searchPracticeRequestDTO);

}
