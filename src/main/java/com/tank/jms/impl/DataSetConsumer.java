package com.tank.jms.impl;

import com.tank.jms.ActionConsumer;
import com.tank.message.DataSetSection;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DataSetConsumer implements ActionConsumer<DataSetSection> {

  @JmsListener(destination = "dataSet.queue")
  @Override
  public void processMessage(DataSetSection data) {
    System.out.println("active mq receive:" + data.getSql());
  }

}
