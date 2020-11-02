package pl.bartekbak.imperator.service;

import pl.bartekbak.imperator.entity.Resolution;

import java.util.List;

public interface ResolutionService {

    public List<Resolution> findAllResolutions();

    public Resolution findResolutionById(int id);

    public void saveResolution(Resolution resolution);

    public void deleteResolutionById(int id);
}
