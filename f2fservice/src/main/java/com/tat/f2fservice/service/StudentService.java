package com.tat.f2fservice.service;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import com.tat.f2fservice.dto.Student;

@Service
public interface StudentService
{
	Student getStudent(int id);
	Resource<Student> addStudent(Student student);
	List<Resource<Student>> getAllStudents();
}

