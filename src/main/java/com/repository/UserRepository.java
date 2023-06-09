package com.repository;

import org.springframework.data.repository.CrudRepository;
import com.model.User;
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
