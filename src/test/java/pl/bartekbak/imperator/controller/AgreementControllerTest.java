package pl.bartekbak.imperator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import pl.bartekbak.imperator.entity.Agreement;
import pl.bartekbak.imperator.service.AgreementService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AgreementControllerTest {

    @Mock
    AgreementService agreementService;

    @Mock
    Model model;

    @InjectMocks
    AgreementController agreementController;

    List<Agreement> agreementList = new ArrayList<>();

    @Test
    void listAgreementsTest() {
        //given
        agreementList.add(new Agreement(1, LocalDate.now(), "desc"));
        given(agreementService.findAllAgreements()).willReturn(agreementList);
        //when
        String view = agreementController.listAgreements(model);
        //then
        then(agreementService).should().findAllAgreements();
        then(model).should().addAttribute(anyString(), any());
        assertThat("agreements/list-agreements").isEqualToIgnoringCase(view);
    }

    @Test
    void showFormForAddTest() {
        //when
        String view = agreementController.showFormForAdd(model);
        Agreement agreement = new Agreement();
        //then
        then(model).should().addAttribute(anyString(), any());
        assertThat("agreements/add-agreement-form").isEqualToIgnoringCase(view);
    }

    @Test
    void showFormForUpdateTest() {
        //when
        String view = agreementController.showFormForUpdate(anyInt(), model);
        Agreement agreement = agreementService.findAgreementById(anyInt());
        //then
        then(model).should().addAttribute(agreement);
        assertThat("agreements/add-agreement-form").isEqualToIgnoringCase(view);
    }

    @Test
    void saveAgreementTest() {
        //when
        String view = agreementController.saveAgreement(any());
        //then
        assertThat("redirect:list").isEqualToIgnoringCase(view);
    }

    @Test
    void deleteTest() {
        //when
        String view = agreementController.delete(anyInt());
        //then
        assertThat("redirect:list").isEqualToIgnoringCase(view);
    }
}