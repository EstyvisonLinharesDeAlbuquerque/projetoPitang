package com.pitang.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.model.MessageModel;
import com.pitang.treinamento.model.UserModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {
	MessageModel findBySource(UserModel source);
	MessageModel findByDestiny(Contact destiny);
}
