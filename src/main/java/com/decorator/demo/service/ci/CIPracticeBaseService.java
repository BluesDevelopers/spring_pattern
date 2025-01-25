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
package com.decorator.demo.service.ci;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.PraticeValidDTO;
import com.decorator.demo.model.dto.RevocationPracticeDTO;
import com.decorator.demo.model.dto.SearchPracticeRequestDTO;
import com.decorator.demo.model.dto.SearchPracticeResponseDTO;
import com.decorator.demo.service.IPracticesService;

@Service("ciPracticeBaseService")
public class CIPracticeBaseService implements IPracticesService {

	@Override
	public PraticeValidDTO validPractice(PracticeDTO praticaDTO) {
		//logic to validate practice
		System.out.println("Call validPractice of ciPracticeBaseService");
		return new PraticeValidDTO();
	}

	@Override
	public PracticeDTO updatePractice(PracticeDTO praticaDTO) {
		// logic to update practice
		System.out.println("Call updatePractice of ciPracticeBaseService");
		return new PracticeDTO();
	}

	@Override
	public void archivePractice(Long idPractice) {
		System.out.println("Call archivePractice of ciPracticeBaseService");

	}

	@Override
	public void cancelPractice(Long idPractice) {
		System.out.println("Call cancelPractice of ciPracticeBaseService");

	}

	@Override
	public PracticeDTO saveDraft(PracticeDTO practiceDTO) {
		System.out.println("Call saveDraft of ciPracticeBaseService");
		return new PracticeDTO();
	}

	@Override
	public void saveStatusPractice(Long idPractice, String statusPractice) {
		System.out.println("Call saveStatusPractice of ciPracticeBaseService");

	}

	@Override
	public Boolean deleteDraft(Long id) {
		System.out.println("Call deleteDraft of ciPracticeBaseService");
		return Boolean.TRUE;
	}

	@Override
	public void revocationPractice(RevocationPracticeDTO revocationPracticeDTO) {
		System.out.println("Call revocationPractice of ciPracticeBaseService");

	}

	@Override
	public List<SearchPracticeResponseDTO> searchPractices(SearchPracticeRequestDTO searchPracticeRequestDTO) {
		System.out.println("Call searchPractices of ciPracticeBaseService");
		return Arrays.asList(new SearchPracticeResponseDTO());
	}

}
