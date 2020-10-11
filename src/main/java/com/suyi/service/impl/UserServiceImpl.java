package com.suyi.service.impl;

import com.suyi.domain.User;
import com.suyi.mapper.UserMapper;
import com.suyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void save(User user, Long[] roleIds) {
        userMapper.save(user);
        for (Long roleId : roleIds) {
            userMapper.saveUserAndRole(user.getId(),roleId);
        }
    }

    @Override
    public void delete(Long userId) {
        userMapper.deleteUserAndRole(userId);
        userMapper.delete(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userMapper.findByUsernameAndPassword(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
