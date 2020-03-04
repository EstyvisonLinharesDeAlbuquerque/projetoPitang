package com.pitang.treinamento.contoller;

import java.time.LocalDateTime;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.treinamento.dto.MessageDto;
import com.pitang.treinamento.dto.StoryDto;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.mapper.ModelMapperComponent;
import com.pitang.treinamento.model.MessageModel;
import com.pitang.treinamento.model.Story;
import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.StoryService;

@RestController
public class StoryController {
	private StoryService storyService;

	@Autowired
	UserRepository userRepository;

	public StoryController(StoryService storyService) {
		super();
		this.storyService = storyService;
	}

	@RequestMapping(value = "/story/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> sendStories(@PathVariable("id") Long id, @RequestBody StoryDto storyDto) {
		if (userRepository.findById(id).get() == null) {
			throw new ExceptionConflict("Usuário inexistente");
		}
		UserModel user = userRepository.findById(id).get();
		storyDto.setUserSource(user);
		storyDto.setStatus(true);
		LocalDateTime agora = LocalDateTime.now();
		storyDto.setDatetime(agora);
		
		Story story = ModelMapperComponent.modelMapper.map(storyDto, new TypeToken<Story>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		storyService.addStory(story);
		
		storyDto = ModelMapperComponent.modelMapper.map(story, new TypeToken<StoryDto>() {
		}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>("Story enviado com sucesso", HttpStatus.OK);
	}

}