package com.pitang.treinamento.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pitang.treinamento.exceptions.ExceptionBadRequest;
import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.model.MessageModel;
import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.ContactRepository;
import com.pitang.treinamento.repository.MessageRepository;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired 
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public MessageModel sendMessage(MessageModel message) {
		checkIntegrityMessage(message);
		return messageRepository.save(message);
	}

	@Override
	public List<MessageModel> listMessages(Long id) {
		UserModel user = userRepository.findById(id).get();
		return user.getMessages();
	}

	@Override
	public void deleteMessages(Long id, Long id2) {
		MessageModel message = messageRepository.findById(id2).get();
		if(id == message.getSource().getId()) {
			message.setStatusSource(false);
			messageRepository.save(message);
		}else {
			throw new ExceptionBadRequest("O usuário não é a fonte dessa mensagem.");
		}
	}
	
	private void checkIntegrityMessage(MessageModel message) {
		
		if (StringUtils.isEmpty(message.getMessage())) {
			throw new ExceptionBadRequest("A mensagem não pode ser nula.");
		}
		if (StringUtils.isEmpty(message.getDestiny())) {
			throw new ExceptionBadRequest("O destino é inexistente.");
		}
	}

	@Override
	public void deleteMessages(Long id, Long id2, Long id3) {
		MessageModel message = messageRepository.findById(id3).get();
		if((id == message.getSource().getId()) && (id2 == message.getDestiny().getId())) {
			message.setStatusSource(false);
			message.setStatusDestiny(false);
			messageRepository.save(message);
		}else {
			throw new ExceptionBadRequest("O usuário ou contato não são fontes válidas para essa mensagem.");
		}
	}
}
