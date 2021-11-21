package DataStructure.Queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
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

class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear; //队列尾
    private int [] arr;//该数组用于存放数据，模拟队列

    //创建列构造器
    public ArrayQueue(int arrMaxsize){
        maxSize = arrMaxsize;
        front = -1;
        rear = -1;
        arr = new int[arrMaxsize];
    }

    //判断对列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满");
        }else{
            rear++;
            arr[rear]=n;
        }
    }

    //获取队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("对列为空");
        }else {
            front++;
            return arr[front];
        }
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("对列为空");
            return;
        }

        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，注意不是去除数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("对列为空");
        }else{
            return arr[front+1];
        }

    }
}
