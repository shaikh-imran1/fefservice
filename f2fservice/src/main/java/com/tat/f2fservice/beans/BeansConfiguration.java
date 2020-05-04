package com.tat.f2fservice.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tat.f2fservice.dao.StudentRepository;
import com.tat.f2fservice.service.StudentService;
import com.tat.f2fservice.service.StudentServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeansConfiguration
{
	private final StudentRepository studentRepository;
	
	@Bean
	public StudentService studentService()
	{
		return new StudentServiceImpl(studentRepository);
	}
}
