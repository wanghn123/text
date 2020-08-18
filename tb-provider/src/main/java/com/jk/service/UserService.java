package com.jk.service;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findUserList();

    void deleteUser(Integer userId);

    List<HobbyEntity> queryHobby();

    void saveUser(UserEntity userEntity);

    List<UserEntity> selectById(Integer userId);

    void updateUser(UserEntity userEntity);
}
