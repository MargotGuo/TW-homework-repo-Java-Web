package com.thoughtworks.educationSys.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("student")
public class Student {
  @Id
  private String name;

  private String gender;

  @Column("class")
  private String klass;

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
