package com.pitang.treinamento.service;

import java.util.List;
import com.pitang.treinamento.model.Story;

public interface StoryService {
	public Story addStory(Story story);
	public List<Story> listStories(Long id);
	public Story addView(Story story);
}
