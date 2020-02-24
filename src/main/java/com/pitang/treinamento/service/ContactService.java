package com.pitang.treinamento.service;

import java.util.List;
import com.pitang.treinamento.model.Contact;

public interface ContactService {
	
	public Contact addContact(Contact contact);
	
	public List<Contact> listContacts(Long id);
	
	public void removeContact(Long id);
	
}
