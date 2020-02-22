package com.pitang.treinamento.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.pitang.treinamento.exceptions.ExceptionBadRequest;
//import java.util.Optional;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.model.*;
import com.pitang.treinamento.repository.ContactRepository;
//import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.*;
import com.pitang.treinamento.serviceImpl.UserServiceImpl;

@Service
public class ContactServiceImpl implements ContactService {
	private UserService userService;
	
	@Autowired
	private ContactRepository contactRepository;
	

	@Override
	public Contact addContact(Long id, Contact contact) {
		if(!userService.verifyUser(id)) {
			throw new ExceptionConflict("Usuário inexistente");
		}
		validateContact(contact);
		checkIntegrityContact(contact);
		return contactRepository.save(contact);
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
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}
		if (StringUtils.isEmpty(contact.getName())) {
			throw new ExceptionBadRequest("Necessário informar o nome do contato");
		}
		if (StringUtils.isEmpty(contact.getFone())) {
			throw new ExceptionBadRequest("Necessário informar o número do contato");
		}
	}
}
