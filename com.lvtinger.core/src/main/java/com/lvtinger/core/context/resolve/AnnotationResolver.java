package com.lvtinger.core.context.resolve;

import com.lvtinger.core.common.ReflectUtils;
import com.lvtinger.core.common.StringUtils;
import com.lvtinger.core.context.annotation.Inject;
import com.lvtinger.core.context.annotation.Named;
import com.lvtinger.core.context.config.ConfigManage;
import com.lvtinger.core.context.config.ObjectConfig;
import com.lvtinger.core.context.config.PropertyConfig;
import com.lvtinger.core.context.config.ValueConfig;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author qiuxu
 */
public class AnnotationResolver extends AbstractResolver {
    private final Set<String> packages = new LinkedHashSet<>();

    public Set<String> getPackages(){
        return this.packages;
    }

    public AnnotationResolver(ConfigManage configManage){
        super(configManage);
    }

    public void append(String packageName){

        if(StringUtils.isEmpty(packageName)){
            return;
        }

        if(packages.stream().anyMatch(x -> x.equals(packageName) || packageName.startsWith(x + "."))){
            return;
        }

        Set<String> collect = packages.stream()
                .filter(x -> x.startsWith(packageName+"."))
                .collect(Collectors.toSet());
        if(collect.size() > 0){
            this.packages.removeAll(collect);
            this.packages.add(packageName);
            return;
        }

        this.packages.add(packageName);
    }

    @Override
    public void resolve() {
        Set<Class<?>> classes = new LinkedHashSet<>();
        for (String packageName:packages) {
            //ReflectUtils.scanType(classes, packageName);
        }
        ConfigManage configManage = this.getConfigManage();
        for (Class<?> clazz: classes) {
            Named named = clazz.getAnnotation(Named.class);
            if(named == null){
                continue;
            }

            String name = named.name();
            if(StringUtils.isEmpty(name)){
                name = clazz.getTypeName();
            }

            PropertyConfig properties = new PropertyConfig();

            Field[] fields = clazz.getDeclaredFields();
            if(fields.length > 0){
                for (Field field: fields) {
                    Inject inject = field.getAnnotation(Inject.class);
                    if(inject == null){
                        continue;
                    }

                    ValueConfig config = new ValueConfig();
                    String fieldName = inject.name();
                    if(StringUtils.isEmpty(fieldName)){
                        fieldName = field.getName();
                    }
                    config.setName(fieldName);
                }
            }

            ObjectConfig config = new ObjectConfig(clazz, name, properties);
            configManage.set(config);
        }
    }
}