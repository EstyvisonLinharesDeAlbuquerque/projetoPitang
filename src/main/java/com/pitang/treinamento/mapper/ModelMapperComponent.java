package com.pitang.treinamento.mapper;

import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.pitang.treinamento.dto.*;
import com.pitang.treinamento.model.*;

@Component
public class ModelMapperComponent {

	public static final ModelMapper modelMapper = new ModelMapper();

	@PostConstruct
	private void configureMapper() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		modelMapper.addMappings(new PropertyMap<UserModel, UserDto>() {
			@Override
			protected void configure() {

				map().setEmail(source.getEmail());
				map().setUsername(source.getUsername());
				map().setName(source.getName());
				map().setPassword(null);
				map().setContacts(source.getContacts());
				map().setMessages(source.getMessages());
			}
		});

		modelMapper.addMappings(new PropertyMap<UserDto, UserModel>() {
			@Override
			protected void configure() {

				map().setPassword(source.getPassword());
				map().setEmail(source.getEmail());
				map().setUsername(source.getUsername());
				map().setName(source.getName());
				map().setContacts(source.getContacts());
				map().setMessages(source.getMessages());
			}
		});

		modelMapper.addMappings(new PropertyMap<ContactDto, Contact>() {
			@Override
			protected void configure() {
				map().setName(source.getName());
				map().setFone(source.getFone());
				map().setUserModel(source.getUserModel());
			}
		});

		modelMapper.addMappings(new PropertyMap<Contact, ContactDto>() {
			@Override
			protected void configure() {
				map().setName(source.getName());
				map().setFone(source.getFone());
				map().setUserModel(source.getUserModel());
			}
		});

		modelMapper.addMappings(new PropertyMap<MessageModel, MessageDto>() {
			@Override
			protected void configure() {
				map().setMessage(source.getMessage());
				map().setDatetime(source.getDatetime());
				map().setDestiny(source.getDestiny());
				map().setSource(source.getSource());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<MessageDto, MessageModel>(){
			@Override
			protected void configure() {
				map().setMessage(source.getMessage());
				map().setDatetime(source.getDatetime());
				map().setDestiny(source.getDestiny());
				map().setSource(source.getSource());
			}
		});
	}
}
