package com.infy.serviece;

import com.infy.dto.UserDto;
import com.infy.exception.McartException;

public interface UserServiece {
	public boolean loginValidations(UserDto userDto) throws McartException;
	public String userRegistration(UserDto userDto) throws McartException;

}