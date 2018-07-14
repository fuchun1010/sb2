package com.tank.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

import java.io.IOException;
import java.util.Optional;

public class JsonUtils {

  public static <T> Optional<String> object2Str(@NonNull T obj) {

    try {
      return obj instanceof String ? Optional.of((String) obj) : Optional.of(objectMapper.writeValueAsString(obj));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  public static <T> Optional<T> str2Obj(@NonNull String objStr, @NonNull Class<T> targetClass) {

    try {
      return targetClass.equals(String.class) ? Optional.of((T) objStr) : Optional.of(objectMapper.readValue(objStr, targetClass));
    } catch (IOException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }


  private static final ObjectMapper objectMapper = new ObjectMapper();
}
