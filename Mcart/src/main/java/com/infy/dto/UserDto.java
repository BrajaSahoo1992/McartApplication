package com.infy.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.infy.entity.User;

public class UserDto {
	
	@NotNull(message="username is mandatory")
	@Size(min=2, max=10,message="Username should be min 2 and max 10 characters")
	private String username;
	@NotNull
	@Size(min=8, max=15,message="Username should be min 10 and max 15 characters")
	private String password;
	@NotNull(message="PhoneNumber is mandatory")
	@Size(min=10,max=10,message="PhoneNumber must be 10 digits")
	private String phoneNumber;
	@NotNull(message="Email id is mandatory")
	@Email(message="emailId is not in valid format")
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 public static User convertToUser(UserDto userDto){
		 User user=new User();
		 user.setUsername(userDto.getUsername());
		 user.setPassword(userDto.getPassword());
		 user.setEmail(userDto.getEmail());
		 user.setPhoneNumber(userDto.getPhoneNumber());
		 return user;
		 
	 }
	 public static UserDto convertToUserDto(User user){
		 UserDto useDtor=new UserDto();
		 useDtor.setUsername(user.getUsername());
		 useDtor.setPassword(user.getPassword());
		 useDtor.setEmail(user.getEmail());
		 useDtor.setPhoneNumber(user.getPhoneNumber());
		 return useDtor;
		 
	 }

}
