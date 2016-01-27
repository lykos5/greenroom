package com.lykos.mvcapi.common;

/**
 * Created by Lykos on 16/1/27.
 */
public class BaseController {
    protected ResponseResult getSucResponseResult(){
        ResponseResult rr = new ResponseResult();
        rr.setSuc(true);
        return rr;
    }

    protected ResponseResult getFailResponseResult(){
        ResponseResult rr = new ResponseResult();
        rr.setSuc(false);
        return rr;
    }
}
