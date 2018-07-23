package com.tank.jms;

import lombok.NonNull;

/**
 * 异步行为queue
 *
 * @author fuchun
 */
public interface ActionProducer<T> {

  /**
   * 添加一个消息
   * @param data
   */
  void add(@NonNull T data);

}
