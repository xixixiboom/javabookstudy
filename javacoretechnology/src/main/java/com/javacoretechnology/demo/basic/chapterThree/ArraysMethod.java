package com.javacoretechnology.demo.basic.chapterThree;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysMethod {
    public static void main(String[] args) {
        commonApi();
    }

    public static void commonApi() {
        int[] intArray = new int[10];
        String[] strArray = new String[10];
        for (int i = 0; i < 10; i++) {
            intArray[i] = i + 1;
            strArray[i] = "String".concat(Integer.toString(i));
        }
        //数组拷贝   copy copyRange
        int[] intArrayCopy = Arrays.copyOf(intArray, 20);        //可以指定copy的长度，超过原数组长度会填充0或null或false
        String[] strArrayCopy = Arrays.copyOf(strArray, 20);
        for (int i = 0; i < strArrayCopy.length; i++) {
            System.out.println(intArrayCopy[i] + "\t" + strArrayCopy[i]);
        }

        //二分查找有序数组元素返回下标
        int index = Arrays.binarySearch(intArray, 2, 6, 3);
        System.out.println(index);

        //填充
        Arrays.fill(intArray, 4);
        for (int i : intArray) {
            System.out.println(i);
        }
    }
}
