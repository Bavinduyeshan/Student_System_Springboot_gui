package com.StudentSystem.StudentSysLogin.repositery;

import com.StudentSystem.StudentSysLogin.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepositery extends JpaRepository<Student,Integer> {
}
