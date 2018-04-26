package com.lvtinger.core.context;

import com.lvtinger.core.vessel.GenericPandora;
import com.lvtinger.core.vessel.Pandora;

public class GenericApplicationContext implements ApplicationContext {
    private Pandora pandora;

    public GenericApplicationContext(){
        pandora = new GenericPandora();
    }

    @Override
    public Pandora getPandora() {
        return pandora;
    }
}