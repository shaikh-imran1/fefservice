package com.tat.f2fservice.controller;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tat.f2fservice.dto.Student;
import com.tat.f2fservice.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller
{
	private final StudentService studentService;
	
	@GetMapping(path = "/getMessage")
	public String getMessage()
	{
		return "Hello bello and mello";
	}
	
	@GetMapping(path = "getStudent")
	public Student getStudent(@RequestParam(value = "id") int id)
	{
		return studentService.getStudent(id);
	}
	
	@PostMapping(path = "addStudent")
	public Resource<Student> addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping(path = "getAllStudents")
	public List<Resource<Student>> getAllStudents()
	{
		return studentService.getAllStudents();
	}
}
