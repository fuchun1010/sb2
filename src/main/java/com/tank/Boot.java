package com.tank;

import com.tank.utils.AsyncQueue;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Objects;

/**
 * @author fuchun
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Boot {
  public static void main(String[] args) {
    val context = SpringApplication.run(Boot.class, args);
    AsyncQueue queue = (AsyncQueue)context.getBean("asyncQueue");
    if(!Objects.isNull(queue)) {
      queue.process();
    }
  }
}
