package com.xjtu.dao;

import com.xjtu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectByPhone(String phone);

    int selectByUsername(String username);

    User selectLogin(@Param("phone") String phone, @Param("password") String password);

    List<User> selectList();
}