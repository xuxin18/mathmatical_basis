package c1_basic_thinking.lesson1_binary;

/**
 * @author xuxin
 * @date 2019/10/14 17:01
 * @description 逻辑运算
 */
public class Lesson1_3 {

    public static void main(String[] args) {
        int a = 53;
        int b = 35;
        System.out.println("数字" + a + "和数字" + b + "或操作的结果是" + or(a,b));
        System.out.println("数字" + a + "和数字" + b + "与操作的结果是" +and(a,b));
        System.out.println("数字" + a + "和数字" + a + "异或操作的结果是" +xor(a,a));
    }

    /**
     * @description: 或操作
     * @param num1
     * @param num2
     * @return 或操作后的结果
     */
    public static int or(int num1, int num2){
        return (num1 | num2);
    }

    /**
     * @description: 与操作
     * @param num1
     * @param num2
     * @return 与操作后的结果
     */
    public static int and(int num1, int num2){
        return (num1 & num2);
    }

    /**
     * @description: 异或操作
     * @param num1
     * @param num2
     * @return 异或操作后的结果
     */
    public static int xor(int num1, int num2){
        return (num1 ^ num2);
    }
}
