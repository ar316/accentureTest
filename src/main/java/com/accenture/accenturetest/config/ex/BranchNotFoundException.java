package com.accenture.accenturetest.config.ex;

import org.springframework.http.HttpStatus;

public class BranchNotFoundException extends CollectExceptionBase {
  public BranchNotFoundException(String message) {
    super(
        Error.builder().type(Error.Type.BRANCH_NOT_FOUND).message(message).build(),
        HttpStatus.NOT_FOUND);
  }
}
