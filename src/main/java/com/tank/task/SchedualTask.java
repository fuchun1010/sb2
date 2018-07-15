package com.tank.task;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fuchun
 */
@Configuration
@Component
public class SchedualTask {

  @Scheduled(fixedRate = 1000)
  public void displayDate() {
    if (scheduleSwitcher) {
      val date = LocalDateTime.now();
      val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      val dateStr = date.format(dateFormatter);
      val sb = new StringBuilder();
      sb.append("current date is:");
      sb.append(dateStr);
      System.out.println(sb.toString());
    }
  }

  @Value("${switch.scheduleSwitcher}")
  private boolean scheduleSwitcher;
}
