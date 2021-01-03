package com.ikuta.dao;

import com.ikuta.entity.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
