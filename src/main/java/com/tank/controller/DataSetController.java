package com.tank.controller;

import com.tank.jms.impl.ChatTopicProducer;
import com.tank.jms.impl.DataSetProducer;
import com.tank.message.ChatTopic;
import com.tank.message.DataSetSection;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/dataSet")
public class DataSetController {


  @PostMapping("/import")
  public ResponseEntity<Map<String, String>> importData(@RequestBody DataSetSection dataSetSection) {
    val response = new HashMap<String, String>(16);
    response.putIfAbsent("message", "commit sql section success");
    this.dataSetProducer.add(dataSetSection);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
  }

  @PostMapping("/chat")
  public ResponseEntity<Map<String, String>> chat(@RequestBody ChatTopic chatTopic) {
    val response = new HashMap<String, String>(16);
    response.putIfAbsent("message", "hello topic");
    chatTopicProducer.add(chatTopic);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
  }

  @Autowired
  private DataSetProducer dataSetProducer;

  @Autowired
  private ChatTopicProducer chatTopicProducer;
}
