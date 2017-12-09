package com.xjtu.service.impl;

import com.xjtu.common.Const;
import com.xjtu.common.ServerResponse;
import com.xjtu.dao.CarouselMapper;
import com.xjtu.dao.CharacterMapper;
import com.xjtu.dao.KeywordMapper;
import com.xjtu.pojo.Carousel;
import com.xjtu.service.ICharacterService;
import com.xjtu.service.IRecommendService;
import com.xjtu.util.PropertiesUtil;
import com.xjtu.vo.CarouselVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LeonTao on 09/12/2017.
 */
@Service("iCharacterService")
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public ServerResponse getList(String type) {

        List<String> labels = characterMapper.getList(type);
        return ServerResponse.createBySuccess(labels);
    }
}
