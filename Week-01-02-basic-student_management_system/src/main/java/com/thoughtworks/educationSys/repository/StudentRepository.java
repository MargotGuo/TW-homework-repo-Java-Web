package com.thoughtworks.educationSys.repository;

import com.thoughtworks.educationSys.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentRepository {
  private List<Student> studentList = new ArrayList<>();

  {
    studentList.add(new Student("Lily", "FEMALE", "1-1"));
    studentList.add(new Student("Mike", "MALE", "1-3"));
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public Optional<Student> getStudent(String name) {
    return getStudentList()
        .stream()
        .filter(student -> student.getName().equals(name))
        .findAny();
  }

  public void add(Student student) {
    studentList.add(student);
  }

  public void delete(String name) {
    Optional<Student> student = getStudent(name);
    student.ifPresent(student1 -> studentList.remove(student1));
  }

  public boolean hasStudent(String name) {
    Optional<Student> student = getStudent(name);
    return student.isPresent();
  }
}
