package com.example.Student.Management.System.service.impl;

import com.example.Student.Management.System.Repository.StudentRepository;
import com.example.Student.Management.System.model.Student;
import com.example.Student.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new RuntimeException();
        }}

    @Override
    public String getdepartmentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get().getDepartment();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Student> getStudentByYearOfEnrollment(int yearOfEnrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        return studentRepository.save(existingStudent);
    }


    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteStudentByYear(int year) {
        List<Student> students = studentRepository.findByYearOfEnrollment(year);
        studentRepository.deleteAll(students);
    }
}
