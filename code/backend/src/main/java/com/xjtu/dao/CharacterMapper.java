package com.xjtu.dao;

import com.xjtu.pojo.Character;

import java.util.List;

public interface CharacterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Character record);

    int insertSelective(Character record);

    Character selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Character record);

    int updateByPrimaryKey(Character record);

    List<String> getList(String type);
}