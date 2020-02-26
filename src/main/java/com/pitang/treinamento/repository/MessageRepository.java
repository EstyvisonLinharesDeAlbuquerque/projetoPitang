package com.pitang.treinamento.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.pitang.treinamento.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	Message findBySource(String source);
}
