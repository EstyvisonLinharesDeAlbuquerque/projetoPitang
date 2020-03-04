package com.pitang.treinamento.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pitang.treinamento.model.MessageModel;
import com.pitang.treinamento.model.UserModel;
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
		
		return messageRepository.save(message);
	}

	@Override
	public List<MessageModel> listMessages(Long id) {
		UserModel user = userRepository.findById(id).get();
		return user.getMessages();
	}

	@Override
	public void deleteMessages(Long id) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			messageRepository.deleteAll();
		}
		
	}
	
}
