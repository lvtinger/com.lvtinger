package com.lvtinger.demo;

import com.lvtinger.core.vessel.GenericPandora;
import com.lvtinger.core.vessel.Pandora;
import com.lvtinger.core.vessel.hope.GenericHope;
import com.lvtinger.core.vessel.hope.Hope;
import com.lvtinger.core.vessel.hope.PropertyValue;
import com.lvtinger.core.vessel.hope.ReferValue;
import com.lvtinger.demo.api.UserAPI;
import com.lvtinger.demo.dao.UserDAO;
import com.lvtinger.demo.dao.impl.UserDaoImpl;
import com.lvtinger.demo.domain.User;
import com.lvtinger.demo.provider.UserService;
import org.junit.Test;

import java.util.Collections;

public class TestGenericPandora {
    @Test
    public void test(){
        //创建容器
        Pandora pandora = new GenericPandora();

        //dao
        Hope dao = new GenericHope(UserDAO.class.getName(), UserDaoImpl.class);
        pandora.put(dao);

        //dao引用
        ReferValue referValue = new ReferValue();
        referValue.setReferName(UserDAO.class.getTypeName());

        //property定义
        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setName("userDAO");
        propertyValue.setValue(referValue);

        //service
        GenericHope provider = new GenericHope(UserAPI.class.getName(), UserService.class);
        provider.setProperties(Collections.singletonList(propertyValue));
        pandora.put(provider);

        UserAPI userAPI = (UserAPI) pandora.get(UserAPI.class.getName());
        User user = userAPI.getById(1L);
        System.out.println(user);
    }
}
