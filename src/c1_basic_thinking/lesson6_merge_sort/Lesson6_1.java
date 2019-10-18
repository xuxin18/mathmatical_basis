package c1_basic_thinking.lesson6_merge_sort;

import java.util.Arrays;

/**
 * @author xuxin
 * @date 2019/10/16 15:15
 * @description 归并排序
 */
public class Lesson6_1 {

    public static void main(String[] args) {
        int[] arr = {34,75,13,18,1,7,9,5,4,11,76,19,2};
        int[] sorted = mergeSort(arr);

        System.out.println(Arrays.toString(sorted));
    }

    /**
     * @description: 使用函数的递归（嵌套）调用，实现归并排序（从小到大）
     * @param arr- 等待排序的数组
     * @return int[]- 排序后的数组
     */
    public static int[] mergeSort(int[] arr){
        if (arr == null){
            return new int[0];
        }

        // 如果分解到只剩一个数，返回该数
        if (arr.length == 1){
            return arr;
        }

        // 将数组分解成左右两半
        int mid = arr.length/2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // 嵌套调用,对左右两半分别进行排序
        left = mergeSort(left);
        right = mergeSort(right);

        // 合并排序后的两半
        int[] merged = merge(left, right);

        return merged;
    }

    /**
     * @description: 合并两个已经排序完毕的数组（从小到大）
     * @param left- 左数组
     * @param right- 右数组
     * @return int[]- 合并后的数组
     */
    private static int[] merge(int[] left, int[] right) {
        if (left == null){
            left = new int[0];
        }

        if (right == null){
            right = new int[0];
        }

        int[] mergedNew = new int[left.length + right.length];

        int mi=0, li=0, ri=0;

        // 轮流从两个数组中取出最小的值，放入合并后的数组中
        while (li<left.length && ri<right.length){
            if (left[li] <= right[ri]){
                mergedNew[mi] = left[li];
                li++;
            }else {
                mergedNew[mi] = right[ri];
                ri++;
            }
            mi++;
        }

        // 将某个数组内剩余的数字放入合并后的数组中
        if (li < left.length){
            for (int i=li; i<left.length; i++){
                mergedNew[mi] = left[i];
                mi++;
            }
        }else {
            for (int i=ri; i<right.length; i++){
                mergedNew[mi] = right[i];
                mi++;
            }
        }
        return mergedNew;
    }
}
