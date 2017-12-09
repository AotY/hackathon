package com.xjtu.service;

import com.xjtu.common.ServerResponse;

/**
 * Created by LeonTao on 09/12/2017.
 */
public interface IRecommendService {
    public ServerResponse getCarousels();
    public ServerResponse getKeywords();
}
