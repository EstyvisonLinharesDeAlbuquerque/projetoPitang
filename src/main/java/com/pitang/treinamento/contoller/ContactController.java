package com.pitang.treinamento.contoller;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitang.treinamento.dto.*;
import com.pitang.treinamento.mapper.ModelMapperComponent;
import com.pitang.treinamento.model.*;
import com.pitang.treinamento.service.*;

@RestController
public class ContactController {
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ContactDto> addContacts(@RequestBody UserDto userDto, @RequestBody Contact contactDto) {

		if (userDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		Contact contact = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<Contact>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();

		contactService.addContact(userModel, contact);

		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		contactDto = ModelMapperComponent.modelMapper.map(contact, new TypeToken<ContactDto>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();

		return new ResponseEntity<>(HttpStatus.OK);
	
	}
}
