package c1_basic_thinking.lesson10_1_trieTree;

/**
 * @author xuxin
 * @date 2019/12/2 10:55
 * @description 前缀树
 *
 * 参考文章：
 *      https://juejin.im/post/5c93355651882556dc4be6c9
 *      https://github.com/chaoaiqi/study/blob/master/java/src/juejin/lc/tree/TrieTree.java
 *
 *
 */
public class Lesson10_1 {
    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("hello");
        tree.insert("hi");
        tree.insert("how");
        System.out.println(tree);
    }
}

/**
 * Trie树结点
 */
class TrieNode{
    //字符
    private char data;

    //子结点
    private TrieNode[] children;

    //标识
    private boolean isEndingChar;

    public TrieNode(char data) {
        this.data = data;
        this.children = new TrieNode[26];
        this.isEndingChar = false;
    }



    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isEndingChar() {
        return isEndingChar;
    }

    public void setEndingChar(boolean endingChar) {
        isEndingChar = endingChar;
    }
}

/**
 * Trie树
 */
class TrieTree{

    //根结点
    private TrieNode root;

    //输入值
    private String pattern;

    //初始化时，根结点存储一个无意义的字符
    public TrieTree() {
        root = new TrieNode('/');
    }

    //插入
    public void insert(String s){
        char[] txt = s.toCharArray();
        TrieNode p = root;
        for (char c:txt){
            //节约内存的方法： 当前字符的 ascii码 - 'a' 的ascii码
            int index = c - 'a';

            if (p.getChildren()[index] == null){
                TrieNode node = new TrieNode(c);
                p.getChildren()[index] = node;

            }
            p = p.getChildren()[index];
        }
        p.setEndingChar(true);
    }

    public boolean contains(String pattern){
        char[] arr = pattern.toCharArray();
        TrieNode p = root;
        for (char c:arr){
            int index = c - 'a';
            if (p.getChildren()[index]==null){
                return false;
            }
            p = p.getChildren()[index];
        }
        return p.isEndingChar();
    }

}