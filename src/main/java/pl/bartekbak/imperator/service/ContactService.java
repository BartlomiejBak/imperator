package pl.bartekbak.imperator.service;

import pl.bartekbak.imperator.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> findAllContacts();

    public Contact findContactById(int id);

    public void saveContact(Contact contact);

    public void deleteContactById(int id);
}
