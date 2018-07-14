package com.tank.controller;

import com.tank.message.Order;
import com.tank.message.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

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
    orders.add(new Order().setSno("s0001").setReceiver("lisi").setAddress("Beijing"));
    orders.add(new Order().setSno("s0002").setReceiver("wangwu").setAddress("Xian"));
    return orders;
  }

  @PostMapping("/create")
  public ResponseEntity<ResultMsg> create(@RequestBody Order order) {
    val msg = new ResultMsg();
    if (Objects.isNull(order) || Objects.isNull(order.getSno())) {
      return new ResponseEntity(msg.setError(Optional.of("order is null value")), INTERNAL_SERVER_ERROR);
    }
    msg.setMsg("create order id:" + order.getSno() + " success");
    return new ResponseEntity(msg, ACCEPTED);
  }

  @DeleteMapping("/{id}/delete")
  public ResponseEntity<ResultMsg> delete(@PathVariable("id") String sno) {
    val msg = new ResultMsg();
    if (Objects.isNull(sno)) {
      return new ResponseEntity(msg.setError(Optional.of("order is null value")), INTERNAL_SERVER_ERROR);
    }
    msg.setMsg("delete order id:" + sno + " success");
    return new ResponseEntity(msg, OK);
  }

  @PutMapping("/{id}/update")
  public ResponseEntity<ResultMsg> update(@PathVariable("id") String sno, @RequestBody Order order) {
    val msg = new ResultMsg();
    msg.setMsg("update order id:" + sno + " success");
    return new ResponseEntity(msg, OK);
  }


  private final int initCapacity = 16;
}
