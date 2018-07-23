package com.tank.controller;

import com.tank.jms.impl.DataSetProducer;
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
    val response = new HashMap<String, String>();
    response.putIfAbsent("message", "commit sql section success");
    this.dataSetProducer.add(dataSetSection);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
  }


  @Autowired
  private DataSetProducer dataSetProducer;
}
