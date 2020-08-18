package com.jk.service;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/error")
@Component
public class UserServiceFallback implements UserServiceFeign {
    @Override
    public List<UserEntity> findUserList() {
        System.out.println("熔断处理,查询");
        //熔断处理
        return null;
    }

    @Override
    public String hello(String name) {
        System.out.println("hello方法 熔断器");
        return "失败检查网络";
    }

    @Override
    public void deleteUser(Integer userId) {
        System.out.println("熔断处理,删除");

    }

    @Override
    public List<HobbyEntity> queryHobby() {
        System.out.println("新增时查询爱好,熔断处理");
        return null;
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        System.out.println("新增熔断处理");
    }

    @Override
    public List<UserEntity> selectById(Integer userId) {
        System.out.println("修改回显熔断处理");
        return null;
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        System.out.println("修改熔断处理");
    }

    @Override
    public Object saveOrder(Integer userId, Integer productId) {
        System.out.println("进入保存订单 熔断器类");
        return null;
    }
}
