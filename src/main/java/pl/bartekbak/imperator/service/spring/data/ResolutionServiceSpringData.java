package pl.bartekbak.imperator.service.spring.data;

import org.springframework.stereotype.Service;
import pl.bartekbak.imperator.dao.ResolutionRepository;
import pl.bartekbak.imperator.entity.Resolution;
import pl.bartekbak.imperator.service.ResolutionService;

import java.util.List;
import java.util.Optional;

@Service
public class ResolutionServiceSpringData implements ResolutionService {

    private ResolutionRepository resolutionRepository;

    public ResolutionServiceSpringData(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    @Override
    public List<Resolution> findAllResolutions() {
        return resolutionRepository.findAllByOrderByResolutionIdAsc();
    }

    @Override
    public Resolution findResolutionById(int id) {
        Optional<Resolution> result = resolutionRepository.findById(id);
        Resolution resolution = null;
        if (result.isPresent()) {
            resolution = result.get();
        } else {
            throw new RuntimeException("Resolution Id not found");
        }

        return resolution;
    }

    @Override
    public void saveResolution(Resolution resolution) {
        resolutionRepository.save(resolution);
    }

    @Override
    public void deleteResolutionById(int id) {
        resolutionRepository.deleteById(id);
    }
}
