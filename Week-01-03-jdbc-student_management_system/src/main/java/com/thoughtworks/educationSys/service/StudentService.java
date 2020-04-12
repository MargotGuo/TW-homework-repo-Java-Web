package com.thoughtworks.educationSys.service;

import com.thoughtworks.educationSys.entities.Student;
import com.thoughtworks.educationSys.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student findByStudentName(String name) {
    return studentRepository.findById(name).orElse(null);
  }

  public Iterable<Student> findAllStudent() {
    return studentRepository.findAll();
  }

  public boolean studentIsInDatabase(Student student) {
    Optional<Student> studentInDatabase = studentRepository.findById(student.getName());
    return studentInDatabase.isPresent();
  }

  public boolean studentIsInDatabase(String name) {
    return studentRepository.findById(name).isPresent();
  }

  public void insertNewStudent(Student student) {
    studentRepository.insertNewStudent(student.getName(), student.getGender(), student.getKlass());
  }

  public void deleteStudent(Student student) {
    studentRepository.delete(student);
  }
}
