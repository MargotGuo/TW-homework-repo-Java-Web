package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

//  @PostMapping("/post")    // 提交JSON
//  public User post(@RequestBody User user) {
//    System.out.println("接收到请求:" + user);
//    return user;
//  }

  @PostMapping("/post")       // 提交表单
  public User post(User user) {
    System.out.println("接收到请求:" + user);
    return user;
  }
}
