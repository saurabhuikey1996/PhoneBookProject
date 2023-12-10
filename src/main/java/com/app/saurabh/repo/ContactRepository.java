package com.app.saurabh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.saurabh.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
