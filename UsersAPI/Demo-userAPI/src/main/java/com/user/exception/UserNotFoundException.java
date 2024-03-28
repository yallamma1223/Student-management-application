package com.user.exception;

public class UserNotFoundException extends RuntimeException 
{

	public UserNotFoundException (int id) 
	{
		super("Could Not Found id"+id);
	}
}
