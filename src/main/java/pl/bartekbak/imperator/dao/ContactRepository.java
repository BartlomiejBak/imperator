package pl.bartekbak.imperator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartekbak.imperator.entity.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    //sort by last name
    public List<Contact> findAllByOrderByLastNameAsc();
}
