package dataStructures.myLink;

/**
 * @author zhuliyang
 * @date 2019-12-08
 * @time 20:30
 **/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleList = new CircleSingleLinkedList();
        circleList.add(125);//创建环形链表
//        circleList.print(); //打印环形链表
        circleList.countBoy(10,20  );
    }
}
//环形链表
class CircleSingleLinkedList{
    private Boy first = new Boy(-1);
    //创建环形链表的方法
    public void add(int nums){
        Boy cur = first;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            cur.next=boy;
            cur=boy;
            //当最后一个元素时 进行成环
            if (i==nums){
                boy.next=first.next;
            }
        }
    }

    /**
     * 丢手帕：计算小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数几下
     */
    public void countBoy(int startNo,int countNum){
        //健壮性判断
        if (first.next==null){
            return;
        }
        Boy cur = first.next;
        Boy helper = cur.next;
        while (true){
            //helper的next指针指向cur
            if (helper.next==cur){
                break;
            }
            helper=helper.next;
        }
        //确定第几个学生开始丢手帕
        for (int i = 1; i < startNo; i++) {
            cur = cur.next;
            helper = helper.next;
        }
        //开始丢手帕
        while (true){
            //当只有最后一个小孩的时候 游戏结束
            if (cur.next==cur){
                break;
            }
            //开始数 丢手帕
            for (int i = 1; i < countNum; i++) {
                cur = cur.next;
                helper = helper.next;
            }
            //淘汰持有手帕的人
            System.out.println(cur.no+"被淘汰了");
            cur = cur.next;
            helper.next = cur;
        }
        System.out.println(cur.no+"存活了下来");
    }
    public void print(){
        if (first==null){
            return;
        }else {
            Boy cur = first.next;
            while (true){
                System.out.println(cur.no);
                if (cur.next==first.next){
                    break;//当到尾部结点之后 跳出循环
                }
                cur = cur.next;
            }
        }
    }
}
//节点
class Boy{
    public int no;//编号
    public Boy next;//next指针
    public Boy(int no) {
        this.no = no;
    }
}
