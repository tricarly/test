package com.suyi.service;

import com.suyi.domain.Role;

import java.util.List;

public interface RoleService {
    public void save(Role role);
    public List<Role> list();

    public void delete(Long roleId);
}
