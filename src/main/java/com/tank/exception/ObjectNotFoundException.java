package com.tank.exception;

/**
 * @author fuchun
 */
public class ObjectNotFoundException extends RuntimeException {
  public ObjectNotFoundException(final String msg) {
    super(msg);
  }
}
