package com.tank.jms.impl;

import com.tank.message.ChatTopic;
import lombok.NonNull;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChartTopicConsumer {

  @JmsListener(destination = "chat.topic", containerFactory = "jmsListenerContainerTopic")
  public void consumeChatTopic(@NonNull final ChatTopic chatTopic) {
    System.out.println("consume topic 1:" + chatTopic.getStatement());
  }

  @JmsListener(destination = "chat.topic", containerFactory = "jmsListenerContainerTopic")
  public void consumeChatTopic2(@NonNull final ChatTopic chatTopic) {
    System.out.println("consume topic 2:" + chatTopic.getStatement());
  }
}
