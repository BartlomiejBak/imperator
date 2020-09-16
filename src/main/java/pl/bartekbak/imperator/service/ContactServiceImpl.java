package pl.bartekbak.imperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartekbak.imperator.dao.ContactDAO;
import pl.bartekbak.imperator.entity.Contact;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;

    @Autowired
    public ContactServiceImpl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    @Transactional
    public List<Contact> findAllContacts() {
        return contactDAO.findAllContacts();
    }

    @Override
    @Transactional
    public Contact findContactById(int id) {
        return contactDAO.findContactById(id);
    }

    @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactDAO.saveContact(contact);
    }

    @Override
    @Transactional
    public void deleteContactById(int id) {
        contactDAO.deleteContactById(id);
    }
}
