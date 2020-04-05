package com.thoughtworks.educationSys.controllers;

import com.thoughtworks.educationSys.entities.Student;
import com.thoughtworks.educationSys.entities.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {

  private final StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @GetMapping("/student/get/{name}")
  public Student getStudent(@PathVariable String name) {
    return studentRepository.findById(name).orElse(null);
  }

  @GetMapping("/student/get/all")
  public Iterable<Student> getAllStudent() {
    return studentRepository.findAll();
  }

  @PostMapping("student/insert")
  public String insertStudent(@RequestBody Student student) {
    Optional<Student> studentInDatabase = studentRepository.findById(student.getName());
    if (studentInDatabase.isPresent()) {
      return "姓名重复";
    }
    studentRepository.insertNewStudent(student.getName(), student.getGender(), student.getKlass());
    return String.format(
        "添加成功, name:%s, gender:%s, class:%s",
        student.getName(),
        student.getGender(),
        student.getKlass());
  }

  @PostMapping("student/delete/{name}")
  public String deleteStudent(@PathVariable String name) {
    Optional<Student> student = studentRepository.findById(name);
    student.ifPresent(studentRepository::delete);
    return student.isPresent() ? "删除成功" : "该学生不存在";
  }
}
