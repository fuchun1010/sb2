package com.tank.jms.impl;

import com.tank.jms.ActionProducer;
import com.tank.message.ChatTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author fuchun
 */
@Component
public class ChatTopicProducer implements ActionProducer<ChatTopic> {

  @Override
  public void add(ChatTopic data) {
    this.jmsMessagingTemplate.convertAndSend(this.chatTopic, data);
  }

  @Autowired
  private Topic chatTopic;

  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;

}
