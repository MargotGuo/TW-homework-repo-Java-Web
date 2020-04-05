package com.thoughtworks.educationSys.entities;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
  @Modifying
  @Query("INSERT INTO student VALUES (:name, :gender, :class)")
  void insertNewStudent(
      @Param("name") String name,
      @Param("gender") String gender,
      @Param("class") String klass);
}
