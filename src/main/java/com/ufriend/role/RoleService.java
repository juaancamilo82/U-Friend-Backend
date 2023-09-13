package com.ufriend.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<RoleEntity> list() {
        return (ArrayList<RoleEntity>) roleDao.findAll();
    }

    @Override
    public RoleEntity findById(String roleId) {
        return roleDao.findById(roleId).orElse(null);
    }

    @Override
    public void save(RoleEntity role) {
        roleDao.save(role);
    }

    @Override
    public void delete(RoleEntity role) {
        roleDao.delete(role);
    }
}
