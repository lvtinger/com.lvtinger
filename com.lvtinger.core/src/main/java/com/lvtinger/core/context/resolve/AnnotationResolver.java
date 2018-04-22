package com.lvtinger.core.context.resolve;

import com.lvtinger.core.common.StringUtils;

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

    public AnnotationResolver(){}{

    }

    public AnnotationResolver(String packageName){
        this.packages.add(packageName);
    }

    public void append(String packageName){

        if(StringUtils.isEmpty(packageName)){
            return;
        }

        if(packages.stream()
                .filter(x->x.equals(packageName) || packageName.startsWith(x+"."))
                .count() > 0){
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
}