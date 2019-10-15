package c1_basic_thinking.lesson5_recursive;

import java.util.ArrayList;

/**
 * @author xuxin
 * @date 2019/10/15 16:38
 * @description
 */
public class Lesson5_1 {

    public static void main(String[] args) {
        int descTotalReward = 10;
        descGet(descTotalReward, new ArrayList<>());
        System.out.println(m);

        int ascTotalReward = 0;
        ascGet(ascTotalReward, new ArrayList<>());
        System.out.println(m);
    }

    // 四种面额的纸币
    public static long[] rewards = {1,2,5,10};
    public static int m;

    /**
     * @description: 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合  逆向递归
     * @param totalReward- 奖赏总金额
     * @param result- 保存当前的解
     * @return void
     */
    public static void descGet(long totalReward, ArrayList<Long> result){
        if (totalReward == 0){
            // 当 totalReward = 0时，证明它是满足条件的解，结束嵌套使用，输出解
            System.out.println(result);
            m++;
            return;
        }else if (totalReward < 0){
            // 当 totalReward < 0时，证明它不是满足条件的解，不输出
            return;
        }else {
            for (int i=0; i<rewards.length; i++){
                ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
                newResult.add(rewards[i]);
                descGet(totalReward-rewards[i], newResult);
            }
        }
    }

    /**
     * @description: 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合  顺向递归
     * @param totalReward- 奖赏总金额
     * @param result- 保存当前的解
     * @return void
     */
    public static void ascGet(long totalReward, ArrayList<Long> result){
        for (int i=0; i<rewards.length; i++){
            if (totalReward+rewards[i] < 10){
                ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
                newResult.add(rewards[i]);
                ascGet(totalReward+rewards[i], newResult);
            }else if (totalReward+rewards[i] == 10){
                result.add(rewards[i]);
                System.out.println(result);
                m++;
            }else {
                return;
            }
        }
    }


}
