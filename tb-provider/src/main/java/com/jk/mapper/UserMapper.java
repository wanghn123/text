package com.jk.mapper;

import com.jk.entity.HobbyEntity;
import com.jk.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select u.*,h.name as hobbyName from t_users u LEFT JOIN t_hobby h on u.hobby_id = h.id")
    List<UserEntity> selectUserList();

    @Delete("delete from t_users where user_id = #{userId}")
    void deleteUser(Integer userId);

    @Select("select * from t_hobby")
    List<HobbyEntity> queryHobby();

    @Insert("insert into t_users(user_name,gender,birthday,hobby_id) values(#{userName},#{gender},#{birthday},#{hobbyId})")
    void saveUser(UserEntity userEntity);

    @Select("select * from t_users where user_id=#{userId}")
    List<UserEntity> selectById(Integer userId);

    @Update("update t_users set user_name = #{userName},gender = #{gender},birthday = #{birthday},hobby_id = #{hobbyId} where user_id = #{userId}")
    void updateUser(UserEntity userEntity);
}
