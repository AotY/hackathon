package com.xjtu.service.impl;

import com.xjtu.common.Const;
import com.xjtu.common.ResponseCode;
import com.xjtu.common.ServerResponse;
import com.xjtu.dao.UserMapper;
import com.xjtu.pojo.User;
import com.xjtu.service.IUserService;
import com.xjtu.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LeonTao on 2017/9/28.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 真正实现用户登录的地方
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public ServerResponse<User> login(String phone, String password) {
        // 校验
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        // 查询数据库
        int count = userMapper.selectByPhone(phone);

        // 用户名不存在
        if (count == 0) {
            return ServerResponse.createByError(Const.USER_NOT_EXISTS);
        }

        // 密码
        String encodePassword = MD5Util.MD5EncodeUTF8(password);

        User user = userMapper.selectLogin(phone, encodePassword);
        if (user == null) {
            return ServerResponse.createByError(Const.USERNAME_OR_PASSWORD_ERROR);
        }

        // 不要返回密码
        user.setPassword(StringUtils.EMPTY);
        user.setOnline(Const.ONLINE);

        return ServerResponse.createBySuccess(user);
    }


    /**
     * @param user
     */
    public ServerResponse register(User user) {
        if (user == null) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        ServerResponse validResponse = null;
        // 检查手机号和用户名是否已经存在
        validResponse = this.checkValid(user.getPhone(), Const.PHONE);
        if (validResponse.getStatus() != 0) {
            return validResponse;
        }
        validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (validResponse.getStatus() != 0) {
            return validResponse;
        }
        // 验证密码
        validResponse = this.checkValid(user.getPassword(), Const.PASSWORD);
        if (validResponse.getStatus() != 0) {
            return validResponse;
        }

        // 密码加密
        user.setPassword(MD5Util.MD5EncodeUTF8(user.getPassword()));

//        int affectedRows = userMapper.insert(user);
        int affectedRows = userMapper.insertSelective(user);
        if (affectedRows > 0) {
            return ServerResponse.createBySuccess(Const.REGISTER_SUCCESS);
        }
        return ServerResponse.createByError(Const.REGISTER_FAILED);
    }

    /**
     * 校验字段值是否存在
     */
    public ServerResponse checkValid(String value, String filed) {
        if (StringUtils.isBlank(value)) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        if (filed.equals(Const.PHONE)) {
            // 手机号码
            if (userMapper.selectByPhone(value) > 0) {
                return ServerResponse.createByError(Const.PHONE_EXISTS);
            }
        } else if (filed.equals(Const.USERNAME)) {
            // 用户名
            if (userMapper.selectByUsername(value) > 0) {
                return ServerResponse.createByError(Const.USER_EXISTS);
            }
        }
        return ServerResponse.createBySuccess();
    }



    public ServerResponse setGuide(User user){
        user.setGuide(Const.GUIDE);
        int affectedRows = userMapper.insertSelective(user);
        if (affectedRows > 0) {
            return ServerResponse.createBySuccess(Const.SET_SUCCESS);
        }
        return ServerResponse.createByError(Const.SET_FAILED);
    }
}
