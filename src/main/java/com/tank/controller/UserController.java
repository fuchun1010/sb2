package com.tank.controller;

import com.tank.AsyncQueue;
import com.tank.message.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


  @PostMapping("/create")
  public ResponseEntity<User> create() {
    val user = new User().setGender(1).setName("lisi");
    Assert.isNull(asyncQueue, "asyncQueue is null object");
    asyncQueue.add(user);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @Autowired
  private AsyncQueue asyncQueue;
}
