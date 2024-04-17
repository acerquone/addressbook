package com.andrewdev.addressbook.service;

import com.andrewdev.addressbook.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> findAll();

    public Contact findByID(Integer id);

    public void saveContact(Contact theContact);
}
