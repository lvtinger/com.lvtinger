package com.lvtinger.demo.dao.impl;

import com.lvtinger.demo.dao.UserDAO;
import com.lvtinger.demo.domain.User;

public class UserDaoImpl implements UserDAO {
    @Override
    public User getById(Long userId) {
        User user = new User();
        user.setUserId(userId);
        Long timestamp = System.currentTimeMillis();
        user.setVersion(timestamp);
        return user;
    }
}
