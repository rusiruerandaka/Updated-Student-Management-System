package com.example.Student.Management.System.Controller;

import com.example.Student.Management.System.model.Student;
import com.example.Student.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/student")
@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/dep/{id}")
    public String getdepartmentById(@PathVariable("id") Long id) {
        return studentService.getdepartmentById(id);
    }

    @GetMapping("/find/{yearOfEnrollment}")
    public ResponseEntity<List<Student>> getStudentByYearOfEnrollment(@PathVariable("yearOfEnrollment") int yearOfEnrollment) {
        List<Student> students = studentService.getStudentByYearOfEnrollment(yearOfEnrollment);
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/remove/{year}")
    public ResponseEntity<String> deleteStudentByYear(@PathVariable("year") int year) {
        studentService.deleteStudentByYear(year);
        return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
    }



}
