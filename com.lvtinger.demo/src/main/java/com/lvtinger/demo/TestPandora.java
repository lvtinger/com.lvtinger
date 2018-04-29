package com.lvtinger.demo;

import org.junit.Test;

public class TestPandora {
    @Test
    public void test(){
        A b = null;
        A c = null;

        System.out.println(b instanceof A);
        System.out.println(c instanceof A);
        System.out.println(c instanceof B);

        b = new B();
        c = new C();

        System.out.println(b instanceof A);
        System.out.println(c instanceof A);
        System.out.println(c instanceof B);

        b = new C();
        c = new C();

        System.out.println(b instanceof A);
        System.out.println(c instanceof A);
        System.out.println(c instanceof B);


    }

    interface A{}
    public class B implements A{}
    public class C extends B{}
}
