package com.pitang.treinamento.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.pitang.treinamento.exceptions.ExceptionBadRequest;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.model.*;
import com.pitang.treinamento.repository.ContactRepository;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.*;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<Contact> listContacts(Long id) {
		UserModel user = userRepository.findById(id).get();
		return user.getContacts();
		
	}
	
	@Override
	public Contact addContact(Contact contact) {
		validateContact(contact);
		checkIntegrityContact(contact);
		return contactRepository.save(contact);
	}

	@Override
	public void deleteContact(Long id, Long id2) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			contactRepository.deleteById(id2);
		}
		
	}

	private void validateContact(Contact contact) {
		if (!StringUtils.isEmpty(contact.getName()) && contactRepository.findByName(contact.getName()) != null) {
			throw new ExceptionConflict("Nome informado já existe!");
		}
		if (!StringUtils.isEmpty(contact.getFone()) && contactRepository.findByFone(contact.getFone()) != null) {
			throw new ExceptionConflict("Fone informado já existe!");
		}
	}

	private void checkIntegrityContact(Contact contact) {
		if (contact == null) {
			throw new ExceptionBadRequest("Contato não pode ser nulo!");
		}
		if (StringUtils.isEmpty(contact.getName())) {
			throw new ExceptionBadRequest("Necessário informar o nome do contato");
		}
		if (StringUtils.isEmpty(contact.getFone())) {
			throw new ExceptionBadRequest("Necessário informar o número do contato");
		}
	}
}
