package com.google.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.phonebook.model.Contact;
import com.google.phonebook.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
		model.addAttribute("contacts", contactService.getAllContacts());
		return "index";
	}
	
	@GetMapping("/contact")
	public String addNewContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "addContact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/";
	}
	
	@GetMapping("/updateContactForm/{id}")
	public String updateContactForm(@PathVariable(value = "id") int id, Model model) {
		Contact contact = contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "updateContact";
	}
		
	@GetMapping("/deleteContact/{id}")
    public String deleteContactById(@PathVariable(value = "id") int id) {
        contactService.deleteContactById(id);
        return "redirect:/";
 
    }
}
