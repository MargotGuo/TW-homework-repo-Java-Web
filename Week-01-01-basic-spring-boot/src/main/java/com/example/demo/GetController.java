package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

  @GetMapping("/get/{id}")
  public String get(@PathVariable String id,
                    @RequestParam(name = "name") String name,
                    @RequestParam(name = "age") int age,
                    @RequestParam(name = "gender") String gender) {
    return String.format("id: %s\nname: %s \nage: %d\ngender: %s", id, name, age, gender);
  }
}
