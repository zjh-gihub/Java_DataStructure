package DataStructure.Huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class huffmantree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node haednode = creatHuffmanTree(arr);
        preorder(haednode);
    }

    // 创建赫夫曼树的方法
    /**
     *
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public static Node creatHuffmanTree(int [] arr){
        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中
        List<Node> nodeslist = new ArrayList<Node>();
        for (int value : arr) {
            nodeslist.add(new Node(value));
        }
        //我们处理的过程是一个循环的过程
        while(nodeslist.size()>1){
            //排序 从小到大
            Collections.sort(nodeslist);

            //取出根节点权值最小的两颗二叉树
            Node leftnode = nodeslist.get(0);
            Node rightnode = nodeslist.get(1);

            //(3)构建一颗新的二叉树
            Node parent = new Node(leftnode.value+rightnode.value);
            parent.left=leftnode;
            parent.right=rightnode;
            //(4)从ArrayList删除处理过的二叉树
            nodeslist.remove(leftnode);
            nodeslist.remove(rightnode);
            //(5)将parent加入到nodes
            nodeslist.add(parent);
        }
        //返回哈夫曼树的root结点
        return nodeslist.get(0);
    }

    public static void preorder(Node node){
        if(node==null){
            System.out.println("树为空，无法操作！");
        }else{
            node.preOrder();
        }
    }
}

// 创建节点类
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口
class Node implements Comparable<Node>{
    int value;//结点权值
    Node left;// 指向左子结点
    Node right;// 指向右子结点

    //创建前序遍历方法
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        // 表示从小到大排序
        return value-o.value;
    }
}
