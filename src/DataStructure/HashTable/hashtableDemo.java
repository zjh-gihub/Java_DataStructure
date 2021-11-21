package DataStructure.HashTable;

import java.util.Scanner;

public class hashtableDemo {
    public static void main(String[] args) {
        //创建哈希表
        hashtab hst = new hashtab(7);

        //写一个简单的菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("add:  添加雇员");
            System.out.println("show: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = sc.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入姓名");
                    String name = sc.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    //添加雇员
                    hst.add(emp);
                    break;
                case "show":
                    hst.showemp();
                    break;
                case "find":
                    System.out.println("请输入要查找雇员的id：");
                    int idnum = sc.nextInt();
                    hst.findEmpbyid(idnum);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }

}

//创建HashTab 管理多条链表
class hashtab{
    private EmpLinkedList [] ellArray;
    private int size;

    //构造器
    public hashtab(int size){
        this.size=size;
        //初始化ellArray
        ellArray = new EmpLinkedList[size];
        /**
         * 注意，这时要分别初始化每个链表
         * */
        for(int i=0;i<size;i++){
            ellArray[i]=new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empnums = hashfind(emp.id);
        //将emp 添加到对应的链表中
        ellArray[empnums].add(emp);

    }

    //遍历显示雇员
    public void showemp(){
        for(int i = 0; i < size; i++) {
            ellArray[i].showlist(i);
        }

    }

    //按id查找雇员
    public void findEmpbyid(int id){
        //查找ID对应的哈希表序列
        int emnums= hashfind(id);
        Emp emp = ellArray[emnums].findEmp(id);
        if(emp!=null){
            //找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d,name= %s \n", (emnums + 1), id,emp.name);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }

    }

    //编写散列函数
    public int hashfind(int id){
        return id % size;
    }
}



//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;//默认指向null
    //构造方法

    public Emp(int id, String name){
//        super();
        this.id = id;
        this.name = name;

    }

}

//创建EmpLinkedList ,表示链表
class EmpLinkedList{
    //头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
    private Emp head; //默认null

    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        //遍历到链表最后
        while(true){
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }

    //遍历链表的雇员信息
    public void showlist(int no){
        if(head==null){
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.printf("第"+(no+1)+"条链表信息为：");
        Emp curEmp = head;
        while(true){
            System.out.printf(" --> id=%d name=%s -->\t", curEmp.id, curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }

    //查找雇员
    public Emp findEmp(int id){
        if (head==null){
            System.out.println("链表为空");
            return null;
        }
        //创建临时指针
        Emp tempEmp = head;
        while(true){
            if(tempEmp.id==id){
                break;
            }
            tempEmp=tempEmp.next;

            //找到最后还是没找到
            if(tempEmp.next==null){
                tempEmp=null;
            }
        }
        return tempEmp;

    }
}
