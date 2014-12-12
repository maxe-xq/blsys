package com.bl.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bl.bean.BlUser;
import com.bl.dao.UserDao;
import com.bl.service.UserService;

@Service("UserService")
public class UserServiceImp implements UserService {

	@Autowired
	@Qualifier("UserDao")
    private transient UserDao userDao;

	@Override
	@Transactional
    public BlUser getUserByKey(BlUser user) {
        if (user==null)
            return null;
        return userDao.getUserByKey(user);
    }
    
}
