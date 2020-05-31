package com.todo.dto;

import java.util.Arrays;

public class UserDTO {

	private String userName;

	private char[] password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [userName=").append(userName).append(", password=").append(Arrays.toString(password))
				.append("]");
		return builder.toString();
	}

}
