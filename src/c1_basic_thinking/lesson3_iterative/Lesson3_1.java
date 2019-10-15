package c1_basic_thinking.lesson3_iterative;

/**
 * @author xuxin
 * @date 2019/10/15 11:39
 * @description 古印度国王舍罕酷爱下棋，他打算重赏国际象棋的发明人宰相西萨·班·达依
 *              尔。这位聪明的大臣指着象棋盘对国王说：“陛下，我不要别的赏赐，请您
 *              在这张棋盘的第一个小格内放入一粒麦子，在第二个小格内放入两粒，第三
 *              小格内放入给四粒，以此类推，每一小格内都比前一小格加一倍的麦子，直
 *              至放满 64 个格子，然后将棋盘上所有的麦粒都赏给您的仆人我吧！”
 */
public class Lesson3_1 {

    public static void main(String[] args) {
        int grid = 63;
        System.out.println("到" + grid + "格时，共需要" + getNumOfWheat(grid) + "粒谷子" );
    }

    /**
     * @description: 计算国王需要给多少粒麦子
     * @param grid- 放到第几格
     * @return long- 麦粒的总数
     */
    public static long getNumOfWheat(int grid){
        //麦粒总数
        long sum = 0;
        //当前格子里麦粒的数量
        long numOfWheatInGrid = 0;

        // 第一个格子里的麦粒的数量
        numOfWheatInGrid = 1;
        sum += numOfWheatInGrid;
        for (int i=2; i<=grid; i++){
            numOfWheatInGrid *=2;
            sum += numOfWheatInGrid;
        }

        return sum;
    }
}
