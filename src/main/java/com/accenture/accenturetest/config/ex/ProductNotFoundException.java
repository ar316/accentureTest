package com.accenture.accenturetest.config.ex;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends CollectExceptionBase {

  public ProductNotFoundException(String message) {
    super(
        Error.builder().type(Error.Type.PRODUCT_NOT_FOUND).message(message).build(),
        HttpStatus.NOT_FOUND);
  }
}
