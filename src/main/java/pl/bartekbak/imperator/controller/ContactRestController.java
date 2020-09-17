package pl.bartekbak.imperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.bartekbak.imperator.entity.Contact;
import pl.bartekbak.imperator.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactRestController {

    private ContactService contactService;

    @Autowired
    public ContactRestController(@Qualifier("contactServiceSpringData") ContactService contactService) {
        this.contactService = contactService;
    }

    //expose "/contacts" and return list of contacts
    @GetMapping("/contacts")
    public List<Contact> findAll() {
        return contactService.findAllContacts();
    }


    @GetMapping("/contacts/{contactId}")
    public Contact getContact(@PathVariable int contactId) {
        Contact contact = contactService.findContactById(contactId);

        if (contact == null) {
            throw new RuntimeException("No such Id in database");
        }
        return contact;
    }

    //add mapping for POST /contact - add new contact
    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {

        //set id to 0 to force a save of new item instead of update
        contact.setId(0);

        contactService.saveContact(contact);
        return contact;
    }

    //add mapping for PUT /contacts - update existing contact
    @PutMapping("/contacts")
    public Contact updateContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return contact;
    }

    //add mapping for DELETE /contacts/{contactId} - delete contact
    @DeleteMapping("/contacts/{contactId}")
    public String deleteContact(@PathVariable int contactId) {
        Contact contact = contactService.findContactById(contactId);

        if (contact == null) {
            throw new RuntimeException("No such Id in database");
        }
        contactService.deleteContactById(contactId);
        return "Contact successfully deleted";
    }
}
