package com.pitang.treinamento.service;

import java.util.List;

import com.pitang.treinamento.model.MessageModel;

public interface MessageService {
	public MessageModel sendMessage(MessageModel message);
	public List<MessageModel> listMessages(Long id);
	public void deleteMessages(Long id, Long id2);
	public void deleteMessages(Long id, Long id2, Long id3);
}
