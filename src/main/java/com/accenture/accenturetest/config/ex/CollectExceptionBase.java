package com.accenture.accenturetest.config.ex;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
public abstract class CollectExceptionBase extends RuntimeException {

  private final Error error;
  private final HttpStatus httpStatus;
  private final Error.Type type;
  private final String message;

  protected CollectExceptionBase(Error error, HttpStatus httpStatus) {
    this.error = error;
    this.type = error.getType();
    this.message = error.getMessage();
    this.httpStatus = httpStatus;
  }
}
