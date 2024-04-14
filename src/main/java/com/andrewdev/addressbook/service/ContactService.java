package com.andrewdev.addressbook.service;

import com.andrewdev.addressbook.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();
}
