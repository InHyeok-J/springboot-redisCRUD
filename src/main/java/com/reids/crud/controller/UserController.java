package com.reids.crud.controller;

import com.reids.crud.dto.UserCreateRequest;
import com.reids.crud.dto.UserUpdateRequest;
import com.reids.crud.entity.User;
import com.reids.crud.repository.UserRedisRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserRedisRepository userRedisRepository;

  @PostMapping("")
  public String userSaveRedis(@RequestBody UserCreateRequest request) {
    User user = new User(request.getId(), request.getName(), request.getEmail());
    User save = userRedisRepository.save(user);
    return save.getId() + "저장 성공";
  }

  @PatchMapping("")
  public String addUserName(@RequestBody UserUpdateRequest request) {
    Optional<User> findUser = userRedisRepository.findById(request.getId());
    findUser.get().addName(request.getName());
    userRedisRepository.save(findUser.get());
    return "업데이트성공";
  }

  @GetMapping("/{id}")
  public String findUserOne(@PathVariable int id) {
    Optional<User> fineUser = userRedisRepository.findById(id);
    return fineUser.get().getEmail();
  }
}
