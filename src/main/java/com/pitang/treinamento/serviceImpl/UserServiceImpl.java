package com.pitang.treinamento.serviceImpl;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pitang.treinamento.exceptions.ExceptionBadRequest;
import java.util.Optional;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserModel> listUsers() {
		if (userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findAll();
	}

	@Override
	public UserModel findUserByEmail(String email) {
		if (userRepository.findAll().size() == 0) {
			return null;
		}
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public UserModel addUser(UserModel userModel) {
		validateUser(userModel);
		checkIntegrity(userModel);
		return userRepository.save(userModel);
	}
	
	
	@Override
	public UserModel updateUser(UserModel user) {
		if(user.getId() == null) {
			throw new ExceptionBadRequest("Necessário informar o id para atualizar!");
		}
		checkIntegrity(user);
		//validateUser(user);
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
		}
	}

	private void validateUser(UserModel user) {
		if (!StringUtils.isEmpty(user.getEmail()) && userRepository.findByEmail(user.getEmail()) != null) {
			throw new ExceptionConflict("Email informado já existe!");
		}
	}

	private void checkIntegrity(UserModel user) {
		checkMandatoryFields(user);
		}

	private void checkMandatoryFields(UserModel user) {
		if (user == null) {
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}
		if (StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("Necessário informar o Email do usuário.");
		}
		if (StringUtils.isEmpty(user.getName())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("Necessário informar a Senha do usuário.");
		}
		if (StringUtils.isEmpty(user.getUsername())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
	}
}
