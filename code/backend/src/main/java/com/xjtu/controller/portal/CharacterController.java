package com.xjtu.controller.portal;

import com.xjtu.common.ServerResponse;
import com.xjtu.service.ICharacterService;
import com.xjtu.service.IRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 返回供用户选择的各种label
 *
 */
@Controller
@RequestMapping("/character/")
public class CharacterController {


    @Autowired
    private ICharacterService iCharacterService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getList(String type) {
        return iCharacterService.getList(type);
    }

}
