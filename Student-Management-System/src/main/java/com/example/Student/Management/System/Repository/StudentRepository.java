package com.example.Student.Management.System.Repository;

import com.example.Student.Management.System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

}
