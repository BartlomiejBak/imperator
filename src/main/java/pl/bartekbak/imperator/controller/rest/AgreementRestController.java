package pl.bartekbak.imperator.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bartekbak.imperator.entity.Agreement;
import pl.bartekbak.imperator.service.AgreementService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class  AgreementRestController {

    private AgreementService agreementService;

    @Autowired
    public AgreementRestController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @GetMapping("/agreements")
    public List<Agreement> findAll() {
        return agreementService.findAllAgreements();
    }

    @GetMapping("/agreements/{agreementId}")
    public Agreement getAgreement(@PathVariable int agreementId) {
        Agreement agreement = agreementService.findAgreementById(agreementId);
        if (agreement == null) {
            throw new RuntimeException("No such Id in database");
        }
        return agreement;
    }

    @PostMapping("/agreements")
    public Agreement addAgreement(@RequestBody Agreement agreement) {
        agreement.setId(0);
        agreementService.saveAgreement(agreement);
        return agreement;
    }

    @PutMapping("/agreements")
    public Agreement updateAgreement(@RequestBody Agreement agreement) {
        agreementService.saveAgreement(agreement);
        return agreement;
    }

    @DeleteMapping("/agreements/{agreementId}")
    public String deleteAgreement(@PathVariable int agreementId) {
        Agreement agreement = agreementService.findAgreementById(agreementId);
        if (agreement == null) {
            throw new RuntimeException("No such Id in database");
        }
        agreementService.deleteAgreementById(agreementId);
        return "Agreement successfully deleted";
    }
}
