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

				/*
				 * when(Conditions.isNotNull()).using(ModelConverter.convertStatus).map(source.
				 * isStatus()).setStatus(null);
				 * map().getUserProfileDto().setId(source.getUserProfile().getId());
				 * map().getUserProfileDto().setAddress1(source.getUserProfile().getAddress1());
				 * map().getUserProfileDto().setAddress2(source.getUserProfile().getAddress2());
				 * map().getUserProfileDto().setCity(source.getUserProfile().getCity());
				 * map().getUserProfileDto().setCountry(source.getUserProfile().getCountry());
				 * using(ModelConverter.fromDateToString).map(source.getUserProfile().
				 * getDateOfBirth()).getUserProfileDto().setDateOfBirth(null);
				 * map().getUserProfileDto().setPhoneNumber(source.getUserProfile().
				 * getPhoneNumber());
				 * map().getUserProfileDto().setState(source.getUserProfile().getState());
				 * map().getUserProfileDto().setStreet(source.getUserProfile().getStreet());
				 * map().getUserProfileDto().setZipCode(source.getUserProfile().getZipCode());
				 */

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
				/*
				 * when(Conditions.isNotNull()).using(ModelConverter.convertStatusToBoolean).map
				 * (source.getStatus()).setStatus(false); skip().setUserProfile(null);
				 */
			}
		});

		modelMapper.addMappings(new PropertyMap<ContactDto, Contact>() {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setName(source.getName());
				map().setFone(source.getFone());
				skip().setUserModel(null);
			}
		});

		modelMapper.addMappings(new PropertyMap<Contact, ContactDto>() {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setName(source.getName());
				map().setFone(source.getFone());
			}
		});
	}
}
