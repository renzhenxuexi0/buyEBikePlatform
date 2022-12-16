package com.softwareEngineering.electrocar.utils;

import java.util.Random;

public class RandomStringUtil {

    /**
     * 随机生成一个length长度的字符串 如length是3，则生成ABC或a3B类似的3位字符串
     * @param length 字符串的字符数
     * @return 返回生成的字符串
     */
    public static String randomString(int length){
        //定义一个包含大写小写字母和数字的无重复字符串
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        //获取随机函数对象变量
        Random random = new Random();
        //创建字符串变量
        StringBuilder stringBuilder = new StringBuilder();
        //循环获取随机数字，并将数字对应的索引找出str中的字符添加到字符串变量中
        for (int i = 0; i < length; i++) {
            //随机生成一个正数，这个正数的范围是[0,62),包含0不包含62，这里数值可以修改
            //以上面str字符串为例，如果想要纯小写则数字改为26，也可以替换str为纯小写或者纯大写或者纯数字
            int number = random.nextInt(62);
//            System.out.println(number);
            System.out.println(str.charAt(number));
            //number为索引，在str中取出对应索引的字符，添加到stringBuilder中
            stringBuilder.append(str.charAt(number));
        }
        return stringBuilder.toString();
    }

    /**
     * 生成随机字符串（纯数字）
     * @param length 字符长度
     * @return 返回指定字符长度的随机数字字符串
     */
    public static String randomStringForNumbers(int length){
        //定义一个包含大写小写字母和数字的无重复字符串
        String str = "1234567890";
        //获取随机函数对象变量
        Random random = new Random();
        //创建字符串变量
        StringBuilder stringBuilder = new StringBuilder();
        //循环获取随机数字，并将数字对应的索引找出str中的字符添加到字符串变量中
        for (int i = 0; i < length; i++) {
            //随机生成一个正数，这个正数的范围是[0,62),包含0不包含62，这里数值可以修改
            //以上面str字符串为例，如果想要纯小写则数字改为26，也可以替换str为纯小写或者纯大写或者纯数字
            int number = random.nextInt(10);
//            System.out.println(number);
//            System.out.println(str.charAt(number));
            //number为索引，在str中取出对应索引的字符，添加到stringBuilder中
            stringBuilder.append(str.charAt(number));
        }
        return stringBuilder.toString();
    }

    /**
     * 生成随机字符串（纯字母大写）
     * @param length 字符长度
     * @return 返回指定字符长度的随机大写字母字符串
     */
    public static String randomStringForUpper(int length){
        //定义一个包含大写小写字母和数字的无重复字符串
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //获取随机函数对象变量
        Random random = new Random();
        //创建字符串变量
        StringBuilder stringBuilder = new StringBuilder();
        //循环获取随机数字，并将数字对应的索引找出str中的字符添加到字符串变量中
        for (int i = 0; i < length; i++) {
            //随机生成一个正数，这个正数的范围是[0,62),包含0不包含62，这里数值可以修改
            //以上面str字符串为例，如果想要纯小写则数字改为26，也可以替换str为纯小写或者纯大写或者纯数字
            int number = random.nextInt(26);
//            System.out.println(number);
//            System.out.println(str.charAt(number));
            //number为索引，在str中取出对应索引的字符，添加到stringBuilder中
            stringBuilder.append(str.charAt(number));
        }
        return stringBuilder.toString();
    }

    /**
     * 生成随机字符串（纯字母小写）
     * @param length 字符长度
     * @return 返回指定字符长度的随机小写字母字符串
     */
    public static String randomStringForLower(int length){
        //定义一个包含大写小写字母和数字的无重复字符串
        String str = "abcdefghijklmnopqrstuvwxyz";
        //获取随机函数对象变量
        Random random = new Random();
        //创建字符串变量
        StringBuilder stringBuilder = new StringBuilder();
        //循环获取随机数字，并将数字对应的索引找出str中的字符添加到字符串变量中
        for (int i = 0; i < length; i++) {
            //随机生成一个正数，这个正数的范围是[0,62),包含0不包含62，这里数值可以修改
            //以上面str字符串为例，如果想要纯小写则数字改为26，也可以替换str为纯小写或者纯大写或者纯数字
            int number = random.nextInt(26);
            //number为索引，在str中取出对应索引的字符，添加到stringBuilder中
            stringBuilder.append(str.charAt(number));
        }
        return stringBuilder.toString();
    }

    /**
     * 生成随机字符串（特殊字符）
     * @param length 字符长度
     * @return 返回指定字符长度的随机特殊字符字符串
     */
    public static String randomStringForSpecial(int length){
        //定义一个包含大写小写字母和数字的无重复字符串
//        String str = "~!@#$%^&*()_+,./\\<>?|";
        String str = "~!@#$%^&*_-,.";
        //获取随机函数对象变量
        Random random = new Random();
        //创建字符串变量
        StringBuilder stringBuilder = new StringBuilder();
        //循环获取随机数字，并将数字对应的索引找出str中的字符添加到字符串变量中
        for (int i = 0; i < length; i++) {
            //随机生成一个正数，这个正数的范围是[0,62),包含0不包含62，这里数值可以修改
//            int number = random.nextInt(21);
            int number = random.nextInt(14);
            //number为索引，在str中取出对应索引的字符，添加到stringBuilder中
            stringBuilder.append(str.charAt(number));
        }
        return stringBuilder.toString();
    }


    /**
     * 随机生成五组字符串并且以“-”连接
     * @return 返回字符串
     */
    public static String getUuid(){
        String uuid = "";
        for (int i = 0; i < 5; i++) {
            if(i!=4){
                uuid+=randomString(5)+"-";
//                uuid+="-";
            }else{
                uuid+=randomString(5);
            }
        }
        return uuid;
    }


    public static String getIpAddress(){
        String ipAddress = "";
        for (int i = 0; i < 6; i++) {
            if(i!=5){
                ipAddress+=randomStringForNumbers(4)+":";
//                uuid+="-";
            }else{
                ipAddress+=randomStringForNumbers(4);
            }
        }
        return ipAddress;
    }
}

