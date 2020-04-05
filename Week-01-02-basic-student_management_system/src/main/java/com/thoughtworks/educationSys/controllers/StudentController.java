package com.thoughtworks.educationSys.controllers;

import com.thoughtworks.educationSys.entities.Student;
import com.thoughtworks.educationSys.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

  @GetMapping("/student/get/{name}")
  public Student getStudent(@PathVariable String name) {
    List<Student> matchedStudent = StudentRepository.getStudentList()
        .stream()
        .filter(student -> student.getName().equals(name))
        .collect(Collectors.toList());
    if (matchedStudent.isEmpty()) {
      return null;
    }
    return matchedStudent.get(0);
  }

  @GetMapping("/student/get/all")
  public Iterable<Student> getAllStudent() {
    return StudentRepository.getStudentList();
  }

  @PostMapping("student/insert")
  public String insertStudent(@RequestBody Student student) {
    boolean isDuplicateName = StudentRepository.getStudentList()
        .stream()
        .anyMatch(student1 -> student1.getName().equals(student.getName()));
    if (isDuplicateName) {
      return "姓名重复";
    }
    StudentRepository.getStudentList().add(student);
    return "添加成功";
  }

  @PostMapping("student/delete/{name}")
  public String deleteStudent(@PathVariable String name) {
    List<Student> matchedStudent = StudentRepository.getStudentList()
        .stream()
        .filter(student -> student.getName().equals(name))
        .collect(Collectors.toList());
    if (matchedStudent.isEmpty()) {
      return "该学生不存在";
    }
    StudentRepository.getStudentList().remove(matchedStudent.get(0));
    return "删除成功";
  }
}
