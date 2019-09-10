package com.xiangzi.mybatisplus.inter;

/**
 * description  节点的基类接口
 * author:zhangxx
 * Date:2019/6/18
 * Time:9:49
 */
public interface BaseEntry<K, V> {

    public K getKey();  //获取键

    public V getValue(); //获取值
}
