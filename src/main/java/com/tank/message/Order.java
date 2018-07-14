package com.tank.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author fuchun
 */
@Data
@Accessors(chain = true)
public class Order {

  @JsonProperty("id")
  private String sno;
  private String receiver;
  private String address;
}
