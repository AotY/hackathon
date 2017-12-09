package com.xjtu.util;

import com.xjtu.vo.UserVo;

/**
 * Created by LeonTao on 2017/10/2.
 */
public class AssembleUtil {

    public static UserVo assembleShippingVo(Shipping shipping) {
        UserVo shippingVo = new UserVo();
        shippingVo.setId(shipping.getId());
        shippingVo.setReceiverName(shipping.getReceiverName());
        shippingVo.setReceiverAddress(shipping.getReceiverAddress());
        shippingVo.setReceiverCity(shipping.getReceiverCity());
        shippingVo.setReceiverDistrict(shipping.getReceiverDistrict());
        shippingVo.setReceiverMobile(shipping.getReceiverMobile());
        shippingVo.setReceiverPhone(shipping.getReceiverPhone());
        shippingVo.setReceiverProvince(shipping.getReceiverProvince());
        shippingVo.setReceiverZip(shipping.getReceiverZip());
        shippingVo.setDefault(shipping.getDefault());
        return shippingVo;
    }

}
