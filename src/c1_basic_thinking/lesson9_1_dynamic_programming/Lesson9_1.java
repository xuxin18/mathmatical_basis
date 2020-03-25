package c1_basic_thinking.lesson9_1_dynamic_programming;

/**
 * @author xuxin
 * @date 2019/11/22 11:51
 * @description 计算两个字符间的编辑距离
 * 参考文章
 *      https://blog.csdn.net/u012891055/article/details/79188385
 *      https://zhuanlan.zhihu.com/p/80682302
 *
 * 编辑距离使用 DP 算法：
 *      删除 A 末尾一个字符（deletion）
 *      B 末尾 插入 A末尾的一个字符（insert）
 *      将 A 末尾的字符替换成 B 末尾的一个字符（replace）
 */
public class Lesson9_1 {
    public static void main(String[] args) {
        System.out.println(getStrDistance("mouse","mouuse"));
        System.out.println(getStrDistance("horse","ros"));
    }

    public static int getStrDistance(String a, String b){
        if (a==null || b==null){
            return -1;
        }

        //初始化用于记录状态转移的二维表
        int[][] dp = new int[a.length()+1][b.length()+1];

        //如果 i 为0，且 j>=0,那么 d[i,j]为j
        for (int j = 1; j <= b.length(); j++) {
            dp[0][j] = j;
        }

        //如果 i>=0,且j为0，那么 d[i,j]为i
        for (int i = 1; i <= a.length(); i++) {
            dp[i][0] = i;
        }

        //实现状态转移方程
        //代码里的状态转移是从 d[i, j] 到 d[i+1, j+1]，而不是从 d[i-1, j-1] 到 d[i, j]。本质上是一样的
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(
                            dp[i-1][j] +1, //删除--- a 字符串 i 位置的字符
                            dp[i][j-1] +1, //插入--- b 字符串 j 位置的字符
                            dp[i-1][j-1]+1 //替换--- 将 a 字符串 i 位置的字符替换为 b字符串 j位置的字符
                    );
                }

            }
        }
        return dp[a.length()][b.length()];
    }

    private static int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }


}
