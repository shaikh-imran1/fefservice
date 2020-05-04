package com.tat.f2fservice.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.tat.f2fservice.ExceptionHandle.StudentNotFound;
import com.tat.f2fservice.controller.Controller;
import com.tat.f2fservice.dao.StudentRepository;
import com.tat.f2fservice.dto.Student;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService
{
	private final StudentRepository studentRepository;

	@Override
	public Student getStudent(int id)
	{
		if (!studentRepository.existsById(id))
			throw new StudentNotFound("Student Id " + id + " is not available");
		return studentRepository.findById(id).get();
	}

	@Override
	public Resource<Student> addStudent(Student student)
	{
		studentRepository.save(student);
		Resource<Student> entityModel = new Resource<Student>(student);
		ControllerLinkBuilder  link = linkTo(methodOn(Controller.class).getAllStudents());
		entityModel.add(link.withRel("All Students").withTitle("All Student link").withType("application/json"));
		
		return entityModel;
	}

	@Override
	public List<Resource<Student>> getAllStudents()
	{
		List<Student> listOfStudent = studentRepository.findAll();
		if (listOfStudent.isEmpty())
			throw new StudentNotFound("Student table is empty");
		
		List<Resource<Student>> listOfEntityModel = new ArrayList<Resource<Student>>();
		for (Student student : listOfStudent)
		{
			Resource<Student> entityModel = new Resource<Student>(student);
			ControllerLinkBuilder link = linkTo(methodOn(Controller.class).getStudent(student.getId()));
			entityModel.add(link.withRel("get Student By student Id " + student.getId()).withTitle("Student Id" + student.getId())
					.withType("application/json"));
			listOfEntityModel.add(entityModel);
		}
		
		return listOfEntityModel;
	}
	
	
	
	
	

}
