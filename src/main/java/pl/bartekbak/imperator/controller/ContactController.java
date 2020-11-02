package pl.bartekbak.imperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bartekbak.imperator.entity.Contact;
import pl.bartekbak.imperator.service.ContactService;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(@Qualifier("contactServiceSpringData") ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/list")
    public String listContacts(Model model) {
        List<Contact> contactList = contactService.findAllContacts();
        model.addAttribute("contacts", contactList);
        return "contacts/list-contacts";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);

        return "contacts/add-contact-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("contactId") int id, Model model) {
        Contact contact = contactService.findContactById(id);

        model.addAttribute("contact", contact);

        return "contacts/add-contact-form";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);

        //redirect prevents multiple saving
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("contactId") int id) {
        contactService.deleteContactById(id);
        return "redirect:list";
    }

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }


}