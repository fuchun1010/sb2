package com.tank.jms;

/**
 * 行为消费
 *
 * @author fuchun
 */
public interface ActionConsumer<T> {

  void processMessage(T data);
}
