package com.andrewdev.addressbook.service;

import com.andrewdev.addressbook.dao.ContactRepository;
import com.andrewdev.addressbook.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
