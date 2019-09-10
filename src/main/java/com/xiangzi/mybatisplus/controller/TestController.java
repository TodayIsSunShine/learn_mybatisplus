package com.xiangzi.mybatisplus.controller;

import com.xiangzi.mybatisplus.hashmap.MyHashMap;

/**
 * description 手写一个hashmap
 * author:zhangxx
 * Date:2019/6/18
 * Time:14:35
 */
public class TestController {

    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap();
        myHashMap.put("hello", "world");
        myHashMap.put("xiaobai", "heihei");
        myHashMap.put("a", "a");
        myHashMap.put("v", "b");
        myHashMap.put("r", "c");
        myHashMap.put("e", "d");
        myHashMap.put("11", "66");
        myHashMap.put("22", "77");
        myHashMap.put("7777", "77777");
        myHashMap.put("88888", "88888");
        myHashMap.put("9999", "9999");
        myHashMap.put("tttt", "hghghghg");
        myHashMap.put("uuiuiui", "oiuykghhdf");
        myHashMap.put("vcbcvbcbcvbcvbcv", "fsdfsdfsfsd");
        myHashMap.put("trterteterter", "sdfsdgdfgfgfhgf");
        myHashMap.put("元旦节as端", "开始路径的拉开");
        myHashMap.put("的顺丰到付", "给对方给对方给对方");
        myHashMap.put("********", "·······");
        String hello = myHashMap.get("hello");
        String xiaobai = myHashMap.get("xiaobai");
        System.out.println(hello);
        System.out.println(xiaobai);
    }
}
