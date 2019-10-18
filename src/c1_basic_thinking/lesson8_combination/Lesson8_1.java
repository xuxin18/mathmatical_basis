package c1_basic_thinking.lesson8_combination;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xuxin
 * @date 2019/10/17 20:18
 * @description
 */
public class Lesson8_1 {

    public static void main(String[] args) {
        // 从 4 个元素中选择 2 个元素的所有组合
        ArrayList<String> teams = new ArrayList<String>(Arrays.asList("t1","t2","t3", "t4"));
        combine(teams, new ArrayList<String>(), 2);
    }

    /**
     * @description: 使用函数的递归（嵌套）调用，找出所有可能的队伍组合
     * @param teams- 目前还剩多少队伍没有参与组合
     * @param result- 保存当前已经组合的队伍
     * @param m- 每次取几个元素
     * @return void- 放到第k格时是否成立
     */
    public static void combine(ArrayList<String> teams, ArrayList<String> result, int m){
        if (result.size() == m){
            System.out.println(result);
            return;
        }

        for (int i = 0; i < teams.size(); i++) {
            // 从剩下的队伍中，选择一队，加入结果
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(teams.get(i));

            // 只考虑当前选择之后的所有队伍
            ArrayList<String> restTeams = new ArrayList<String>(teams.subList(i+1,teams.size()));

            // 递归调用，对于剩余的队伍继续生成组合
            combine(restTeams, newResult, m);
        }
    }
}
