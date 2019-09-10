package com.xiangzi.mybatisplus.hashmap;

import com.xiangzi.mybatisplus.inter.BaseEntry;

/**
 * description  HashMap是通过数组+链表,所以这边的节点是链表中的节点
 * author:zhangxx
 * Date:2019/6/18
 * Time:10:09
 */
public class Entry<K, V> implements BaseEntry {

    K k;
    V v;
    Entry<K, V> next;  //指向下一个节点

    public Entry(K k, V v, Entry<K, V> next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}
