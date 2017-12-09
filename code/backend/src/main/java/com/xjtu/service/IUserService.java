package com.xjtu.service;

import com.xjtu.common.ServerResponse;
import com.xjtu.pojo.User;

/**
 * Created by LeonTao on 2017/9/23.
 * 类别（category）服务
 */
public interface IUserService {


    public ServerResponse<User> login(String username, String password);

    public ServerResponse register(User user);

    public ServerResponse checkValid(String value, String filed);

    public ServerResponse setGuide(User user);

    public ServerResponse update(User user);

    public ServerResponse logout(User user);

}
