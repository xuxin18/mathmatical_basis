package c1_basic_thinking.lesson7_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xuxin
 * @date 2019/10/16 20:08
 * @description
 */
public class Lesson7_1 {

    public static void main(String[] args) {

        //田忌的马出战顺序未定，齐王的马出战顺序为 q1、q2、q3
        ArrayList<String> tHorses = new ArrayList<>(Arrays.asList("t1","t2","t3"));
        permutate(tHorses, new ArrayList<String>());
    }

    /*
        第一层花括号代表创建了一个匿名内部类
        第二层花括号实际上是一个实例初始化块
        这种写法比普通写法效率稍低，一般不建议这么写。
        具体可参考：https://cloud.tencent.com/developer/article/1043825

        设置齐王的马跑完所需要的时间
     */
    public static HashMap<String, Double> qHoursesTime = new HashMap<String, Double>(){
        {
            put("q1",1.0);
            put("q2",2.0);
            put("q3",3.0);
        }
    };

    //设置田忌的马跑完所需时间
    public static HashMap<String, Double> tHoursesTime = new HashMap<String, Double>(){
        {
            put("t1",1.5);
            put("t2",2.5);
            put("t3",3.5);
        }
    };

    // 齐王的马出战顺序
    public static ArrayList<String> qHorses = new ArrayList<>(Arrays.asList("q1","q2","q3"));

    /**
     * @description: 使用函数的递归（嵌套）调用，找出所有可能的马匹出战顺序
     * @param horses- 目前还剩多少马没有出战
     * @param result- 保存田忌已经出战的马匹和顺序
     * @return void
     */
    public static void permutate(ArrayList<String> horses, ArrayList<String> result){
        if (horses.size() == 0){
            System.out.println(result);
            compare(result,qHorses);
            System.out.println();
            return;
        }
        for (int i=0; i<horses.size(); i++){
            // 从剩下的马中，选择一匹加入结果
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(horses.get(i));

            // 将选择的马从未出战的列表中移出
            ArrayList<String> restHorses = (ArrayList<String>) horses.clone();
            restHorses.remove(i);

            //递归调用，对于剩余的马匹继续生成排列
            permutate(restHorses, newResult);

        }
    }

    /**
     * @description: 比较田忌和齐王的马匹，看哪方获胜
     * @param t- 田忌的马出战顺序
     * @param q- 齐王的马出战顺序
     * @return void
     */
    public static void compare(ArrayList<String> t, ArrayList<String> q){
        int tWin = 0;
        for (int i=0; i<t.size(); i++){
            double tTime = tHoursesTime.get(t.get(i));
            double qTime = qHoursesTime.get(q.get(i));
            System.out.print("田忌出战的马跑完全程耗时：" + tTime + " 分钟；    ");
            System.out.println("齐王出战的马跑完全程耗时：" + qTime + " 分钟");
            if (tTime < qTime){
                tWin++;
            }
        }

        if (tWin > (t.size()/2)){
            System.out.println("田忌获得最终胜利");
        }else {
            System.out.println("齐王获得最终胜利");
        }
    }

}
