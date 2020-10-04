package pl.bartekbak.imperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.bartekbak.imperator.entity.Resolution;
import pl.bartekbak.imperator.service.ResolutionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResolutionRestController {

    private ResolutionService resolutionService;

    @Autowired
    public ResolutionRestController(@Qualifier("resolutionServiceSpringData") ResolutionService resolutionService) {
        this.resolutionService = resolutionService;
    }

    @GetMapping("/resolutions")
    public List<Resolution> findAll() {
        return resolutionService.findAllResolutions();
    }

    @GetMapping("/resolutions/{resolutionId}")
    public Resolution getResolution(@PathVariable int resolutionId) {
        Resolution resolution = resolutionService.findResolutionById(resolutionId);

        if (resolution == null) {
            throw new RuntimeException("No such Id in database");
        }
        return resolution;
    }

    @PostMapping("/resolutions")
    public Resolution addResolution(@RequestBody Resolution resolution) {
        resolution.setId(0);
        resolutionService.saveResolution(resolution);
        return resolution;
    }

    @PutMapping("/resolutions")
    public Resolution updateResolution(@RequestBody Resolution resolution) {
        resolutionService.saveResolution(resolution);
        return resolution;
    }

    @DeleteMapping("/resolutions/{resolutionId}")
    public String deleteResolution(@PathVariable int resolutionId) {
        Resolution resolution = resolutionService.findResolutionById(resolutionId);

        if (resolution == null) {
            throw new RuntimeException("No such Id in database");
        }
        resolutionService.deleteResolutionById(resolutionId);
        return "Resolution successfully deleted";
    }
}
