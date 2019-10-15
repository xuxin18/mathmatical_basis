package c1_basic_thinking.lesson3_iterative;

/**
 * @author xuxin
 * @date 2019/10/15 13:36
 * @description
 */
public class Lesson3_2 {

    public static void main(String[] args) {
        int num = 10;
        double deltaShold = 0.000001;
        int maxTry = 1000;
        double squareRoot = getSquareRoot(num, deltaShold, maxTry);
        if (squareRoot == -1.0){
            System.out.println("请输入大于1的整数");
        }else if (squareRoot == -2.0){
            System.out.println("在" + maxTry + "次尝试中未能找到复合要求的解，请加大尝试次数");
        }else {
            System.out.println("误差在" + deltaShold + "内" + num + "的平方根为" + squareRoot);
        }
    }

    /**
     * @description: 计算大于1的正整数的平方根
     * @param n- 待求的数
     * @param deltaThreshold- 误差阈值
     * @param maxTry- 二分查找的最大次数
     * @return double- 平方根的解
     */
    public static double getSquareRoot(int n, double deltaThreshold, int maxTry){
        if (n <= 1){
            return -1.0;
        }

        double min = 1.0, max = n;
        for (int i=0; i<maxTry; i++){
            double middle = min + (max-min)/2;
            double square = middle*middle;
            double delta = Math.abs((square/n)-1);
            if (delta <= deltaThreshold){
                return middle;
            }else {
                if (square > n){
                    max = middle;
                }else {
                    min = middle;
                }
            }
        }

        return -2.0;
    }
}
