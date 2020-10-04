package pl.bartekbak.imperator.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bartekbak.imperator.entity.Resolution;
import pl.bartekbak.imperator.service.ResolutionService;

import java.util.List;

@Controller
@RequestMapping("/resolutions")
public class ResolutionController {

    private ResolutionService resolutionService;

    public ResolutionController(@Qualifier("resolutionServiceSpringData") ResolutionService resolutionService) {
        this.resolutionService = resolutionService;
    }

    @GetMapping("/list")
    public String listResolutions(Model model) {
        List<Resolution> resolutionList = resolutionService.findAllResolutions();
        model.addAttribute("resolutions", resolutionList);
        return "resolutions/list-resolutions";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Resolution resolution = new Resolution();
        model.addAttribute("resolution", resolution);
        return "resolutions/add-resolution-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("resolutionId") int id, Model model) {
        Resolution resolution = resolutionService.findResolutionById(id);
        model.addAttribute("resolution", resolution);
        return "resolutions/add-resolution-form";
    }

    @PostMapping("/save")
    public String saveResolution(@ModelAttribute("resolution") Resolution resolution) {
        resolutionService.saveResolution(resolution);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("resolutionId") int id) {
        resolutionService.deleteResolutionById(id);
        return "redirect:list";
    }
}

