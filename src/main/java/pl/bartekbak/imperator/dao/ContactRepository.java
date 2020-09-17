package pl.bartekbak.imperator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartekbak.imperator.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
