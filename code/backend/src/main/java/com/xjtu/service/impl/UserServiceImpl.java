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

        // 更新用户状态
        user.setOnline(Const.ONLINE);
//        userMapper.insertSelective(user);
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setOnline(Const.ONLINE);
        userMapper.updateByPrimaryKeySelective(updateUser);

        // 不要返回密码
        user.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess(user);
    }


    /**
     * 注册
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

        if (user.getHometown() == null) {
            user.setHometown("西安");
        }
        if (user.getIndustry() == null) {
            user.setIndustry("学生");
        }

        if (user.getLongitude() == null) {
            user.setLongitude((float) 109.134);
        }

        if (user.getLatitude() == null) {
            user.setLatitude((float) 34.3912);
        }

        if (user.getGuidecount() == null) {
            user.setGuidecount(0);
        }

        if (user.getRating() == null) {
            user.setRating((float) 0.0);
        }

        if (user.getDevice() == null) {
            user.setDevice("iphone 6s");
        }
        user.setOnline(Const.OFFLINE);
        user.setGuide(Const.NO_GUIDE);

//        int affectedRows = userMapper.insertSelective(user);
        int affectedRows = userMapper.insert(user);
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


    /**
     * 设置当前用户为向导
     * @param user
     * @return
     */
    public ServerResponse setGuide(User user){
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setGuide(Const.GUIDE);
        int affectedRows = userMapper.updateByPrimaryKeySelective(updateUser);

        // 不要返回密码
        user.setGuide(Const.GUIDE);
        user.setPassword(StringUtils.EMPTY);

        if (affectedRows > 0) {
            return ServerResponse.createBySuccess(Const.SET_SUCCESS, user);
        }
        return ServerResponse.createByError(Const.SET_FAILED, null);
    }

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    @Override
    public ServerResponse update(User user) {
        return null;
    }

    /*

    退出登录
     */
    @Override
    public ServerResponse logout(User user) {
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setOnline(Const.OFFLINE);
        updateUser.setGuide(Const.NO_GUIDE);
        int affectedRows = userMapper.updateByPrimaryKeySelective(updateUser);

        if (affectedRows > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();

    }
}
