package com.google.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.phonebook.model.Contact;
import com.google.phonebook.repo.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> contact = contactRepository.findById(contactId);
		if(contact.isPresent()) {
			return contact.get();
		}
		return new Contact();
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		try {
			contactRepository.deleteById(contactId);
		} catch(Exception e) {
			log.error("ContactServiceImpl :: deleteContactById :: "+e.getMessage());
		}
		return true;
	}

}
