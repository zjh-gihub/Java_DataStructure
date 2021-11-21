package DataStructure.Josepfu;

public class JosepfuDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList cl = new CircleSingleLinkedList();
        cl.addBoy(5);
        cl.showBoys();

        cl.countBoy(1,2,5);
    }


}
//创建一个环形单链表
class CircleSingleLinkedList{
    //创建First boy
    private Boy first = null;


    //添加小孩节点，构建成一个环形链表
    public void addBoy(int num){
        if (num<1){
            System.out.println("输入有误，请重新输入！");
        }
        Boy cur = null;//辅助指针
        for(int i=1;i<=num;i++){
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            if(i==1){
                first =boy;
                first.setNext(first);
                cur = first;
            }
            cur.setNext(boy);
            boy.setNext(first);
            cur=boy;
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序
    /**
     *
     * @param startNo
     *            表示从第几个小孩开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){
        if(startNo<1||startNo>nums||first==null){
            System.out.println("参数有误，请重新输入！");
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次
        for(int i =1;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }

        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while(true){
            if(helper==first){
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("输出的数字为：%d\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最终保留的数字为：%d\n",first.getNo());
    }




    //显示链表
    public void showBoys(){
        if(first==null){
            System.out.println("链表为空！");
        }
        Boy cur = first;

        while(true){
            System.out.println(cur.getNo());
            if(cur.getNext()==first){
                break;
            }
            cur = cur.getNext();
        }
    }
}


//创建一个Boy类，表示一个节点
class Boy{
    private int no;//编号
    private Boy next;//默认指向null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}