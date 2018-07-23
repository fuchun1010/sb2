package com.tank.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fuchun
 */
@Data
public class DataSetSection implements Serializable {

  private String sql;

  private boolean isOver;
}
