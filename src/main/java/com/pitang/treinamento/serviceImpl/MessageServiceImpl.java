package com.pitang.treinamento.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pitang.treinamento.model.MessageModel;
import com.pitang.treinamento.repository.MessageRepository;
import com.pitang.treinamento.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired 
	MessageRepository messageRepository;

	@Override
	public MessageModel sendMessage(MessageModel message) {
		
		return messageRepository.save(message);
	}
	
}
