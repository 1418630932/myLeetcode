package dataStructures.myLink;

/**
 * @author zhuliyang
 * @date 2019-12-04
 * @time 22:46
 **/

class test{
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(3));
        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(new Node(1));
        list2.add(new Node(2));
        list2.add(new Node(3));
        list2.add(new Node(4));
        list2.add(new Node(5));
        Node cur = list.getHead().next; //头元素
        while (true){
            //当队列最后一个元素的时候 跳出循环
            if (cur==null){
                break;
            }
            Node temp =cur.next; //下一个元素
            Node cur2 = list2.getHead();
            while (cur.value>=cur2.next.value){
                cur2=cur2.next;
            }
            Node temp2 =cur2.next; //下一个元素
            cur2.next=cur; //变更指针关系
            cur.next=temp2;//变更指针关系
            cur=temp;
        }
        System.out.println();


//        reversePrint(list.getHead());//反向打印
//        reverse(list);//反转list
//        System.out.println();
    }
    //反转list
    private static void  reverse(SingleLinkedList list){
        Node newNode = new Node();
        Node cur =list.getHead().next;//第一个元素
        while (cur!=null){
            Node next = cur.next;// 指向了下一个节点 保存了原链表关系
            cur.next=newNode.next; //断开原指针 改为新指向 ，其实就是从中间插入
            newNode.next=cur;//新链表头结点的next等于当前的节点  断开原来的关系
            cur=next;//让cur后移 继续遍历
        }
        //改变原链表头结点的指向
        list.getHead().next = newNode.next;
    }
    //反转打印
    private static void reversePrint(Node node){
        if (node.next==null){
            return;
        }
        reversePrint(node.next);
        System.out.println(node.next.value);
    }
}
public class SingleLinkedList {
    //头结点
    private Node head = new Node();
    public  void add(Node node){
        Node temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
//链表节点
class Node{
    int value;
    Node next;

    public Node() {}

    public Node(int value) {
        this.value = value;
    }
}


