package c1_basic_thinking.lesson4_mathmatical_induction;

/**
 * @author xuxin
 * @date 2019/10/15 15:18
 * @description 数学归纳和递归调用的逻辑是一样的
 */
public class Lesson4_2 {

    public static void main(String[] args) {
        int grid = 63;
        Result r = new Result();
        System.out.println(prove(grid,r));
    }

    /**
     * @description: 使用函数的递归（嵌套）调用，进行数学归纳法证明
     * @param k- 放到第几格
     * @param result- 保存当前格子的麦粒数和麦粒总数
     * @return boolean- 放到第k格时是否成立
     */
    public static boolean prove(int k, Result result){
        // 证明 n=1 时，命题是否成立
        if (k == 1){
            if (Math.pow(2,1) - 1 == 1){
                result.wheatNum = 1;
                result.wheatTotalNum = 1;
                return true;
            }else {
                return false;
            }
        }else {
            // 如果 n = k-1 时命题成立，证明 n = k 时命题是否成立
            boolean proveOfPreviousOne = prove(k-1, result);// 逆向递推
            result.wheatNum *= 2;
            result.wheatTotalNum += result.wheatNum;

            boolean proveOfCurrentOne = false;
            if (result.wheatTotalNum == Math.pow(2,k)-1){
                proveOfCurrentOne = true;
            }

            if (proveOfPreviousOne && proveOfCurrentOne){
                return true;
            }else {
                return false;
            }
        }


    }
}

class Result{
    //当前格的麦粒数
    public long wheatNum = 0;
    //目前为止麦粒的总数
    public long wheatTotalNum = 0;
}
