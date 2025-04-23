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

    INVALID_ARGUMENT,
    INVALID_BODY,
    INVALID_HEADER,
    INVALID_PARAMETER,
    METHOD_NOT_ALLOWED,
    UNSUPPORTED_MEDIA_TYPE,
    INVALID_AUTHORIZER,
    CLIENT_ERROR,
    FILE_PROCESSING_ERROR,
    EXCEL_GENERATION_ERROR,
    ALREADY_CLOSED_REQUEST,
    INVALID_FILENAME,
  }
}
