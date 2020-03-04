package com.pitang.treinamento.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Story addView(Story story) {
		
		return storyRepository.save(story);
	}
	
	
}
