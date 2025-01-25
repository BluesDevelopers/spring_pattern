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

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.PraticeValidDTO;
import com.decorator.demo.model.dto.RevocationPracticeDTO;
import com.decorator.demo.model.dto.SearchPracticeRequestDTO;
import com.decorator.demo.model.dto.SearchPracticeResponseDTO;
import com.decorator.demo.service.IPracticesService;

@Service("ciPracticeBaseDecoratorService")
public class CIPracticeBaseDecoratorService implements IPracticesService {

	protected IPracticesService ciWrapperService;
	
	public CIPracticeBaseDecoratorService(@Qualifier("ciPracticeBaseService") IPracticesService ciPracticeService) {
		ciWrapperService = ciPracticeService;
	}
	
	@Override
	public PraticeValidDTO validPractice(PracticeDTO praticaDTO) {
		return ciWrapperService.validPractice(praticaDTO);
	}

	@Override
	public PracticeDTO updatePractice(PracticeDTO praticaDTO) {
		return ciWrapperService.updatePractice(praticaDTO);
	}

	@Override
	public void archivePractice(Long idPractice) {
		ciWrapperService.archivePractice(idPractice);

	}

	@Override
	public void cancelPractice(Long idPractice) {
		ciWrapperService.cancelPractice(idPractice);

	}

	@Override
	public PracticeDTO saveDraft(PracticeDTO practiceDTO) {
		return ciWrapperService.saveDraft(practiceDTO);
	}

	@Override
	public void saveStatusPractice(Long idPractice, String statusPractice) {
		ciWrapperService.saveStatusPractice(idPractice, statusPractice);
	}

	@Override
	public Boolean deleteDraft(Long id) {
		return ciWrapperService.deleteDraft(id);
	}

	@Override
	public void revocationPractice(RevocationPracticeDTO revocationPracticeDTO) {
		ciWrapperService.revocationPractice(revocationPracticeDTO);

	}

	@Override
	public List<SearchPracticeResponseDTO> searchPractices(SearchPracticeRequestDTO searchPracticeRequestDTO) {
		return ciWrapperService.searchPractices(searchPracticeRequestDTO);
	}

}
