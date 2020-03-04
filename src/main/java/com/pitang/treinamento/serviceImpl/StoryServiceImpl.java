package com.pitang.treinamento.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.treinamento.model.Story;
import com.pitang.treinamento.repository.StoryRepository;
import com.pitang.treinamento.service.StoryService;


@Service
public class StoryServiceImpl implements StoryService {

	@Autowired 
	private StoryRepository storyRepository;

	@Override
	public Story addStory(Story story) {
		
		return storyRepository.save(story);
	}
}
