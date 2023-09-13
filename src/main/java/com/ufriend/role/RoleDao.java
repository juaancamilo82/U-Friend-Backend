package com.ufriend.role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<RoleEntity, String> {
    @Query("SELECT r FROM RoleEntity r WHERE r.name = ?1")
    public RoleEntity findByName(String name);
}
