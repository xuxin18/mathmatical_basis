package c1_basic_thinking.lesson10_1_trieTree;

import java.util.HashMap;

/**
 * @author xuxin
 * @date 2019/12/5 13:53
 * @description 构建一个TrieTree字典
 */
public class Exercise10_1 {
}

class TreeNode{
    //结点的名称（在前缀树中即为 单个字母）
    public char label;

    //使用哈希映射存放子结点。哈希便于确认是否已经添加过某个字母对应的结点。
    public HashMap<Character,TreeNode> sons = null;

    // 从树的根到当前结点这条通路上，全部字母所组成的前缀。例如通路 b->o->y，对于字母 o 结点而言，前缀是 b；对于字母 y 结点而言，前缀是 bo
    public String prefix = null;

    // 词条的解释
    public String explanation = null;

    public TreeNode(char label, HashMap<Character, TreeNode> sons, String prefix, String explanation) {
        this.label = label;
        this.sons = new HashMap<>();
        this.prefix = prefix;
        this.explanation = explanation;
    }
}
