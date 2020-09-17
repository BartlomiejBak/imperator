package pl.bartekbak.imperator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.bartekbak.imperator.entity.Contact;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ContactDaoJPA implements ContactDAO {

    private EntityManager entityManager;

    @Autowired
    public ContactDaoJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Contact> findAllContacts() {
        //create a query
        Query query = entityManager.createQuery("from Contact ");

        //execute query and get result list
        List<Contact> contactList = query.getResultList();

        //return results
        return contactList;
    }

    @Override
    public Contact findContactById(int id) {
        //get contact
        Contact contact = entityManager.find(Contact.class, id);

        //return contact
        return contact;
    }

    @Override
    public void saveContact(Contact contact) {
        //save or update contact
        Contact contactDb = entityManager.merge(contact);

        //update with id from db
        contact.setId(contactDb.getId());
    }

    @Override
    public void deleteContactById(int id) {
        //delete contact
        Query query = entityManager.createQuery("delete from Contact where id=:contactId");
        query.setParameter("contactId", id);
        query.executeUpdate();
    }
}
