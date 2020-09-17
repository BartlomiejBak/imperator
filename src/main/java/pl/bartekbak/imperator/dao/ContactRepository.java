package pl.bartekbak.imperator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.bartekbak.imperator.entity.Contact;

@RepositoryRestResource(path = "data") //optional, only to specify mapping address
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
