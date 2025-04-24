package com.accenture.accenturetest.config.ex;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {

  private Type type;
  private String message;
  private List<String> detail;

  public enum Type {
    // 400
    FRANCHISE_NOT_FOUND,
    BRANCH_NOT_FOUND,
    PRODUCT_NOT_FOUND,

    INVALID_ARGUMENT
  }
}
