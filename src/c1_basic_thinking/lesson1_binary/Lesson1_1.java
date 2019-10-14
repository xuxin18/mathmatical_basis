package c1_basic_thinking.lesson1_binary;

import java.math.BigInteger;

/**
 * @author xuxin
 * @date 2019/10/14 14:54
 * @description 十进制与二进制互相转换
 */
public class Lesson1_1 {

    public static void main(String[] args) {
        int a = 53;
        System.out.println("数字" + a + "转换成二进制后为：" + decimalTobinary(a));
        String b = "110101";
        System.out.println("数字" + b + "转换成十进制后为：" + binaryToDecimal(b));
    }

    /**
     * @description: 十进制转换成二进制
     * @param decimalSource
     * @return String
     */
    public static String decimalTobinary(int decimalSource){
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        // 参数 2 指定的是转换成二进制
        return bi.toString(2);
    }

    /**
     * @description: 十进制转换成二进制
     * @param binarySource
     * @return int
     */
    public static int binaryToDecimal(String binarySource){
        //参数 2 指定 binarySource 是二进制数据
        BigInteger bi = new BigInteger(binarySource,2);
        // bi.toString() 默认将 二进制数据转换成十进制数据
        return Integer.parseInt(bi.toString());
    }
}
