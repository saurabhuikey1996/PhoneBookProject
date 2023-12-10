package com.app.saurabh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.saurabh.entity.Contact;
import com.app.saurabh.exception.ContactNotFoundException;
import com.app.saurabh.service.IContactService;

@RestController
@RequestMapping("/v1/api/contact")
public class ContactRestController {
	
	@Autowired
	private IContactService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveContact(
			@RequestBody   Contact contact) 
	{
		Integer id = service.saveStudent(contact);
		return new ResponseEntity<String>(
				"Student '"+id+"' Created", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Contact>>getAllContact(){
		List<Contact>list=service.getAllContacts();
		return new ResponseEntity<List<Contact>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?>fetchOneContact(
			@PathVariable Integer id)
	{
		ResponseEntity<?>response=null;
		try {
			Contact contact=service.getOneContact(id);
			response =new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}catch(ContactNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
				return response;
		
	}
	
	@DeleteMapping("/remove/{id}")
	//@ApiIgnore //please do not show this AT Swagger
	public ResponseEntity<String>deleteContact(
			@PathVariable Integer id)
	{
		ResponseEntity<String> response=null;
		try {
			service.deleteContact(id);
			response =new ResponseEntity<String>(
			"Student  '"+id+"' Deleted", HttpStatus.OK);
		}catch(ContactNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
			}
		return response;
	}
	
	
	@PutMapping("/modify")
	public ResponseEntity<String>updateContact(
			@RequestBody Contact contact
			)
	{
		ResponseEntity<String> response=null;
		try {
			service.updateContact(contact);
			response =new ResponseEntity<String>(
			"Student '"+contact.getContId()+"' Update", 
			HttpStatus.OK);
		}catch(ContactNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
			}
		return response;

	}
}
