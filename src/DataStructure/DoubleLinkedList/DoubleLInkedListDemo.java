package DataStructure.DoubleLinkedList;









import java.util.Scanner;

public class DoubleLInkedListDemo {
    public static void main(String[] args) {
        HerNode2 her1 = new HerNode2(1, "A", "a");
        HerNode2 her2 = new HerNode2(2, "B", "b");
        HerNode2 her3 = new HerNode2(3, "C", "c");
        HerNode2 her4 = new HerNode2(4, "D", "d");
        HerNode2 her6 = new HerNode2(6, "F", "f");

        //创建链表
        DoubleLinkedList dl = new DoubleLinkedList();

        //添加至链表
        dl.addByOrder(her1);
        dl.addByOrder(her2);
//        dl.addByOrder(her2);
        dl.addByOrder(her4);
        dl.addByOrder(her6);
        dl.addByOrder(her3);


        
        //显示链表
        System.out.println("改变前：");
        dl.showlist();

        //修改链表元素
        //dl.change();

        //删除链表元素
        //dl.dellist();


        System.out.println("改变后：");
        dl.showlist();
        

    }
}



class DoubleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HerNode2 head = new HerNode2(0, "", "");

    //返回头结点
    public HerNode2 getHead() {
        return head;
    }

    //显示链表
    public void showlist() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HerNode2 temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HerNode2 headnode) {
        HerNode2 temp = head;

        //遍历直至到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = headnode;
        headnode.pre=temp;

    }


    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HerNode2 headnode) {
        HerNode2 temp = head;
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
            headnode.pre=temp;
            if(temp.next!=null){
                temp.next.pre=headnode;
            }
            temp.next=headnode;
        }

    }


    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 HeroNode2
    public void change() {
        HerNode2 temp = head.next;
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


    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void dellist() {
        if(head.next==null){
            System.out.println("链表为空，无法操作！");
        }
        HerNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除元素的编号：");
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
            temp.pre.next=temp.next;

            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            //temp.next.pre=temp.pre;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }


        } else {
            //没有找到
            System.out.printf("没有找到编号为 %d 的元素，不能修改！\n", num);
        }

    }



}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HerNode2 {
    public int no;
    public String name;
    public String nickname;
    public HerNode2 next;//指向下一个节点
    public HerNode2 pre;//指向前一个节点
    //构造器
    public HerNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //重写tostring方法
    @Override
    public String toString() {
        return "HerNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}



