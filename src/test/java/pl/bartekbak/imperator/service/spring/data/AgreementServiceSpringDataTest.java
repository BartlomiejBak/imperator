package pl.bartekbak.imperator.service.spring.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.bartekbak.imperator.dao.AgreementRepository;
import pl.bartekbak.imperator.entity.Agreement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgreementServiceSpringDataTest {

    @InjectMocks
    AgreementServiceSpringData service;

    @Mock
    AgreementRepository repository;


    @Test
    void findAllAgreementsTest() {
        //given
        List<Agreement> list = new ArrayList<>();
        Agreement agreementOne = new Agreement(1, LocalDate.now(), "registry1");
        Agreement agreementTwo = new Agreement(2, LocalDate.now(), "registry2");
        Agreement agreementThree = new Agreement(3, LocalDate.now(), "registry3");

        list.add(agreementOne);
        list.add(agreementTwo);
        list.add(agreementThree);

        //when
        when(repository.findAllByOrderByIdAsc()).thenReturn(list);
        List<Agreement> agreementList = service.findAllAgreements();

        //then
        assertEquals(3, agreementList.size());
        verify(repository, times(1)).findAllByOrderByIdAsc();
    }

    @Test
    void findAgreementByIdTest() {
        //given
        //when
        when(repository.findById(1))
                .thenReturn(Optional.of(new Agreement(1, LocalDate.now(), "registry1")));
        Agreement agreement = service.findAgreementById(1);
        //then
        assertEquals(LocalDate.now(), agreement.getAgreementDate());
        assertEquals("registry1", agreement.getAgreementRegistry());
    }

    @Test
    void saveAgreement() {
        //given
        Agreement agreementOne = new Agreement(1, LocalDate.now(), "registry1");
        //when
        service.saveAgreement(agreementOne);
        //then
        verify(repository, times(1)).save(agreementOne);
    }

    @Test
    void deleteAgreementById() {
        //when
        service.deleteAgreementById(1);
        //then
        verify(repository, times(1)).deleteById(1);
    }
}