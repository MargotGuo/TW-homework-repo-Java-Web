package com.thoughtworks.educationSys.controllers;

import com.thoughtworks.educationSys.entities.Student;
import com.thoughtworks.educationSys.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentRepository studentRepository = new StudentRepository();

  @GetMapping("/student/get/{name}")
  public Student getStudent(@PathVariable String name) {
    return studentRepository.getStudent(name).orElse(null);
  }

  @GetMapping("/student/get/all")
  public Iterable<Student> getAllStudent() {
    return studentRepository.getStudentList();
  }

  @PostMapping("student/insert")
  public String insertStudent(@RequestBody Student student) {
    boolean hasStudent = studentRepository.hasStudent(student.getName());
    if (!hasStudent) {
      studentRepository.add(student);
    }
    return hasStudent ? "姓名重复" : "添加成功";
  }

  @PostMapping("student/delete/{name}")
  public String deleteStudent(@PathVariable String name) {
    boolean hasStudent = studentRepository.hasStudent(name);
    if (hasStudent) {
      studentRepository.delete(name);
    }
    return hasStudent ? "删除成功" : "该学生不存在";
  }
}
