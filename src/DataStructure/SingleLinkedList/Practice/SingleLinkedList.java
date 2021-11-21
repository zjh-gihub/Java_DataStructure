package DataStructure.SingleLinkedList.Practice;


import java.util.Scanner;

public class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HerNode head = new HerNode(0, "", "");

    //返回头结点
    public HerNode getHead() {
        return head;
    }


    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HerNode headnode) {
        HerNode temp = head;

        //遍历直至到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = headnode;

    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HerNode headnode) {
        HerNode temp = head;
        boolean flag = false;// flag标志添加的编号是否存在，默认为false

        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no > headnode.no) {
                break;
            } else if (temp.next.no == headnode.no) {
                //说明编号存在
                flag = true;
                break;
            }

            temp = temp.next;
        }

        //判断flag 的值
        if (flag) {
            System.out.printf("链表中已经含有 %d 号元素，不可重复添加！\n", headnode.no);
        } else {
            headnode.next = temp.next;
            temp.next = headnode;
        }

    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void change() {
        HerNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改元素的编号：");
        int num = sc.nextInt();
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            sc.nextLine();
            System.out.println("请输入要修改元素的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入要修改元素的绰号：");
            String niname = sc.nextLine();
            temp.name = name;
            temp.nickname = niname;
        } else {
            //没有找到
            System.out.printf("没有找到编号为 %d 的元素，不能修改！\n", num);
        }

    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void dellist() {
        HerNode temp = head;
        boolean flag = false; //表示是否找到该节点
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除元素的编号：");
        int num = sc.nextInt();
        while (true) {
            if (temp.next == null) {
                break;//已经遍历完链表
            }
            if (temp.next.no == num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;


        } else {
            //没有找到
            System.out.printf("没有找到编号为 %d 的元素，不能修改！\n", num);
        }

    }


    //显示链表
    public void showlist() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
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


}
