package com.tank.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

/**
 * @author fuchun
 */
@Data
@Accessors(chain = true)
public class ResultMsg {

  private String msg;

  private Optional<String> error = Optional.empty();
}
