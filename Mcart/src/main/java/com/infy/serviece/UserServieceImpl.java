package com.infy.serviece;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserDto;
import com.infy.entity.User;
import com.infy.exception.McartException;
import com.infy.repository.UserRepository;
@Service("userServieceImpl")
public class UserServieceImpl implements UserServiece{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public boolean loginValidations(UserDto userDto) throws McartException {
	Optional<User> user =	userRepo.findById(userDto.getUsername());
	if(user.isPresent()){
		if(user.get().getPassword().equals(userDto.getPassword())){
			return true;
		}
		else{
			
	throw new McartException("Invalid Password");
		}
	}
	else{
		throw new McartException("Invalid userName");
	}
		
	}

	@Override
	public String userRegistration(UserDto userDto) throws McartException{
		User user=UserDto.convertToUser(userDto);
		Optional<User> userDetails =	userRepo.findById(user.getUsername());
		if(userDetails.isPresent()){
			throw new McartException("User Already Registered");
		}
		else{
		userRepo.saveAndFlush(user);
		return "User registered with Name :"+user.getUsername();
		}
		
		
		
	}

}
