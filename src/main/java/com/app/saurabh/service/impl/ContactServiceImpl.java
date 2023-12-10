package com.app.saurabh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.saurabh.entity.Contact;
import com.app.saurabh.exception.ContactNotFoundException;
import com.app.saurabh.repo.ContactRepository;
import com.app.saurabh.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService{

	@Autowired
	private ContactRepository repo;
	
	public Integer saveStudent(Contact contact) {
		Integer id=repo.save(contact).getContId();
		return id;
	}

	public List<Contact> getAllContacts() {
		List<Contact>list=repo.findAll();
		return list;

	}


	public Contact getOneContact(Integer id) {
		
		return repo.findById(id)
				.orElseThrow(
						() -> new ContactNotFoundException("Contact ' " +id+" ' not exist")
						);
	}


	public void deleteContact(Integer id) {
		repo.delete(getOneContact(id));
		
	}

	@Override
	public void updateContact(Contact contact) {
		if(contact.getContId()==null || !repo.existsById(contact.getContId()))
			throw new ContactNotFoundException("Contact '"+contact.getContId()+"' not exist");
		else
			repo.save(contact);
		
		
	}

}
