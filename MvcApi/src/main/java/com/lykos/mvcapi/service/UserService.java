package com.lykos.mvcapi.service;

import com.lykos.mvcapi.common.BaseService;
import com.lykos.mvcapi.dao.UserDao;
import com.lykos.mvcapi.po.TUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lykos on 16/1/27.
 */
@Service
public class UserService extends BaseService{

    @Autowired
    private UserDao dao;

    public List<TUserEntity> search(){
        return dao.findByHql("from TUserEntity",null);
    }

    public void save(TUserEntity user) throws Exception{
        dao.save(user);
    }
}
