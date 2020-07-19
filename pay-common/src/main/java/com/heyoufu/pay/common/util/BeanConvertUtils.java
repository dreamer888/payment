package com.heyoufu.pay.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *@Descrition bean 操作工具类
 *
 *@Autnor xuan
 *@Date 2020-05-19 9:23
 */
public class BeanConvertUtils {

    private static final Logger log = LoggerFactory.getLogger(BeanConvertUtils.class);

    /**
     * 实体类转换
     * @param source  数据源
     * @param targetClazz  目标对象class
     * @param ignoreProperties  忽略字段
     * @param <T> 转换的实体类
     * @return
     */
    public static <T> T toBean(Object source, Class<T> targetClazz, String... ignoreProperties) {
        if(source == null){
            return null;
        }
        try {
            final T target = targetClazz.newInstance();
            BeanUtils.copyProperties(source, target, ignoreProperties);
            return target;
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("BeanUtil 转换异常");
            return null;
        }
    }


    /**
     * 对象集合转换
     *
     * @param sources     数据源
     * @param targetClazz 目标对象class
     * @param ignoreProperties 忽略字段
     * @return 转换的集合
     */
    public static <T> List<T> toListBean(List<?> sources, final Class<T> targetClazz, String... ignoreProperties) {
        if (CollectionUtils.isEmpty(sources)) {
            return new ArrayList<>();
        }
        List<T> targets = new ArrayList<>(sources.size());
        sources.forEach(overdueRule -> targets.add(toBean(overdueRule, targetClazz,ignoreProperties)));
        return targets;
    }



    /**
     * 将空值的属性从目标实体类中复制到源实体类中
     * @param src : 要将属性中的空值覆盖的对象(源实体类)
     * @param target :从数据库根据id查询出来的目标对象
     * @Date: 2019-03-20 09:24:27
     */
    public static void copyNonNullProperties(Object  src,Object target){
        BeanUtils.copyProperties(src,target,getNullProperties(src));
    }

    /**
     * 将为空的properties给找出来,然后返回出来
     * @param src
     * @return
     */
    public static String[] getNullProperties(Object src){
        BeanWrapper srcBean=new BeanWrapperImpl(src);
        PropertyDescriptor[] pds=srcBean.getPropertyDescriptors();
        Set<String> emptyName=new HashSet<>();
        for(PropertyDescriptor p:pds){
            Object srcValue=srcBean.getPropertyValue(p.getName());
            if(srcValue==null) {emptyName.add(p.getName());}
        }
        String[] result=new String[emptyName.size()];
        return emptyName.toArray(result);
    }
}
