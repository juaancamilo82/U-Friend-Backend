package com.ufriend.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where u.email = ?1")
    public UserEntity findByEmail(String email);
}
