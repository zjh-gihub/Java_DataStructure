package DataStructure.SingleLinkedList.Practice;



public class HerNode {
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
