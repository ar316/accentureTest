package com.accenture.accenturetest.config.ex;

import org.springframework.http.HttpStatus;

public class FranchiseNotFoundEx extends CollectExceptionBase {

  public FranchiseNotFoundEx(String message) {
    super(
        Error.builder().type(Error.Type.FRANCHISE_NOT_FOUND).message(message).build(),
        HttpStatus.NOT_FOUND);
  }
}
