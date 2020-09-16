package pl.bartekbak.imperator.dao;

import pl.bartekbak.imperator.entity.Contact;

import java.util.List;

public interface ContactDAO {

    public List<Contact> findAllContacts();

    public Contact findContactById(int id);

    public void saveContact(Contact contact);

    public void deleteContactById(int id);

}
