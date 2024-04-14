package com.andrewdev.addressbook.dao;


import com.andrewdev.addressbook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {


}
