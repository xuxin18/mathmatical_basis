package c1_basic_thinking.lesson7_permutation;

import java.util.ArrayList;

/**
 * @author xuxin
 * @date 2019/10/17 16:00
 * @description 假设有一个 4 位字母密码，每位密码是 a～e 之间的小写字母。你能否编写一段递归代码，来暴
 *              力破解该密码？（提示：根据可重复排列的规律，生成所有可能的 4 位密码。）
 */
public class Exercise7_1 {
    public static void main(String[] args) {
        char[] arr = {'a','b','c','d','e'};
        permulateWithRepetition(arr, new ArrayList<Character>());
        System.out.println("共有" + k + "种设置方式");
    }

    private static int k;

    public static void permulateWithRepetition(char[] arr, ArrayList<Character> result){
        if (result.size() == 4){
            System.out.println(result);
            k++;
            return;
        }

        for (int i=0; i<arr.length; i++){
            ArrayList<Character> newResult = (ArrayList<Character>) result.clone();
            newResult.add(arr[i]);
            permulateWithRepetition(arr, newResult);
        }
    }

}
