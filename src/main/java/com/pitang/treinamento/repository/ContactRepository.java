package com.pitang.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pitang.treinamento.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {
	Contact findByName(String name);
	Contact findByFone(String fone);
}
