package com.reids.crud.entity;

;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("user_account")
@NoArgsConstructor
public class User {

  @Id
  private int id;

  private ArrayList<String> name;

  private String email;

  public User(int id, String name, String email) {
    this.id = id;
    this.name = new ArrayList<>(List.of(name));
    this.email = email;
  }

  public void addName(String name) {
    this.name.add(name);
  }
}
