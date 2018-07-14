package com.tank.controller;

import com.tank.message.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fuchun 
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

  @GetMapping("/list")
  public List<Order> list() {
    List<Order> orders = new ArrayList<>();
    orders.add(new Order("s0001", "lisi", "Beijing"));
    orders.add(new Order("s0002", "wangwu", "Xian"));
    return orders;
  }

  @PostMapping("/create")
  public int create(Order order) {
    return 1;
  }

  @DeleteMapping("/{sno}/delete")
  public int delete(String sno) {
    return 1;
  }

  @PutMapping
  public int update(String sno, Order order) {
    return  1;
  }

}
