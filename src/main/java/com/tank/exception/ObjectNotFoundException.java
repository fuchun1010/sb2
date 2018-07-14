package com.tank.exception;

import lombok.NonNull;

/**
 * @author fuchun
 */
public class ObjectNotFoundException extends RuntimeException {
  public ObjectNotFoundException(@NonNull final String msg) {
    super(msg);
  }
}
