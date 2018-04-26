package com.lvtinger.core.vessel.builder;

import com.lvtinger.core.vessel.hope.AttrHope;

public interface ProviderHopeBuilder extends NamedHopeBuilder {
    ProviderHopeBuilder provider(Class<?> type);
    ProviderHopeBuilder provider(Class<?> type, String name);
    NamedHopeBuilder properties(AttrHope... hopes);
}