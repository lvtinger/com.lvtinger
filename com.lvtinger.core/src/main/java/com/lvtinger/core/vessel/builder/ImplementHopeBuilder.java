package com.lvtinger.core.vessel.builder;

import com.lvtinger.core.vessel.hope.AttrHope;
import com.lvtinger.core.vessel.hope.ReferHope;

import java.lang.reflect.Constructor;

public interface ImplementHopeBuilder extends NamedHopeBuilder {
    ImplementHopeBuilder constructer(Constructor<?> constructor);
    ImplementHopeBuilder parameters(ReferHope... hopes);
    NamedHopeBuilder properties(AttrHope... hopes);
}