package com.example.student_manager.service;

import com.example.student_manager.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    void save(Student student);
    void delete(int id);
    void edit(Student student);
}
