package pl.bartekbak.imperator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartekbak.imperator.entity.Resolution;

import java.util.List;

public interface ResolutionRepository extends JpaRepository<Resolution, Integer> {

    //sort by resolution resolutionNo
    public List<Resolution> findAllByOrderByResolutionIdAsc();
}
