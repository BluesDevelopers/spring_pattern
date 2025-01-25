package com.decorator.demo.service.ci;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.decorator.demo.model.dto.PracticeDTO;
import com.decorator.demo.model.dto.PraticeValidDTO;
import com.decorator.demo.model.dto.RevocationPracticeDTO;
import com.decorator.demo.model.dto.SearchPracticeRequestDTO;
import com.decorator.demo.model.dto.SearchPracticeResponseDTO;
import com.decorator.demo.service.IPracticesService;

public class CIPracticeBaseDecoratorServiceTest {

    @Mock
    private IPracticesService ciPracticeService;

    @InjectMocks
    private CIPracticeBaseDecoratorService ciPracticeBaseDecoratorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidPractice() {
        PracticeDTO practiceDTO = new PracticeDTO();
        PraticeValidDTO expected = new PraticeValidDTO();
        when(ciPracticeService.validPractice(practiceDTO)).thenReturn(expected);

        PraticeValidDTO result = ciPracticeBaseDecoratorService.validPractice(practiceDTO);

        assertEquals(expected, result);
        verify(ciPracticeService).validPractice(practiceDTO);
    }

    @Test
    public void testUpdatePractice() {
        PracticeDTO practiceDTO = new PracticeDTO();

        PracticeDTO result = ciPracticeBaseDecoratorService.updatePractice(practiceDTO);

        assertNotNull(result);
    }

    @Test
    public void testArchivePractice() {
        Long idPractice = 1L;

        ciPracticeBaseDecoratorService.archivePractice(idPractice);

        // No exception means the test passed
    }

    @Test
    public void testCancelPractice() {
        Long idPractice = 1L;

        ciPracticeBaseDecoratorService.cancelPractice(idPractice);

        verify(ciPracticeService).cancelPractice(idPractice);
    }

    @Test
    public void testSaveDraft() {
        PracticeDTO practiceDTO = new PracticeDTO();

        PracticeDTO result = ciPracticeBaseDecoratorService.saveDraft(practiceDTO);

        assertNotNull(result);
    }

    @Test
    public void testSaveStatusPractice() {
        Long idPractice = 1L;
        String statusPractice = "status";

        ciPracticeBaseDecoratorService.saveStatusPractice(idPractice, statusPractice);

        verify(ciPracticeService).saveStatusPractice(idPractice, statusPractice);
    }

    @Test
    public void testDeleteDraft() {
        Long id = 1L;

        Boolean result = ciPracticeBaseDecoratorService.deleteDraft(id);

        assertFalse(result);
    }

    @Test
    public void testRevocationPractice() {
        RevocationPracticeDTO revocationPracticeDTO = new RevocationPracticeDTO();

        ciPracticeBaseDecoratorService.revocationPractice(revocationPracticeDTO);

        verify(ciPracticeService).revocationPractice(revocationPracticeDTO);
    }

    @Test
    public void testSearchPractices() {
        SearchPracticeRequestDTO searchPracticeRequestDTO = new SearchPracticeRequestDTO();
        List<SearchPracticeResponseDTO> expected = List.of(new SearchPracticeResponseDTO());
        when(ciPracticeService.searchPractices(searchPracticeRequestDTO)).thenReturn(expected);

        List<SearchPracticeResponseDTO> result = ciPracticeBaseDecoratorService.searchPractices(searchPracticeRequestDTO);

        assertEquals(expected, result);
        verify(ciPracticeService).searchPractices(searchPracticeRequestDTO);
    }
}
