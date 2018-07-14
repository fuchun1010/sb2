package com.tank.message;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fuchun
 */
@Data
@AllArgsConstructor
public class Order {

  private String sno;
  private String receiver;
  private String address;
}
