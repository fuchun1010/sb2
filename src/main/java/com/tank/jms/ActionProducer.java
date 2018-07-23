package com.tank.jms;

import lombok.NonNull;

/**
 * 异步行为queue
 *
 * @author fuchun
 */
public interface ActionProducer<T> {

  void add(@NonNull T data);

}
