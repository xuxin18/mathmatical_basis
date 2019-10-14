package c1_basic_thinking.lesson1_binary;

/**
 * @author xuxin
 * @date 2019/10/14 16:44
 * @description 移位操作
 */
public class Lesson1_2 {

    public static void main(String[] args) {
        int num = 53;
        int m = 1;
        System.out.println("数字" + num + "向左移动" + m +  "位后是" + leftShift(num,m));
        System.out.println("数字" + num + "向右移动" + m +  "位后是" + rightShift(num,m));

        num = -53;
        m = 3;
        System.out.println("数字" + num + "向左移动" + m +  "位后是" + leftShift(num,m));
        System.out.println("数字" + num + "逻辑向右移动" + m +  "位后是" + rightShift(num,m));
        System.out.println("数字" + num + "算术向右移动" + m +  "位后是" + rightShiftwithSign(num,m));
    }

    /**
     * @description: 左移
     * @param num 等待移位的十进制
     * @param m 向左移的位数
     * @return int 移位后的十进制数
     */
    public static int leftShift(int num, int m){
        return num << m;
    }

    /**
     * @description: 逻辑右移（除符号位外左侧补0）
     * @param num 等待移位的十进制
     * @param m 向右移的位数
     * @return int 移位后的十进制数
     */
    public static int rightShift(int num, int m){
        return num >>> m;
    }

    /**
     * @description: 算术右移（除符号位外左侧补1）
     * @param num 等待移位的十进制
     * @param m 向右移的位数
     * @return int 移位后的十进制数
     */
    public static int rightShiftwithSign(int num, int m){
        return num >> m;
    }

}
