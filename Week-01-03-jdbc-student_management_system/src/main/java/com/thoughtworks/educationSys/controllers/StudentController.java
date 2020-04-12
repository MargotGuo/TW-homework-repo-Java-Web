package com.thoughtworks.educationSys.controllers;

import com.thoughtworks.educationSys.entities.Student;
import com.thoughtworks.educationSys.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/student/get/{name}")
  public Student getStudent(@PathVariable String name) {
    return studentService.findByStudentName(name);
  }

  @GetMapping("/student/get/all")
  public Iterable<Student> getAllStudent() {
    return studentService.findAllStudent();
  }

  @PostMapping("student/insert")
  public String insertStudent(@RequestBody Student student) {
    if (studentService.studentIsInDatabase(student)) {
      return "姓名重复";
    }
    studentService.insertNewStudent(student);
    return String.format(
        "添加成功, name:%s, gender:%s, class:%s",
        student.getName(),
        student.getGender(),
        student.getKlass());
  }

  @PostMapping("student/delete/{name}")
  public String deleteStudent(@PathVariable String name) {
    if (studentService.studentIsInDatabase(name)) {
      Student student = studentService.findByStudentName(name);
      studentService.deleteStudent(student);
      return "删除成功";
    }
    return "该学生不存在";
  }
}
