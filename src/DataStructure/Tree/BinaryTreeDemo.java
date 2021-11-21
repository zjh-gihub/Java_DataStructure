package DataStructure.Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree btree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
//        HeroNode node6 = new HeroNode(6, "关胜");
//        HeroNode node7 = new HeroNode(7, "关胜");
        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        btree.setRoot(root);
//        node3.setLeft(node6);
//        node3.setRight(node7);

//        btree.setRoot(root);

        //前序遍历
        System.out.println("前序遍历：");
        btree.preOrder();//1 2 3 4// 1 2 3 5 4

        //中序遍历
        System.out.println("中序遍历：");
        btree.infixOrder();//2 1 3 4//2 1 5 3 4

        //后序遍历
        System.out.println("后序遍历：");
        btree.postOrder();//2 4 3 1//2 5 4 3 1

        //前序遍历查找
//        System.out.println("前序遍历方式~~~");
//        int no =5;
//		HeroNode resNode = btree.preordersearch(no);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", no);
//		}

        //测试一把删除结点
//
//        System.out.println("删除前,前序遍历");
//        btree.preOrder(); //  1,2,3,5,4
//        btree.delNode2(3);
//        //binaryTree.delNode(3);
//        System.out.println("删除后，前序遍历");
//        btree.preOrder(); // 1,2,3,4


    }



}

//定义BinaryTree 二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.Prelist();
        }else {
            System.out.println("二叉树为空！");
        }
    }
    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.inprilist();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preordersearch(int no){
        if(root != null) {
            return root.preOrdersearch(no);
        } else {
            return null;
        }
    }

    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrdersearch(no);
        }else {
            return null;
        }
    }

    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrdersearch(no);
        }else {
            return null;
        }
    }

    //删除结点
    public void delNode(int no){
        if(root!=null){
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if(root.getNo()==no){
                root=null;
            }else {
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除~");
        }
    }

    public void delNode2(int no){
        if(root!=null){
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if(root.getNo()==no){
                root=null;
            }else {
                //递归删除
                root.delNode2(no);
            }
        }else{
            System.out.println("空树，不能删除~");
        }
    }
}

//节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //构造器
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //方法
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void Prelist(){
        System.out.println(this);
        //向左遍历
        if(this.left!=null){
            this.left.Prelist();
        }
        //向右遍历
        if(this.right!=null){
            this.right.Prelist();
        }
    }

    //中序遍历
    public void inprilist(){
        //向左遍历
        if(this.left!=null){
            this.left.inprilist();
        }
        System.out.println(this);
        //向右遍历
        if(this.right!=null){
            this.right.inprilist();
        }
    }

    //后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     *
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    //前序遍历查找
    public HeroNode preOrdersearch(int no){
        //比较当前结点是不是
        if(this.no==no){
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        HeroNode res = null;
        if(this.left!=null){
            res = this.left.preOrdersearch(no);
        }
        if(res!=null){//说明我们左子树找到
            return res;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if(this.right!=null){
            res=this.right.preOrdersearch(no);
        }
        return res;
    }


    //中序遍历查找
    public HeroNode infixOrdersearch(int no){
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode res = null;
        if(this.left!=null){
            res = this.left.infixOrdersearch(no);
        }
        if(res!=null){
            return res;
        }
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if(this.no==no){
            return this;
        }
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if(this.right!=null){
            res = this.right.infixOrdersearch(no);
        }
        return res;
    }

    //后序遍历查找
    public HeroNode postOrdersearch(int no){
        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode res=null;
        if(this.left!=null){
            res = this.left.postOrdersearch(no);
        }
        if(res!=null){//说明在左子树找到
            return res;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right!=null){
            res= this.right.postOrdersearch(no);
        }
        if(res!=null){
            return res;
        }
        //如果左右子树都没有找到，就比较当前结点是不是
        if(this.no==no){
            return this;
        }
        return res;
    }

    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        //思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */
        //2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if(this.left!=null&&this.left.no==no){
            this.left=null;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if(this.right!=null&&this.right.no==no){
            this.right=null;
        }
        //4.我们就需要向左子树进行递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if(this.right!=null){
            this.right.delNode(no);
        }

    }

    public void delNode2(int no){
        //2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if(this.left!=null&&this.left.no==no&&this.left.left==null&&this.left.right==null){
            this.left=null;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if(this.right!=null&&this.right.no==no&&this.right.left==null&&this.right.right==null){
            this.right=null;
        }

        if(this.left!=null&&this.left.no==no&&this.left.left!=null&&this.left.right==null){
            this.left=this.left.left;
        }
        if(this.left!=null&&this.left.no==no&&this.left.left==null&&this.left.right!=null){
            this.left=this.left.right;
        }
        if(this.left!=null&&this.left.no==no&&this.left.left!=null&&this.left.right!=null){
            this.left.left.right=this.left.right;
            this.left=this.left.left;
        }

        if(this.right!=null&&this.right.no==no&&this.right.left!=null&&this.right.right==null){
            this.right=this.right.right;
        }
        if(this.right!=null&&this.right.no==no&&this.right.left==null&&this.right.right!=null){
            this.right=this.right.right;
        }
        if(this.right!=null&&this.right.no==no&&this.right.left!=null&&this.right.right!=null){
            this.right.left.right=this.right.right;
            this.right=this.right.left;
        }


        //4.我们就需要向左子树进行递归删除
        if(this.left!=null){
            this.left.delNode2(no);
        }
        //5.则应当向右子树进行递归删除
        if(this.right!=null){
            this.right.delNode2(no);
        }

    }
}



