package com.lvtinger.demo.provider;

import com.lvtinger.demo.api.UserAPI;
import com.lvtinger.demo.dao.UserDAO;
import com.lvtinger.demo.domain.User;

public class UserService implements UserAPI {
    private UserDAO userDAO;

    @Override
    public User getById(Long userId) {
        return userDAO.getById(userId);
    }
}