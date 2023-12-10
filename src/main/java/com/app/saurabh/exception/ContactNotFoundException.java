package com.app.saurabh.exception;

@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException{

 public 	ContactNotFoundException() {
	 super();
	 
 }

	 public 	ContactNotFoundException(String message) {
		 super(message);
	 }

 }

