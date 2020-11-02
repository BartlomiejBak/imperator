package pl.bartekbak.imperator.service.spring.data;

import org.springframework.stereotype.Service;
import pl.bartekbak.imperator.dao.AgreementRepository;
import pl.bartekbak.imperator.entity.Agreement;
import pl.bartekbak.imperator.service.AgreementService;

import java.util.List;
import java.util.Optional;

@Service
public class AgreementServiceSpringData implements AgreementService {

    private AgreementRepository agreementRepository;

    public AgreementServiceSpringData(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public List<Agreement> findAllAgreements() {
        return agreementRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Agreement findAgreementById(int id) {
        Optional<Agreement> result = agreementRepository.findById(id);
        Agreement agreement = null;
        if (result.isPresent()) {
            agreement = result.get();
        } else {
            throw new RuntimeException("Agreement Id not found");
        }

        return agreement;
    }

    @Override
    public void saveAgreement(Agreement agreement) {
        agreementRepository.save(agreement);
    }

    @Override
    public void deleteAgreementById(int id) {
        agreementRepository.deleteById(id);
    }
}
