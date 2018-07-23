package com.tank;

import com.tank.utils.AsyncQueue;
import lombok.val;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;
import java.util.Objects;

/**
 * @author fuchun
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableJms
public class Boot {


  @Bean
  public Queue dataSetQueue() {
    val dataSetQueue = new ActiveMQQueue("dataSet.queue");
    return dataSetQueue;
  }

  public static void main(String[] args) {
    val context = SpringApplication.run(Boot.class, args);
    AsyncQueue queue = (AsyncQueue) context.getBean("asyncQueue");
    if (!Objects.isNull(queue)) {
      queue.process();
    }
  }
}
