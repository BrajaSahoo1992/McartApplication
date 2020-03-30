package com.infy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.UserDto;
import com.infy.exception.McartException;
import com.infy.serviece.UserServiece;

@RestController
public class UserController {
	@Autowired
	UserServiece userServiece;
	
	@PostMapping("/login")
	public  ResponseEntity<Boolean> validaiteLoginDetails(@Valid @RequestBody UserDto userDto) throws McartException{
		boolean val= userServiece.loginValidations(userDto);
		return new ResponseEntity<Boolean>(val, HttpStatus.OK);
		
		
	}
	@PostMapping("/signup")
	public ResponseEntity<String> userRegistration( @Valid @RequestBody UserDto userDto) throws McartException{
		String val=userServiece.userRegistration(userDto);
		return new ResponseEntity<String>(val,HttpStatus.OK);
		
		
	}

}
