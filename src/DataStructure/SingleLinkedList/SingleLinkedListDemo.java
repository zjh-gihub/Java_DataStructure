package DataStructure.SingleLinkedList;

import java.util.Scanner;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HerNode her1 = new HerNode(1, "A", "a");
        HerNode her2 = new HerNode(2, "B", "b");
        HerNode her3 = new HerNode(3, "C", "c");
        HerNode her4 = new HerNode(4, "D", "d");
        HerNode her6 = new HerNode(6, "F", "f");

        //创建链表
        SingleLinkedList sl = new SingleLinkedList();

//        //添加至链表
//        sl.add(her1);
//        sl.add(her2);
//        sl.add(her3);
//        sl.add(her4);

        //添加至链表
        sl.addByOrder(her1);
        sl.addByOrder(her4);
        sl.addByOrder(her6);
        sl.addByOrder(her2);
//        sl.addByOrder(her3);
//        sl.addByOrder(her3);


        //

////        sl.change();
//        sl.dellist();
//        System.out.println("修改后：");
//        sl.showlist();

        /**1.新浪：获取到单链表的节点的个数
        int len = getLength(sl.getHead());
        System.out.printf("单链表有效长度为：%d\n",len);
        */

        /**
         *2.查找单链表中的倒数第k个结点 【新浪面试题】
        int index =2;
        System.out.printf("倒数第%d个元素为：\n",index);
        System.out.println(cur);
         */

/**
//        *3.将单链表反转 【腾讯面试题】**
        System.out.println("反转前：");
        sl.showlist();
        reverseHerNode(sl.getHead());
        System.out.println("反转后：");
        sl.showlist();
*/

/**
        4.从尾到头打印单链表【百度】(方式1：反向遍历  方式2：Stack栈)
        System.out.println("正序打印：");
        sl.showlist();
        System.out.println("逆序打印：");
        reversePrint(sl.getHead());
*/


    }


    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    /**
     *1.新浪：获取到单链表的节点的个数
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength (HerNode head){
        int nums = 0;
        if (head.next == null) {
            //空链表
            return 0;
        }
        HerNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            nums++;
            temp = temp.next;
        }
        return nums;
    }




    /**
     *2.查找单链表中的倒数第k个结点 【新浪面试题】
     */
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回nulll
    public static HerNode getHerNode (HerNode head,int index  ){
        if (head.next == null) {
            //空链表
            return null;
        }
        int size = getLength(head);
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        HerNode cur = head.next; //3 // 3 - 1 = 2
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     *3.将单链表反转 【腾讯面试题】**
     */
    public static void reverseHerNode(HerNode head){
        if(head.next==null||head.next.next==null){
            return;
        }
        HerNode newhead = new HerNode(0, "", "");
        HerNode cur = head.next;
        HerNode curnext = null;// 指向当前节点[cur]的下一个节点

        while(cur!=null){

            curnext=cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next=newhead.next;//将cur.next指向新的链表head.next
            newhead.next=cur;////将newhead.next指向cur
            cur = curnext;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = newhead.next;

    }

/**4.从尾到头打印单链表【百度】(方式1：反向遍历  方式2：Stack栈)
 * 方式2：
    可以利用栈这个数据结构，将各个节点压入到栈中，
    然后利用栈的先进后出的特点，就实现了逆序打印的效果*/
    public static void reversePrint(HerNode head){
        if(head.next==null){
            return;
        }
        Stack<HerNode> hs = new Stack<>();
        HerNode cur = head.next;
        while(cur!=null){
            hs.push(cur);
            cur = cur.next;//cur后移，这样就可以压入下一个节点
        }
        while(hs.size()>0){
            System.out.println(hs.pop());//stack的特点是先进后出
        }


    }

}




//定义SingleLinkedList管理我们的英雄
class SingleLinkedList {
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



//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HerNode {
    public int no;
    public String name;
    public String nickname;
    public HerNode next;//指向下一个节点

    //构造器
    public HerNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //重写tostring方法
    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
