package com.pitang.treinamento.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pitang.treinamento.exceptions.ExceptionBadRequest;
import com.pitang.treinamento.model.Story;
import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.StoryRepository;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.StoryService;


@Service
public class StoryServiceImpl implements StoryService {

	@Autowired 
	private StoryRepository storyRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Story addStory(Story story) {
		
		return storyRepository.save(story);
	}

	@Override
	public List<Story> listStories(Long id) {
		UserModel user = userRepository.findById(id).get();
		return user.getStory();
	}
	/*
	@Override
	public Story addView(Long id, Story story) {
		checkStoryIntegrity(id, story);
		return storyRepository.save(story);
	}
	
	private void checkStoryIntegrity(Long id, Story story) {
		if (listStories(id) == null) {
			throw new ExceptionBadRequest("O story não pode ser nulo.");
		}
	}
*/
	@Override
	public void deleteStory(Long id, Long id2) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			storyRepository.deleteById(id2);
		}
		
		
	}
	
}
