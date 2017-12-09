package com.xjtu.dao;

import com.xjtu.pojo.Evaluation;

public interface EvaluationMapper {
    int insert(Evaluation record);

    int insertSelective(Evaluation record);
}