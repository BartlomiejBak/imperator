package pl.bartekbak.imperator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartekbak.imperator.entity.Agreement;

import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    public List<Agreement> findAllByOrderByIdAsc();

}
