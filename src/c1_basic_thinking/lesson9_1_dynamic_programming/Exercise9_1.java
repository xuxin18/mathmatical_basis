package c1_basic_thinking.lesson9_1_dynamic_programming;

/**
 * @author xuxin
 * @date 2019/11/22 17:14
 * @description 有3张纸币面额分别是：2,3,7元，求100元钱最少由多少张纸币组成
 *
 */
public class Exercise9_1 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        //先求 2,3,7之间的最大公约数
        int gcd = gcd(7,gcd(3,2));
        int lcm = 2*3*7/gcd;
        System.out.println(lcm);
        int[] coins = {2,3,7};

        System.out.println(getMinKindCoin1(coins,100%lcm)+(100-(100%lcm))/7);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        System.out.println(getMinKindCoin2(coins,1));
        System.out.println(getMinKindCoin2(coins,2));
        System.out.println(getMinKindCoin2(coins,3));
        System.out.println(getMinKindCoin2(coins,4));
        System.out.println(getMinKindCoin2(coins,1));
        System.out.println(getMinKindCoin2(coins,1));

        System.out.println(getMinKindCoin1(coins,1));

    }

    public static int getMinKindCoin2(int[] coins, int amount){
        int[] dp = new int[amount+1];
        //数组初始状态，假设所有情况都无解
        for (int i = 0; i < amount+1; i++) {
            dp[i] = -1;
        }

        //表示 0 元钱 需要 0 张币组成
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i-coins[j]] != -1){
                    if (dp[i] == -1){
                        //初始状态时
                        dp[i] = dp[i-coins[j]]+1;
                    }else {
                        //选取最优解
                        dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                    }
                }
            }
        }
        return dp[amount];
    }

    public static int getMinKindCoin1(int[] coins,int amount){
        int[] dp = new int[amount+1];
        for (int i = 1; i <=amount; i++) {
            if (i-2==0 || i-3==0 || i-7==0){
                dp[i]=1;
            }else if(i==1){
                dp[i]= -1;
            }else if(i==4){
                dp[i]= 2;
            }else if(i==5){
                dp[i]= 2;
            }else if(i==6){
                dp[i]= 2;
            }else if(i==8){
                dp[i]= 3;
            }else if(i>8) {
                dp[i] = min(
                        dp[i-2]+1,
                        dp[i-3]+1,
                        dp[i-7]+1
                );
            }
        }
        return dp[amount];
    }

    private static int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

   /**
    * 辗转相除法
    * 两个正整数a和b (a > b)，它们的最大公约数等于 a 除以 b 的余数 c 和 b 之间的最大公约数
    * 既：
    *   gcd(a,b)=gcd(b,a mod b)   (a>b!=0)
    *   gcd(a,0)=a
    */
    public static int gcd(int a, int b){
        return (b==0)?a:gcd(b,a%b);
    }

    /**
     * 两个数之间的最小 公倍数
     * gcd(a,b)*lcm(a,b)=a*b
     */
    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
