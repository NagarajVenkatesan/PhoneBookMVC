package com.google.phonebook.service;

import java.util.List;

import com.google.phonebook.model.Contact;

public interface ContactService {

	public Contact saveContact(Contact contact);
	
	public Contact getContactById(Integer contactId);
	
	public List<Contact> getAllContacts();
	
	public Contact updateContact(Contact contact);
	
	public boolean deleteContactById(Integer contactId);
}
