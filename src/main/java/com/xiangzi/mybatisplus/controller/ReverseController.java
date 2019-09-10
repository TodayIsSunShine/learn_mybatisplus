package com.xiangzi.mybatisplus.controller;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * description
 * author:zhangxx
 * Date:2019/6/19
 * Time:10:32
 */
public class ReverseController {


    public static void main(String[] args) {
        reverse();
    }

    public static void reverse() {

        LinkedList<Integer> linkedList = new LinkedList();
        LinkedList<Integer> tempList = new LinkedList<>();

        int i = 0;
        while (i < 6) {
            linkedList.add(i);
            i++;
        }

        Iterator<Integer> iterator = linkedList.iterator();
        int m;
        while (iterator.hasNext() && i >= 0) {
            m = iterator.next();
            tempList.addFirst(m);
            i--;
        }
        linkedList = tempList;
        System.out.println(linkedList);
    }
}
