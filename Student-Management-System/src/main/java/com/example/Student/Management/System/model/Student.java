package com.example.Student.Management.System.model;

import lombok.Data;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname",nullable = false)
    private String firstName;
    @Column(name = "lastname",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "department",nullable = false)
    private String department;
    @Column(name = "yearofenrollment")
    private int yearOfEnrollment;


}
