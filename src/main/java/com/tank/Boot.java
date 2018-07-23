package com.tank;

import com.tank.utils.AsyncQueue;
import lombok.val;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
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

  @Bean
  public Topic chatTopic() {
    val topic = new ActiveMQTopic("chat.topic");
    return topic;
  }

  @Bean
  public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory connectionFactory) {
    val bean = new DefaultJmsListenerContainerFactory();
    bean.setPubSubDomain(true);
    bean.setConnectionFactory(connectionFactory);
    return bean;
  }

  public static void main(String[] args) {
    val context = SpringApplication.run(Boot.class, args);
    AsyncQueue queue = (AsyncQueue) context.getBean("asyncQueue");
    if (!Objects.isNull(queue)) {
      queue.process();
    }
  }


}
