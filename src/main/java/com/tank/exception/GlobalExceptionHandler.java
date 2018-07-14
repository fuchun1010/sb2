package com.tank.exception;

import com.tank.message.ResultMsg;
import lombok.val;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

/**
 * @author fuchun
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


  @ExceptionHandler(ObjectNotFoundException.class)
  ResultMsg handleEntityNotFound(ObjectNotFoundException ex) {
    val msg = new ResultMsg();
    msg.setError(Optional.of(ex.getMessage()));
    return msg;
  }

  @ExceptionHandler(JsonFormatException.class)
  ResultMsg handleJsonFormatException(JsonFormatException ex) {
    val msg = new ResultMsg();
    msg.setError(Optional.of(ex.getMessage()));
    return msg;
  }


}
