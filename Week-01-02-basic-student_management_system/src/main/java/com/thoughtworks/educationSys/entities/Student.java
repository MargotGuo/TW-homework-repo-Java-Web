package com.thoughtworks.educationSys.entities;

public class Student {
  private String name;
  private String gender;
  private String klass;

  public Student(String name, String gender, String klass) {
    this.name = name;
    this.gender = gender;
    this.klass = klass;
  }

  public Student() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getKlass() {
    return klass;
  }

  public void setKlass(String klass) {
    this.klass = klass;
  }
}
