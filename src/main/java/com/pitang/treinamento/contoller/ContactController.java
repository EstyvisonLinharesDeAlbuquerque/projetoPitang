package com.pitang.treinamento.contoller;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitang.treinamento.dto.ContactDto;
import com.pitang.treinamento.mapper.ModelMapperComponent;
import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.service.ContactService;

@RestController
public class ContactController {
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ContactDto> addContacts(@PathVariable("id") Long id, @RequestBody Contact contactDto) {
		if(contactDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Contact contact = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<Contact>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();

		contactService.addContact(id, contact);

		
		contactDto = ModelMapperComponent.modelMapper.map(contact, new TypeToken<ContactDto>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();

		return new ResponseEntity<>(HttpStatus.OK);
	
	}
}
