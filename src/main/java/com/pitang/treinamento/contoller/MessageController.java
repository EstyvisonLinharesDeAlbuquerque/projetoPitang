package com.pitang.treinamento.contoller;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitang.treinamento.dto.MessageDto;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.mapper.ModelMapperComponent;
import com.pitang.treinamento.model.*;
import com.pitang.treinamento.repository.ContactRepository;
import com.pitang.treinamento.repository.UserRepository;

@RestController
public class MessageController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value = "/message/{id}/{id2}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUsers(@PathVariable("id") Long id, @PathVariable("id2") Long id2, @RequestBody MessageDto messageDto){
		if(userRepository.findById(id).get() == null) {
			throw new ExceptionConflict("Usuário inexistente");
		}else {
			if(contactRepository.findById(id2).get() == null) {
				throw new ExceptionConflict("Contato inexistente na lista de usuário");
			}
		}
		
		UserModel user = userRepository.findById(id).get();
		messageDto.setSource(user);
		Contact contact = contactRepository.findById(id2).get();
		messageDto.setDestiny(contact);
		
		Message message = ModelMapperComponent.modelMapper.map(messageDto, new TypeToken<Contact>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		
		
	}
}
