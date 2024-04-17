package com.andrewdev.addressbook.service;

import com.andrewdev.addressbook.dao.ContactRepository;
import com.andrewdev.addressbook.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImple implements ContactService{

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImple(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findByID(Integer id) {
        Optional<Contact> result = this.contactRepository.findById(id);
        Contact theContact = null;
        if (result.isPresent()){
            theContact = result.get();
        }
        else {
            throw new RuntimeException("Contact of id: " + id + " not found.");
        }

        return theContact;
    }

    @Override
    public void saveContact(Contact theContact) {
        contactRepository.save(theContact);
    }
}
