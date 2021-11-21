package DataStructure.Tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
    }
}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历
class ArrayBinaryTree{

    private int[] arr;//存储数据结点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index){
        //如果数组为空
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
            return;
        }
        //输出当前这个元素
        //前序遍历
//        System.out.printf(arr[index]+" ");
        //向左遍历
        if(index*2+1<arr.length){
            preOrder(index*2+1);
        }
//        //中序遍历
//        System.out.printf(arr[index]+" ");
        //向右遍历
        if(index*2+2<arr.length){
            preOrder(index*2+2);
        }

        //后序遍历
        System.out.printf(arr[index]+" ");
    }


}
