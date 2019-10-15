package c1_basic_thinking.lesson5_recursive;

import java.util.ArrayList;

/**
 * @author xuxin
 * @date 2019/10/15 20:15
 * @description 一个整数可以被分解为多个整数的乘积，例如:6 可以分解为 2x3。
 *              请使用递归编程的方法，为给定的整数 n，找到所有可能的分解（1 在解中最多只能出现 1 次）。
 *              例如，输入8，输出是可以是 1x8, 8x1, 2x4, 4x2, 1x2x2x2, 1x2x4, ……
 */
public class Exercize5_1 {

    public static void main(String[] args) {
        long total = 9;
        factoreNum(total, new ArrayList<Long>());
    }

    public static void factoreNum(long total, ArrayList<Long> result){
        if (total == 1){
            if (!result.contains(1L)){
                result.add(1L);
            }
            System.out.println(result);
        }else {
            for (long i=1; i<=total; i++){
                if (i==1 && result.contains(1L)){
                    continue;
                }

                if (total % i != 0){
                    continue;
                }

                ArrayList<Long> newList = (ArrayList<Long>) result.clone();
                newList.add(i);

                factoreNum(total/i, newList);
            }
        }
    }
}
