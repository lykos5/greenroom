package com.lykos.mvcapi.controller;

import com.lykos.mvcapi.common.BaseController;
import com.lykos.mvcapi.common.ResponseResult;
import com.lykos.mvcapi.po.TUserEntity;
import com.lykos.mvcapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lykos on 16/1/27.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/name/jsonp",produces="text/plain;charset=UTF-8",method = RequestMethod.GET)
    public String getNameByJsonp(String callback) throws Exception{
        return callback+"([])";
    }



    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public List<TUserEntity> getName(){
        return userService.search();
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseResult save(@RequestBody TUserEntity user) throws Exception{
        userService.save(user);
        return getSucResponseResult();
    }

}
