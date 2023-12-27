package com.example.student_manager.service;

import com.example.student_manager.model.Student;
import com.example.student_manager.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);

    }

    @Override
    public void delete(int id) {
     iStudentRepository.deleteById(id);
    }

    @Override
    public void edit(Student student) {
        iStudentRepository.save(student);

    }
}
