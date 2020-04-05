package com.thoughtworks.educationSys.repository;

import com.thoughtworks.educationSys.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
  private static List<Student> studentList = new ArrayList<>();

  static {
    studentList.add(new Student("Lily", "FEMALE", "1-1"));
    studentList.add(new Student("Mike", "MALE", "1-3"));
  }

  public static List<Student> getStudentList() {
    return studentList;
  }
}
