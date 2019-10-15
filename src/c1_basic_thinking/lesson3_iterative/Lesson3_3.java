package c1_basic_thinking.lesson3_iterative;

import java.util.Arrays;

/**
 * @author xuxin
 * @date 2019/10/15 13:54
 * @description
 */
public class Lesson3_3 {

    public static void main(String[] args) {
        String[] dictionary = {"i", "am", "one", "of", "the", "authors", "in", "geekbang"};
        Arrays.sort(dictionary);
        String wordToFind = "i";
        if (search(dictionary,wordToFind)){
            System.out.println("在dictionary中存在单词" + wordToFind);
        }else {
            System.out.println("在dictionary中不存在单词" + wordToFind);
        }
    }

    /**
     * @description: 查找某个单词是否在字典里出现
     * @param dictionary- 排序后的字典
     * @param wordToFind- 待查的单词
     * @return boolean- 是否发现待查的单词
     */
    public static boolean search(String[] dictionary, String wordToFind){
        if (dictionary == null){
            return false;
        }

        if (dictionary.length == 0){
            return false;
        }

        int left = 0, right = dictionary.length - 1;
        while (left <= right){
            int middle = left + (right - left)/2;
            if (dictionary[middle].equals(wordToFind)){
                return true;
            }else {
                if (dictionary[middle].compareTo(wordToFind) > 0){
                    right = middle - 1;
                }else {
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
