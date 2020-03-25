package c1_basic_thinking.lesson8_combination;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xuxin
 * @date 2019/10/18 11:22
 * @description 假设现在需要设计一个抽奖系统。
 *              需要依次从10个人中，抽取三等奖 3 名，二等奖 2名和一等奖 1 名。
 *              请列出所有可能的组合，需要注意的每人最多只能被抽中 1 次。
 *
 *              所有可能的组合有 C(10,3)*C(9,2)*C(8,1) 种
 */
public class Exercise8_1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<String> people = new ArrayList<String>(Arrays.asList("a","b","c", "d","e","f", "g","h","i", "j"));
        ArrayList<ArrayList> lists1 = combination(people, new ArrayList<>(), 3, new ArrayList<>());

        int kind = 0;
        for (int i = 0; i < lists1.size(); i++) {
            ArrayList<String> restPeople = (ArrayList<String>) people.clone();
            restPeople.removeAll(lists1.get(i));
            ArrayList<ArrayList> lists2 = combination(restPeople, new ArrayList<>(), 2, new ArrayList<>());
            for (int j = 0; j < lists2.size(); j++) {
                ArrayList<String> restPeople2 = (ArrayList<String>) restPeople.clone();
                restPeople2.removeAll(lists2.get(j));
                ArrayList<ArrayList> lists3 = combination(restPeople2, new ArrayList<>(), 1,new ArrayList<>());
                for (ArrayList s3:lists3){
                    System.out.println("三等奖为：" + lists1.get(i) + "二等奖为：" + lists2.get(j) + "一等奖为：" + s3);
                    kind++;
                }
            }
        }
        System.out.println("共有" + kind + "种情况");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static ArrayList<ArrayList> combination(ArrayList<String> people, ArrayList<String> luckey, int m, ArrayList<ArrayList> result){
        if (luckey.size() == m ){
            result.add(luckey);
        }

        for (int i = 0; i < people.size(); i++) {
            ArrayList<String> newLuckey = (ArrayList<String>) luckey.clone();
            newLuckey.add(people.get(i));
            ArrayList<String> newPeople = new ArrayList<>(people.subList(i+1,people.size()));
            combination(newPeople, newLuckey,m, result);
        }

        return result;
    }
}
