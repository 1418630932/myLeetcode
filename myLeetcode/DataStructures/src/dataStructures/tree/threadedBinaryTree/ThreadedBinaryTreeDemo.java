package dataStructures.tree.threadedBinaryTree;

/**线索化二叉树
 * @author zhuliyang
 * @date 2019-12-29
 * @time 21:45
 **/
public class ThreadedBinaryTreeDemo {
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
//        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        tree.threadedNodes();
        System.out.println(node6.left.value);
        System.out.println(node6.right.value);
        System.out.println("======================");
        tree.printThreadedNodes();
    }
}

//线索化二叉树
class Tree {
    Node root;
    Node pre;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }
    public void printThreadedNodes(){
        Node node =root ;
        while (node!=null){
            while (node.leftType!=1){//先找到当前node的最左子节点
                node=node.left;
            }
            while (node.rightType!=0){//按照右指针遍历打印叶子节点  必须要用while 不能if 为了转移非叶子节点
                System.out.print(node.value);
                node=node.right;
            }
            //走出while说明是非叶子节点
            System.out.print(node.value);
            node=node.right;

        }
        System.out.println();
    }
    public void threadedNodes(){
        threadedNodes(root);
    }
    //中序线索化的方法
    private void threadedNodes(Node node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.left);
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre!=null&&pre.right == null) {//设置上节点的right指向后驱节点
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;//下次递归使用
        threadedNodes(node.right);
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    public Integer preSearch(int val) {
        Integer integer = null;
        if (root != null) {
            integer = root.preSearch(val);
        }
        return integer;
    }

    public Integer infixSearch(int val) {
        Integer integer = null;
        if (root != null) {
            integer = root.infixSearch(val);
        }
        return integer;
    }

    public Integer postSearch(int val) {
        Integer integer = null;
        if (root != null) {
            integer = root.postSearch(val);
        }
        return integer;
    }

    public void delNode(int val) {
        if (root != null && root.value == val) {
            root = null;
            return;
        }
        root.delNode(val);
    }
}

//链表节点
class Node {
    int value;
    Node left;
    Node right;
    int leftType;//0 :指向左子树 ，1：前驱节点
    int rightType;//0：右子树 ，1：后驱节点

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
    public void preOrder() {
        System.out.print(value + " ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(value + " ");
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.print(value + " ");
    }

    //前序查找
    public Integer preSearch(int value) {
        if (this.value == value) {
            return this.value;
        }
        Integer result = null;
        if (this.left != null) {
            result = this.left.preSearch(value);
            if (result != null) {
                return result;
            }
        }
        if (this.right != null) {
            result = this.right.preSearch(value);
        }
        return result;
    }

    //中序查找
    public Integer infixSearch(int value) {
        Integer result = null;
        if (this.left != null) {
            result = this.left.infixSearch(value);
            if (result != null) {
                return result;
            }
        }
        if (this.value == value) {
            return this.value;
        }

        if (this.right != null) {
            result = this.right.infixSearch(value);
        }
        return result;
    }

    //后序查找
    public Integer postSearch(int value) {
        Integer result = null;
        if (this.left != null) {
            result = this.left.postSearch(value);
            if (result != null) {
                return result;
            }
        }
        if (this.right != null) {
            result = this.right.postSearch(value);
            if (result != null) {
                return result;
            }
        }
        if (this.value == value) {
            return this.value;
        }
        return result;
    }

    //删除节点
    public void delNode(int value) {
        if (this.left != null && this.left.value == value) {
            this.left = null;
        }
        if (this.right != null && this.right.value == value) {
            this.right = null;
        }
        if (this.left != null) {
            this.left.delNode(value);
        }
        if (this.right != null) {
            this.right.delNode(value);
        }
    }
}