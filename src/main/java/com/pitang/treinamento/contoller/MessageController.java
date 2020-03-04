package com.pitang.treinamento.contoller;
import java.time.LocalDateTime;
import java.util.List;

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
import com.pitang.treinamento.service.MessageService;

@RestController
public class MessageController {
	private MessageService messageService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	
	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<MessageModel>> listMessages(@PathVariable("id") Long id){
		List<MessageModel> messages = messageService.listMessages(id);

		return new ResponseEntity<>(messages, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/message/{id}/{id2}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> sendMessages(@PathVariable("id") Long id, @PathVariable("id2") Long id2, @RequestBody MessageDto messageDto){
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
		LocalDateTime agora = LocalDateTime.now();
		messageDto.setDatetime(agora);
		messageDto.setStatusDestiny(true);
		messageDto.setStatusSource(true);
		
		
		MessageModel message = ModelMapperComponent.modelMapper.map(messageDto, new TypeToken<MessageModel>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		messageService.sendMessage(message);
		
		messageDto = ModelMapperComponent.modelMapper.map(message, new TypeToken<MessageDto>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>("Mensagem enviada com sucesso", HttpStatus.OK);
		}
	
	@RequestMapping(value = "/message/{id}/{id2}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteAllMessages(@PathVariable("id") Long id, Long id2) {
		if (messageService.listMessages(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		messageService.deleteMessages(id, id2);
		
		return new ResponseEntity<>("Conversa apagada com sucesso!",HttpStatus.OK);
	}
}
