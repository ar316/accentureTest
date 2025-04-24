package com.accenture.accenturetest.config.ex;

import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends CollectExceptionBase {

  public InvalidArgumentException(String message) {
    super(
        Error.builder().type(Error.Type.INVALID_ARGUMENT).message(message).build(),
        HttpStatus.BAD_REQUEST);
  }
}
