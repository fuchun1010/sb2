package com.tank.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author fuchun
 */
@Data
@Accessors(chain = true)
public class User {

  private int gender;
  private String name;
}
