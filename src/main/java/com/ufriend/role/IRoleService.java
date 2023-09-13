package com.ufriend.role;

import java.util.List;

public interface IRoleService {
    public List<RoleEntity> list();
    public RoleEntity findById(String role);
    public void save(RoleEntity role);
    public void delete(RoleEntity role);
}
