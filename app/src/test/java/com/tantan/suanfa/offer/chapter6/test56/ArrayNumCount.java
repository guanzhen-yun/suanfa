package com.tantan.suanfa.offer.chapter6.test56;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** 数组中数字出现的次数 */
public class ArrayNumCount {

    @Test
    public void main() {
        int[] arrays = {2,4,3,6,3,2,5,5};
//        List<Integer> list  = getFirstAppearNums(arrays);
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
        System.out.println(getFirstAppearNumsByYihuo(arrays));
    }

    //数组中只出现一次的两个数字

    //异或解法 空间复杂度1 时间复杂度2n
    private String getFirstAppearNumsByYihuo(int[] arrays) {
        if (arrays == null || arrays.length < 2) return null;
        int resultExclusiveOR = 0;
        for (int array : arrays) {
            resultExclusiveOR ^= array;
        }

        int indexOf1 = findFirstBidIs1(resultExclusiveOR);

        int num1 = 0;
        int num2 = 0;

        for (int j=0;j<arrays.length;j++) {
            if (isBit1(arrays[j], indexOf1)) {
                num1 ^= arrays[j];
            }
            else {
                num2 ^= arrays[j];
            }
        }
        return num1 + "," + num2;
    }

    //找出最右边一位为1的位置
    private int findFirstBidIs1(int num) { //0010   0001
        int indexBit = 0;
        while ((num & 1) == 0) {
            num = num >> 1; //右移
            ++indexBit;
        }
        return indexBit;//1
    }

    //判断num第indexBit位是否为1
    private boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    private List<Integer> getFirstAppearNums(int[] arrays) {
        List<Integer> list = new ArrayList<>();

        for (int i=0;i<arrays.length;i++) {
            Integer j = arrays[i];
            if (list.contains(j)) {
                list.remove(j);
            }
            else {
                list.add(j);
            }
        }
        return list;
    }
}
