package DataStructure.Queue;

import java.util.Scanner;

public class CycleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        CycleArrayQueue queue = new CycleArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            key = sc.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'h':
                    try{
                        int head = queue.headQueue();
                        System.out.printf("头数据是%d\n",head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
                    sc.close();
                    loop=false;
                    break;
                default:
                    break;

            }

        }

    }
}

class CycleArrayQueue{
    private int maxSize;//表示数组的最大容量

    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;//队列头

    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear; //队列尾
    private int [] arr;//该数组用于存放数据，模拟队列

    //创建列构造器
    public CycleArrayQueue(int arrMaxsize){
        maxSize = arrMaxsize;
        arr = new int[arrMaxsize];
        front = 0;
        rear = 0;

    }
    //判断对列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满");
        }else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }
    //获取队列元素
    public int getQueue(){
        if(isEmpty()) {
            throw new RuntimeException("对列为空");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        else{
            int value = arr[front];
            front=(front+1)%maxSize;
            return value;
        }
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("对列为空");
            return;
        }
        else{
            // 思路：从front开始遍历，遍历多少个元素
            // 动脑筋
            for(int i=front;i<front+size();i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }

        }
    }

    // 求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，注意不是去除数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("对列为空");
        }else{
            return arr[front];
        }

    }
}