package com.jk.service;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;
import com.jk.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @RequestMapping("/findUserList")
    public List<UserEntity> findUserList() {
        return userMapper.selectUserList();
    }

    @Override
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hi,我叫"+name;
    }


    @Override
    @RequestMapping("/deleteUser")
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }


    @Override
    public List<HobbyEntity> queryHobby() {
        return userMapper.queryHobby();
    }

    @Override
    @RequestMapping("/saveUser")
    public void saveUser(@RequestBody UserEntity userEntity) {

            userMapper.saveUser(userEntity);


    }

    @Override
    @RequestMapping("/selectById")
    public List<UserEntity> selectById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody UserEntity userEntity) {

            userMapper.updateUser(userEntity);


    }

    @Override
    @RequestMapping("/saveOrder")
    public Object saveOrder(@RequestParam Integer userId, @RequestParam Integer productId) {
        HashMap<String, Object> orderMap = new HashMap<String, Object>();
        orderMap.put("orderId", 11111);
        orderMap.put("userId", userId);
        orderMap.put("productId", productId);
        orderMap.put("orderNo", "20200815103622123");
        orderMap.put("orderName", "一架辽宁舰");
        orderMap.put("orderPrice", 100000);
        orderMap.put("createTime", "2020-08-15 10:37");
        return orderMap;
    }


}
