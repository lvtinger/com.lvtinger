package com.lvtinger.demo.service;

import com.lvtinger.core.vessel.anno.Inject;
import com.lvtinger.core.vessel.anno.Named;
import com.lvtinger.core.vessel.anno.Qualifier;
import com.lvtinger.demo.cache.Cache;
import com.lvtinger.demo.dao.UserDAO;

@Named
public class UserProvider implements UserAPI {
    @Inject
    @Qualifier("redisCache")
    private Cache cache;

    @Inject
    private UserDAO userDAO;

    @Override
    public String login(String username, String password) {
        return username + password;
    }
}