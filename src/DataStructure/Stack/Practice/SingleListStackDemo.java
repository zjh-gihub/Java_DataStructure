package DataStructure.Stack.Practice;

import java.util.Scanner;

public class SingleListStackDemo {
    public static void main(String[] args) {

        HerNode her1 = new HerNode(1);
        HerNode her2 = new HerNode(2);

        SingleListStack sll = new SingleListStack();

        sll.add(sll,her1);
        sll.add(sll,her2);
//        System.out.println(sll.getSize());
//
//
//
//        System.out.println(sll.isEmpty());
//        System.out.println(sll.isFull(sll));
//
        sll.showlist();
        sll.push();

        sll.showlist();
    }



}


//定义SingleLinkedList管理我们的英雄
class SingleListStack {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    HerNode head = new HerNode(0);
    private int size =0;
    private int maxSize=10;

    //返回头结点
    public HerNode getHead() {
        return head;
    }

    //栈空
    public boolean isEmpty(){
        return head.next==null;
    }

    //栈满
    public boolean isFull(SingleListStack sll){
        return sll.getSize() == maxSize;
    }

    //入栈
    public void add(SingleListStack sll,HerNode headnode) {
        if(isFull(sll)){
//            System.out.println("栈满！");
            throw new RuntimeException("栈满");
        }

        headnode.next=head.next;
        head.next=headnode;
        size++;
    }

    //出栈
    public int push(){
        if(isEmpty()){
            System.out.println("栈空！");
        }

        int value = head.next.no;
        head.next= head.next.next;
        return value;

    }




    //显示链表
    public void showlist() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("栈空");
            return;
        }
        HerNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}



//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HerNode {
    public int no;
    HerNode next;//指向下一个节点

    //构造器
    public HerNode(int no) {
        this.no = no;

    }

    //重写tostring方法
    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                '}';
    }
}
