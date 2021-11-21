package DataStructure.SingleLinkedList.Practice;



public class SingleLinkedListTest {
    public static void main(String[] args) {

        HerNode her1 = new HerNode(1, "A", "a");
        HerNode her2 = new HerNode(2, "B", "b");
        HerNode her3 = new HerNode(3, "C", "c");
        HerNode her4 = new HerNode(4, "D", "d");
        HerNode her6 = new HerNode(6, "F", "f");

        //创建连个单链表
        SingleLinkedList s1 = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();

        //添加节点至链表
        s1.addByOrder(her1);
        s1.addByOrder(her2);
        s1.addByOrder(her3);

        s2.addByOrder(her6);
        s2.addByOrder(her4);



        //显示链表
        System.out.println("第一个链表显示如下：");
        s1.showlist();
        System.out.println("第二个链表显示如下：");
        s2.showlist();


        System.out.println("合并显示如下：");
        HerNode hs = MergeList(s1.getHead(), s2.getHead());
        HerNode temp = hs.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }


    }

    public static HerNode MergeList(HerNode head1,HerNode head2) {
        //递归结束条件
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //合并后的链表
        HerNode head = null;
        if (head1.no > head2.no) {
            //把head较小的结点给头结点
            head = head2;
            //继续递归head2
            head.next = MergeList(head1, head2.next);
        } else {
            head = head1;
            head.next = MergeList(head1.next, head2);
        }
        return head;

    }



}
