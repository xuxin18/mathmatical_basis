package c1_basic_thinking.lesson4_mathmatical_induction;

import c1_basic_thinking.lesson3_iterative.Lesson3_1;

/**
 * @author xuxin
 * @date 2019/10/15 15:07
 * @description 通过数学归纳法，来计算国王需要付出多少粒麦子的问题
 */
public class Lesson4_1 {

    public static void main(String[] args) {
        int grid = 63;

        long start = 0,end = 0;
        start = System.currentTimeMillis();
        long v1 = Lesson3_1.getNumOfWheat(grid);
        end = System.currentTimeMillis();
        System.out.println("使用迭代法计算耗时: " + (end-start) + "毫秒");

        start = System.currentTimeMillis();
        long v2 = (long) ((Math.pow(2, grid)) - 1);
        end = System.currentTimeMillis();
        System.out.println("使用数学归纳法计算耗时: " + (end-start) + "毫秒");

        System.out.println(v1);
        System.out.println(v2);
    }
}
