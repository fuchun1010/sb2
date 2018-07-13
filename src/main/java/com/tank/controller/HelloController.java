package com.tank.controller;


import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fuchun
 */
@RestController
@RequestMapping("/hello")
public class HelloController {



  @GetMapping("")
  public Map<String, String> index() {
    val initCapacity = 16;
    val msg = new HashMap<String, String>(initCapacity);
    msg.putIfAbsent("name", "hello");
    return msg;
  }


}
