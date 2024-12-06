package com.StudentSystem.StudentSysLogin.service;

import com.StudentSystem.StudentSysLogin.model.Student;
import com.StudentSystem.StudentSysLogin.repositery.StudentRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepositery studentRepositery;
    @Override
    public Student saveStudent(Student student) {
        return studentRepositery.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepositery.findAll();
    }
}
