package DataStructure.Tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedHeroNode root = new ThreadedHeroNode(1, "a");
        ThreadedHeroNode node2 = new ThreadedHeroNode(3, "b");
        ThreadedHeroNode node3 = new ThreadedHeroNode(6, "c");
        ThreadedHeroNode node4 = new ThreadedHeroNode(8, "d");
        ThreadedHeroNode node5 = new ThreadedHeroNode(10, "e");
        ThreadedHeroNode node6 = new ThreadedHeroNode(14, "f");

        //二叉树手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        TreadedBinaryTree threadedBinaryTree = new TreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();
        
        //测试: 以10号节点测试
        ThreadedHeroNode leftNode = node2.getLeft();
        ThreadedHeroNode rightNode = node2.getRight();
        System.out.println("3号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("3号结点的后继结点是="  + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadList(); // 8, 3, 10, 1, 14, 6
    }

}


//定义BinaryTree 二叉树
class TreadedBinaryTree{
    private ThreadedHeroNode root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private ThreadedHeroNode pre = null;

    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }

    //重载一把threadedNodes方法
    public void threadedNode() {
        this.threadedNode(root);
    }

    //编写对二叉树进行中序线索化的方法
    /**
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNode(ThreadedHeroNode node){
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }

        //(一)先线索化左子树
        threadedNode(node.getLeft());
        //(二)线索化当前结点[有难度]
        //处理前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //(三)在线索化右子树
        threadedNode(node.getRight());
    }

    //遍历线索化二叉树的方法
    public void threadList(){
        //定义一个变量，存储当前遍历的结点，从root开始
        ThreadedHeroNode node = root;
        while (node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();

        }


    }


}

//节点
class ThreadedHeroNode {
    private int no;
    private String name;
    private ThreadedHeroNode left;
    private ThreadedHeroNode right;
    //说明
    //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
    private int leftType;
    private int rightType;


    //构造器
    public ThreadedHeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //方法
    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadedHeroNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedHeroNode left) {
        this.left = left;
    }

    public ThreadedHeroNode getRight() {
        return right;
    }

    public void setRight(ThreadedHeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreadedHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

