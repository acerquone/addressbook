package com.andrewdev.addressbook.controller;

import com.andrewdev.addressbook.entity.Contact;
import com.andrewdev.addressbook.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/list")
    public String listContacts(Model model){

        List<Contact> contactList = contactService.findAll();

        model.addAttribute("contactList",contactList);

        return "list-contacts";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model){

        Contact theContact = new Contact();

        model.addAttribute("contact",theContact);

        return "contact-form";
    }

    @PostMapping("/save")
    public String saveContact(@Valid @ModelAttribute("contact") Contact theContact, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "contact-form";
        }

        this.contactService.saveContact(theContact);

        return "redirect:/contacts/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("contactID") Integer id, Model model){
        Contact theContact = contactService.findByID(id);
        model.addAttribute("contact",theContact);
        return "contact-form";
    }
}
