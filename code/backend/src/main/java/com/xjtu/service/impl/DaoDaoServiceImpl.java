package com.xjtu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjtu.common.Const;
import com.xjtu.common.ServerResponse;
import com.xjtu.dao.CarouselMapper;
import com.xjtu.dao.KeywordMapper;
import com.xjtu.dao.UserMapper;
import com.xjtu.pojo.Carousel;
import com.xjtu.pojo.User;
import com.xjtu.service.IDaoDaoService;
import com.xjtu.service.IRecommendService;
import com.xjtu.util.PropertiesUtil;
import com.xjtu.vo.CarouselVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LeonTao on 09/12/2017.
 */
@Service("iDaoDaoService")
public class DaoDaoServiceImpl implements IDaoDaoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse getList(User user, String keyword, int pageNum, int pageSize, String orderBy) {

        /*
         * startPage--start
         * 填充自己的sql查询逻辑
         * pageHelper-收尾
         */
        PageHelper.startPage(pageNum, pageSize);

        //获取所有用户
        List<User> userList = userMapper.selectList();

        // 筛选
//        for (User userItem : userList) {
//            if (userItem.getGuide() == Const.ONLINE){
//
//            }
//        }

        PageInfo pageInfo = new PageInfo(userList); //这个传递对象，pageInfo会计算page, size等属性
        pageInfo.setList(userList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
