package com.StudentSystem.StudentSysLogin.service;

import com.StudentSystem.StudentSysLogin.model.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
