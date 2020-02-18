package com.bbdemo.service;

import com.bbdemo.mapper.UserMapper;
import com.bbdemo.model.User;
import com.bbdemo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void insertOrUpdate(User user) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> Accounts = userMapper.selectByExample(example);
        if (Accounts.size()==0){
            userMapper.insert(user);
        }
        else {
            User Account = Accounts.get(0);
            User dbuser=new User();
            dbuser.setGmtModified(System.currentTimeMillis());
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setName(user.getName());
            dbuser.setToken(user.getToken());
            UserExample Example = new UserExample();
            Example.createCriteria()
                    .andIdEqualTo(Account.getId());
            userMapper.updateByExampleSelective(dbuser, Example);
        }
    }
}
