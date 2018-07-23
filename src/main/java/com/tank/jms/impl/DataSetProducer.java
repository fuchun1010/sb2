package com.tank.jms.impl;

import com.tank.jms.ActionProducer;
import com.tank.message.DataSetSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author fuchun
 */
@Component
public class DataSetProducer implements ActionProducer<DataSetSection> {

  @Override
  public void add(DataSetSection data) {
    this.jmsMessagingTemplate.convertAndSend(this.dataSetQueue, data);
  }


  @Autowired
  private Queue dataSetQueue;

  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;
}
