package com.tank;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author fuchun
 */
@Component
public class AsyncQueue<T> {


  public boolean add(T t) {
    return queue.add(t);
  }

  @Async
  public void process() {
    for (; ; ) {
      try {
        System.out.println("prepare process queue data");
        T data = queue.take();
        System.out.println("done one queue data");
        System.out.println("data type is:" + data.getClass().getSimpleName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  private final LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<>();


}
