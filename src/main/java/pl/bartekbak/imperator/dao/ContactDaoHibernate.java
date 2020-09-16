package pl.bartekbak.imperator.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bartekbak.imperator.entity.Contact;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ContactDaoHibernate implements ContactDAO {

    //define field for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired //
    public ContactDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Contact> findAllContacts() {

        //get the hibernate current session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Contact> contactQuery = currentSession.createQuery("from Contact", Contact.class);

        //execute query and get result list
        List<Contact> contactList = contactQuery.getResultList();

        //return the results
        return contactList;
    }

    @Override
    public Contact findContactById(int id) {

        //get the hibernate current session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the contact
        Contact contact = currentSession.get(Contact.class, id);

        //return contact
        return contact;
    }

    @Override
    public void saveContact(Contact contact) {

        //get the hibernate current session
        Session currentSession = entityManager.unwrap(Session.class);

        //save or update contact
        currentSession.saveOrUpdate(contact);
    }

    @Override
    public void deleteContactById(int id) {

        //get the hibernate current session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key
        Query query = currentSession.createQuery(
                "delete from Contact where id=:contactId");
        query.setParameter("contactId", id);
        query.executeUpdate();
    }
}
