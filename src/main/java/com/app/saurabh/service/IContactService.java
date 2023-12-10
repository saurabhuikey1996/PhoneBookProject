package com.app.saurabh.service;

import java.util.List;

import com.app.saurabh.entity.Contact;

public interface IContactService {

	Integer saveStudent(Contact contact);
	List<Contact>getAllContacts();
	Contact getOneContact(Integer id);
	void deleteContact(Integer id);
	void updateContact(Contact contact);
	
}
