package com.tat.f2fservice.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFound extends RuntimeException
{
	public StudentNotFound(String message)
	{
		super(message);
	}
}
