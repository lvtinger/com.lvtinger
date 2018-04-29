package com.lvtinger.demo.api;

import com.lvtinger.demo.domain.User;

public interface UserAPI {
    User getById(Long userId);
}
