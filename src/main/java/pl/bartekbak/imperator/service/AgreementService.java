package pl.bartekbak.imperator.service;

import pl.bartekbak.imperator.entity.Agreement;

import java.util.List;

public interface AgreementService {

    public List<Agreement> findAllAgreements();

    public Agreement findAgreementById(int id);

    public void saveAgreement(Agreement agreement);

    public void deleteAgreementById(int id);
}
