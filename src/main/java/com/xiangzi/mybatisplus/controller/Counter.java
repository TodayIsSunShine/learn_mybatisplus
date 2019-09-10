package com.xiangzi.mybatisplus.controller;

import java.io.File;

/**
 * description  用Java写一个递归遍历目录下面的所有文件
 * author:zhangxx
 * Date:2019/6/19
 * Time:10:00
 */
public class Counter {

    public static void main(String[] args) {
        File file = new File("D:\\workspace");
        //获取目录下的子文件夹及子文件
        File[] files = file.listFiles();
        readFile(files);
    }

    public static void readFile(File[] files) {
        if (null == files) {
            return;
        }
        for (File file : files) {
            //如果是文件
            if (file.isFile()) {
                System.out.println(file.getName());
                //如果是文件夹
            } else if (file.isDirectory()) {
                readFile(file.listFiles());
            }
        }
    }
}
