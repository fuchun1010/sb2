package com.tank.controller;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fuchun
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/server")
public class ServerController {

  @GetMapping
  public Map<String, String> index() {
    val initCapacity = 16;
    val msg = new HashMap<String, String>(initCapacity);
    val serverConfig = Runtime.getRuntime();
    val cpuCores = serverConfig.availableProcessors();
    val memory = serverConfig.totalMemory() / M;
    val remainingMemory = serverConfig.freeMemory() / M;
    msg.putIfAbsent("cpu cores:", String.valueOf(cpuCores));
    msg.putIfAbsent("jvm total memory:", memory + "M");
    msg.putIfAbsent("jvm remaining memory", remainingMemory + "M");
    return msg;
  }

  private final long M = 1024 * 1024;

}
