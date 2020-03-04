package com.pitang.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pitang.treinamento.model.Story;
import com.pitang.treinamento.model.UserModel;

public interface StoryRepository extends JpaRepository<Story, Long> {
	Story findByUserSource(UserModel user);
}
