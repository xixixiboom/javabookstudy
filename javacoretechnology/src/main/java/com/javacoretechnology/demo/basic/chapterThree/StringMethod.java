package com.javacoretechnology.demo.basic.chapterThree;

public class StringMethod {
    public static void main(String[] args) {
        commonApi();
    }

    public static void commonApi(){
        String str1 = "Abc";
        String str2 = "ABC";
        String str3 = "ABCDE";
        // 判断两个字符串是否相等，不区分大小写
        Boolean bool1 = str1.equalsIgnoreCase(str2);
        System.out.println(bool1);

        // 检测字符串是否为空串
        if(str1.length() == 0) {}

        // 比较字符串内容,完全相等返回0
        int int1 = str2.compareTo(str2);
        System.out.println(int1);

        //字符串是否为空
        Boolean bool2= str2.isEmpty();
        System.out.println(bool2);

        // 返回指定位置char
        char ch = str2.charAt(2);
        System.out.println(ch);

        //字符串是否为空或者由空格组成 java11
//        Boolean bool3 = str2.blank();

        //以..为开头 为结尾
        Boolean bool3 = str2.startsWith("11");
        Boolean bool4 = str2.endsWith("1");

        //返回字符串匹配的子串出现的第一个位置
        int int2 = str2.indexOf("C",1);
        System.out.println(int2);

        //返回字符串匹配的子串出现的第一个位置
        int int3 = str2.lastIndexOf("C",1);

        //连接符
        if(str2.contains("fff"));
        String str4=String.join("__","asf","fff","fff");
        System.out.println(str4);

        String s = String.valueOf(3);


    }

}
