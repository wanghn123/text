package com.jk.service;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;
import com.jk.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findUserList() {
        return userMapper.selectUserList();
}

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public List<HobbyEntity> queryHobby() {
        return userMapper.queryHobby();
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userMapper.saveUser(userEntity);
    }

    @Override
    public List<UserEntity> selectById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userMapper.updateUser(userEntity);
    }
}
