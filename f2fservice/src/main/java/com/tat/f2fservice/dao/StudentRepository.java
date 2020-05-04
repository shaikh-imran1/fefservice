package com.tat.f2fservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tat.f2fservice.dto.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
