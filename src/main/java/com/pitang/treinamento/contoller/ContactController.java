package com.pitang.treinamento.contoller;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitang.treinamento.dto.ContactDto;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.mapper.ModelMapperComponent;
import com.pitang.treinamento.model.*;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.ContactService;


@RestController
public class ContactController {
	private ContactService contactService;
	
	@Autowired
	private UserRepository userRepository;
	

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addContacts(@PathVariable("id") Long id, @RequestBody ContactDto contactDto) {
		if (userRepository.findById(id).get() == null) {
			throw new ExceptionConflict("Usuário inexistente");
		}
		
		UserModel user = userRepository.findById(id).get();
		contactDto.setUserModel(user);
		
		Contact contact = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<Contact>() {}.getType());
		ModelMapperComponent.modelMapper.validate();

		contactService.addContact(contact);

		contactDto = ModelMapperComponent.modelMapper.map(contact, new TypeToken<ContactDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();

		return new ResponseEntity<>(contactDto,HttpStatus.OK);
	}
}
