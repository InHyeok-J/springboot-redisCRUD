package com.reids.crud.repository;


import com.reids.crud.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRedisRepository extends CrudRepository<User, Integer> {

}
