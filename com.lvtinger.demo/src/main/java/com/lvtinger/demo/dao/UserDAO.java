package com.lvtinger.demo.dao;

import com.lvtinger.demo.domain.User;

public interface UserDAO {
    User getById(Long userId);
}
