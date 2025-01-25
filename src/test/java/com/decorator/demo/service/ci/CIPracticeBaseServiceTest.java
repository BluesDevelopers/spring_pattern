package com.decorator.demo.service.ci;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.PraticeValidDTO;
import com.decorator.demo.model.dto.RevocationPracticeDTO;
import com.decorator.demo.model.dto.SearchPracticeRequestDTO;
import com.decorator.demo.model.dto.SearchPracticeResponseDTO;

public class CIPracticeBaseServiceTest {

    @InjectMocks
    private CIPracticeBaseService ciPracticeBaseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidPractice() {
        PracticeDTO practiceDTO = new PracticeDTO();
        PraticeValidDTO result = ciPracticeBaseService.validPractice(practiceDTO);

        assertNotNull(result);
    }

    @Test
    public void testUpdatePractice() {
        PracticeDTO practiceDTO = new PracticeDTO();
        PracticeDTO result = ciPracticeBaseService.updatePractice(practiceDTO);

        assertNotNull(result);
    }

    @Test
    public void testArchivePractice() {
        Long idPractice = 1L;

        ciPracticeBaseService.archivePractice(idPractice);

        // No exception means the test passed
    }

    @Test
    public void testCancelPractice() {
        Long idPractice = 1L;

        ciPracticeBaseService.cancelPractice(idPractice);

        // No exception means the test passed
    }

    @Test
    public void testSaveDraft() {
        PracticeDTO practiceDTO = new PracticeDTO();
        PracticeDTO result = ciPracticeBaseService.saveDraft(practiceDTO);

        assertNotNull(result);
    }

    @Test
    public void testSaveStatusPractice() {
        Long idPractice = 1L;
        String statusPractice = "status";

        ciPracticeBaseService.saveStatusPractice(idPractice, statusPractice);

        // No exception means the test passed
    }

    @Test
    public void testDeleteDraft() {
        Long id = 1L;
        Boolean result = ciPracticeBaseService.deleteDraft(id);

        assertTrue(result);
    }

    @Test
    public void testRevocationPractice() {
        RevocationPracticeDTO revocationPracticeDTO = new RevocationPracticeDTO();

        ciPracticeBaseService.revocationPractice(revocationPracticeDTO);

        // No exception means the test passed
    }

    @Test
    public void testSearchPractices() {
        SearchPracticeRequestDTO searchPracticeRequestDTO = new SearchPracticeRequestDTO();
        List<SearchPracticeResponseDTO> result = ciPracticeBaseService.searchPractices(searchPracticeRequestDTO);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
