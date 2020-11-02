package pl.bartekbak.imperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bartekbak.imperator.entity.Agreement;
import pl.bartekbak.imperator.service.AgreementService;

import java.util.List;

@Controller
@RequestMapping("/agreements")
public class AgreementController {

    private AgreementService agreementService;

    @Autowired
    public AgreementController(@Qualifier("agreementServiceSpringData") AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @GetMapping("/list")
    public String listAgreements(Model model) {
        List<Agreement> agreementList = agreementService.findAllAgreements();
        model.addAttribute("agreements", agreementList);
        return "agreements/list-agreements";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Agreement agreement = new Agreement();
        model.addAttribute("agreement", agreement);
        return "agreements/add-agreement-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("agreementId") int id, Model model) {
        Agreement agreement = agreementService.findAgreementById(id);
        model.addAttribute(agreement);
        return "agreements/add-agreement-form";
    }

    @PostMapping("/save")
    public String saveAgreement(@ModelAttribute("agreement") Agreement agreement) {
        agreementService.saveAgreement(agreement);

        //redirect prevents multiple saving
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("agreementId") int id) {
        agreementService.deleteAgreementById(id);
        return "redirect:list";
    }

}
