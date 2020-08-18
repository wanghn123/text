package com.jk.controller;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController implements UserService {

    @Resource
    private UserService userService;



    @Override
    @RequestMapping("/findUserList")
    public List<UserEntity> findUserList() {
        return userService.findUserList();
    }

    @Override
    @RequestMapping("/deleteUser")
    public void deleteUser( Integer userId) {
        userService.deleteUser(userId);
    }

    @Override
    @RequestMapping("/queryHobby")
    public List<HobbyEntity> queryHobby() {
        return userService.queryHobby();
    }

    @Override
    @RequestMapping("/saveUser")
    public void saveUser(@RequestBody UserEntity userEntity) {

            userService.saveUser(userEntity);


    }

    @Override
    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody UserEntity userEntity) {

        userService.updateUser(userEntity);


    }

    @Override
    @RequestMapping("/selectById")
    public List<UserEntity> selectById(Integer userId) {
        return userService.selectById(userId);
    }




}
