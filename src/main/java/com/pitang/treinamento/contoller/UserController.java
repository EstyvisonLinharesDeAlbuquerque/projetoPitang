package com.pitang.treinamento.contoller;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitang.treinamento.dto.UserDto;
import com.pitang.treinamento.mapper.ModelMapperComponent;
import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.UserService;


@RestController
public class UserController {
	private UserService userService;
	

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<UserModel>> listUsers(){
		List<UserModel> users = userService.listUsers();
		
		if(users.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<UserDto> usersDto = ModelMapperComponent.modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> buscarUser(@PathVariable("id") Long id){
		List<UserModel> users = userService.listUsers();
		if(users.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		UserModel userModel = userService.buscarUser(id);
		
		return new ResponseEntity<>(userModel,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userDto){
		if(userDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.addUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserDto> updateUsers(@PathVariable("id") Long id, @RequestBody UserDto userDto){
		
		List<UserModel> users = userService.listUsers();
		if(users.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userModel = userService.updateUser(id ,userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserDto> removeUser(@PathVariable("id") Long id){
		
		List<UserModel> users = userService.listUsers();
		if(users.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userService.deleteUser(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}