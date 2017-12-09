package com.xjtu.service;

import com.xjtu.common.ServerResponse;
import com.xjtu.pojo.User;

/**
 * Created by LeonTao on 09/12/2017.
 */
public interface IDaoDaoService {
    public ServerResponse getList(User user, String keyword, int pageNum, int pageSize, String orderBy);
}
