package dataStructures.tree;

/**
 * @author zhuliyang
 * @date 2019-12-28
 * @time 0:22
 **/
public class MyBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
       Node node1 = new Node(1);
       Node node2 = new Node(2);
       Node node3 = new Node(3);
       Node node4 = new Node(4);
       Node node5 = new Node(5);
       Node node6 = new Node(6);
       Node node7 = new Node(7);
        tree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        tree.preOrder();
        System.out.println("=====================");
        tree.infixOrder();
        System.out.println("=====================");
        tree.postOrder();
        System.out.println("查找结点");
        System.out.println(tree.preSearch(15));
        System.out.println(tree.infixSearch(15));
        System.out.println(tree.postSearch(15));
        System.out.println("删除节点");
        tree.preOrder();
        System.out.println("开始删除");
        tree.delNode(2);
        tree.preOrder();
        System.out.println("删除结束");

    }

}
class Tree{
   Node root;
    public void setRoot(Node root) {
        this.root = root;
    }
    public void preOrder(){
        if (root!=null){
            root.preOrder();
        }
    }

    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }
    }

    public void postOrder(){
        if (root!=null){
            root.postOrder();
        }
    }

    public Integer preSearch(int val){
        Integer integer =null;
        if (root!=null){
             integer = root.preSearch(val);
        }
        return integer;
    }
    public Integer infixSearch(int val){
        Integer integer =null;
        if (root!=null){
            integer = root.infixSearch(val);
        }
        return integer;
    }
    public Integer postSearch(int val){
        Integer integer =null;
        if (root!=null){
            integer = root.postSearch(val);
        }
        return integer;
    }
    public void delNode(int val){
        if (root!=null&&root.value==val){
            root=null;
            return;
        }
        root.delNode(val);
    }
}

//链表节点
class Node{
    int value;
   Node left;
   Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder(){
        System.out.print(value+" ");
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){

        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.print(value+" ");
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.print(value+" ");
    }

    //前序查找
    public Integer preSearch(int value) {
        if (this.value==value){
           return this.value;
        }
        Integer result =null;
        if (this.left!=null){
            result = this.left.preSearch(value);
            if (result!=null){
                return result;
            }
        }
        if (this.right!=null){
            result =this.right.preSearch(value);
        }
        return result;
    }

    //中序查找
    public Integer infixSearch(int value) {
        Integer result =null;
        if (this.left!=null){
            result = this.left.infixSearch(value);
            if (result!=null){
                return result;
            }
        }
        if (this.value==value){
            return this.value;
        }

        if (this.right!=null){
            result =this.right.infixSearch(value);
        }
        return result;
    }
    //后序查找
    public Integer postSearch(int value) {
        Integer result =null;
        if (this.left!=null){
            result = this.left.postSearch(value);
            if (result!=null){
                return result;
            }
        }
        if (this.right!=null){
            result =this.right.postSearch(value);
            if (result!=null){
                return result;
            }
        }
        if (this.value==value){
            return this.value;
        }
        return result;
    }
    //删除节点
    public void delNode(int value){
        if (this.left!=null&&this.left.value==value){
            this.left=null;
        }
        if (this.right!=null&&this.right.value==value){
            this.right=null;
        }
        if (this.left!=null){
            this.left.delNode(value);
        }
        if (this.right!=null){
            this.right.delNode(value);
        }
    }
}
