package pl.bartekbak.imperator.service;

import org.springframework.stereotype.Service;
import pl.bartekbak.imperator.dao.ContactRepository;
import pl.bartekbak.imperator.entity.Contact;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceSpringData implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceSpringData(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findContactById(int id) {
        Optional<Contact> result = contactRepository.findById(id);
        Contact contact = null;
        if (result.isPresent()) {
            contact = result.get();
        } else {
            throw new RuntimeException("Contact Id not found");
        }

        return contact;
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(int id) {
        contactRepository.deleteById(id);
    }
}
