package com.xiangzi.mybatisplus.hashmap;

import com.xiangzi.mybatisplus.inter.BaseMap;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 * author:zhangxx
 * Date:2019/6/18
 * Time:10:11
 */
public class MyHashMap<K, V> implements BaseMap<K, V> {

    //HashMap的默认长度16
    private int defaultLength = 1 << 4;
    //默认负载因子
    private double defaultAddFactor = 0.75;
    //使用数组数量
    private double useSize;
    //数组
    private Entry<K, V>[] table = null;

    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int defaultLength, double defaultAddFactor) {
        if (defaultLength < 0) {
            throw new IllegalArgumentException("数组异常");
        }
        if (defaultAddFactor <= 0 || Double.isNaN(defaultAddFactor)) {
            throw new IllegalArgumentException("因子异常");
        }
        this.defaultLength = defaultLength;
        this.defaultAddFactor = defaultAddFactor;
        table = new Entry[defaultLength];
    }

    /**
     * 计算hashcode
     *
     * @param hashCode
     * @return
     */
    private int hash(int hashCode) {
        hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return hashCode ^ ((hashCode >>> 7) ^ hashCode >>> 4);
    }

    /**
     * 获取保存位置的数组下标
     *
     * @param k
     * @param length
     * @return
     */
    private int getIndex(K k, int length) {
        int m = length - 1;
        int index = hash(k.hashCode()) & m; //取模
        return index >= 0 ? index : -index;
    }

    /**
     * 存数据
     *
     * @param k
     * @param v
     * @return
     * @description 将得到的数据创建节点对象，计算出hashcode，得到对应下标，
     * 在对应数组的下标内，如果对应数组下标为null，直接将新的节点放入；
     * 反之，从链表头部开始遍历，如果存在相同key，说明是覆盖原来的值，反之将新节点插入链的尾部。
     */
    @Override
    public V put(K k, V v) {
        if (useSize > defaultLength * defaultAddFactor) {
            System.out.println("useSize:" + useSize);
            //扩容
            dilatation();
        }
        //计算出下标
        int index = getIndex(k, table.length);
        Entry<K, V> entry = table[index];
        Entry<K, V> newEntry = new Entry<>(k, v, null);
        if (entry == null) {
            table[index] = newEntry;
            //有占用位置
            useSize++;
        } else {
            Entry<K, V> t = entry;
            //相同key,修改当前value
            if (t.getKey() == k || (t.getKey() != null && t.getKey().equals(k))) {
                t.v = v;
            } else {
                while (t.next != null) {
                    //相同key,修改当前value
                    if (t.next.getKey() == k || (t.next.getKey() != null && t.next.getKey().equals(k))) {
                        t.next.v = v;
                        break;
                    } else {
                        t = t.next;
                    }
                }

                if (t.next == null) {
                    t.next = newEntry;
                }
            }
        }
        return newEntry.getValue();
    }

    /**
     * 取值
     * 得到下标，剩下的就是链表找值的问题
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        //获取下标
        int index = getIndex(k, table.length);
        Entry<K, V> entry = table[index];
        if (null == entry) {
            throw new NullPointerException();
        }

        while (null != entry) {
            if (entry.getKey() == k || entry.getKey().equals(k)) {
                return entry.v;
            } else {
                entry = entry.next;
            }
        }
        return null;
    }

    /**
     * 扩容
     */
    private void dilatation() {
        Entry<K, V>[] newTable = new Entry[defaultLength * 2];
        List<Entry<K, V>> list = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;
            //遍历链表 添加到list
            Entry<K, V> entry = table[i];
            while (entry != null) {
                list.add(entry);
                entry = entry.next;
            }
        }
        if (list.size() > 0) {
            useSize = 0;
            defaultLength = defaultLength * 2;
            table = newTable;
            for (Entry<K, V> entry : list) {
                //分离所有的entry
                if (entry.next != null) {
                    entry.next = null;
                }
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
