package com.reids.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCreateRequest {

  private int id;
  private String email;
  private String name;
}
