package com.tat.f2fservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Student
{
	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
}
