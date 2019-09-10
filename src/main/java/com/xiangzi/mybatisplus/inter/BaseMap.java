package com.xiangzi.mybatisplus.inter;

/**
 * description HashMap的基类接口
 * author:zhangxx
 * Date:2019/6/18
 * Time:10:07
 */
public interface BaseMap<K, V> {

    //存
    public V put(K k, V v);

    //取
    public V get(K k);
}
