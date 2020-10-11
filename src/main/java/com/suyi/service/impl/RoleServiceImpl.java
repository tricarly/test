package com.suyi.service.impl;

import com.suyi.domain.Role;
import com.suyi.mapper.RoleMapper;
import com.suyi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public List<Role> list() {
        return roleMapper.list();
    }

    @Override
    public void delete(Long roleId) {
        roleMapper.deleteUserAndRole(roleId);
        roleMapper.delete(roleId);
    }
}
