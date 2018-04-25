package com.lvtinger.demo.cache;

import com.lvtinger.core.vessel.anno.Named;

@Named("memberCache")
public class MemberCache implements Cache {
    @Override
    public String get() {
        return "member cached";
    }
}
