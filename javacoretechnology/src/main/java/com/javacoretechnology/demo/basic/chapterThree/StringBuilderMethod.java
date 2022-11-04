package com.javacoretechnology.demo.basic.chapterThree;

import java.nio.file.Path;
import java.util.Scanner;

public class StringBuilderMethod {
    public static void main(String[] args) {
        commonApi();
    }

    public static void commonApi(){
        StringBuilder sb = new StringBuilder();
        sb.append("ddddd");         //增
        sb.append('e');
        sb.setCharAt(2,'m');    //改
        String str = sb.toString();
        System.out.println(str);
        sb.insert(1,'a');   //插入
        sb.insert(1,"b");
        System.out.println(sb);
        sb.delete(1,3);         //删
        System.out.println(sb);


        Scanner sc = new Scanner(System.in);
/*        System.out.println(sc.next());        //下一个单词
        System.out.println(sc.nextLine());      //下一行
        System.out.println(sc.nextInt());*/
        while(sc.hasNext()){
            System.out.println(sc.next());
            if("q".equals(sc.next())){
                break;
            }
        }

        int a=5;
        System.out.println(a);
        break_flag:
        while(a>2) {
            for (int i = 0; i < a; i++) {
                System.out.println(a);
                if (i > 2) {
                    break break_flag;
                }
            }
            System.out.println(a);
        }

    }

}
