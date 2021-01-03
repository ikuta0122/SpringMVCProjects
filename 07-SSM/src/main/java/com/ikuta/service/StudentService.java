package com.ikuta.service;

import com.ikuta.entity.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
}
