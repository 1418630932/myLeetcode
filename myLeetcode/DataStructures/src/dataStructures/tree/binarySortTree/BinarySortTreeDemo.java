package dataStructures.tree.binarySortTree;

/**
 * @author zhuliyang
 * @date 2020-01-08
 * @time 23:22
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,2,9};
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
//        bst.infixOrder();
        bst.deleteNode(3  );
        bst.infixOrder();
    }
}
class BinarySortTree{
    private Node root;
    public void add(Node node){
        if (root==null){
            root=node;
        }else {
            root.addNode(node);
        }

    }
    public void infixOrder(){
        root.infixOrder();
    }

    public Node search(int value){
        return root.search(value);
    }

    public Node searchParent(int value){
        return root.searchParent(value);
    }

    //删除右子树的最小节点并且返回最小节点的值
    public int delRightTreeMin(Node node){
        while (node.left!=null){
            node=node.left;
        }
        int val  = node.value;
       deleteNode(val);
        return val;
    }

    public void deleteNode(int value){
        if (root==null){
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode==null){
                return;//如果没有找到节点
            }
            if (root.left==null&&root.right==null){
                root=null;//树只有root一个节点
                return;
            }
            Node parent = searchParent(value);
            //如果要删除的是叶子节点
            if (targetNode.left==null&&targetNode.right==null){
                if (parent.left!=null&&parent.left.value==targetNode.value){
                    parent.left=null;//父节点的左子节点是要删除的节点
                }
                if (parent.right!=null&&parent.right.value==targetNode.value){
                    parent.right=null;//父节点的右子节点是要删除的节点
                }
            }else if (targetNode.left!=null&&targetNode.right!=null){//要删除的节点有两个子节点
                int min = delRightTreeMin(targetNode.right);//删除target的右子树的最小的节点
                targetNode.value=min;//target的值覆盖
            }else {//要删除的节点 只有一个子节点
                if (targetNode.left!=null){//只有左子节点
                    if (parent.left.value==value){//如果targetNode是左子节点
                        parent.left=targetNode.left;
                    }else {//如果targetNode是右子节点
                        parent.right=targetNode.left;
                    }
                }else {//targetNode右子节点不为空
                    if (parent.left.value==value){//如果targetNode是左子节点
                        parent.left=targetNode.right;
                    }else {
                        parent.right=targetNode.right;
                    }
                }
            }
        }

    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    //查找对应的节点
    public Node search(int value){
        if (value==this.value){
            return this;
        }
        if (value<this.value){
            if (this.left==null){
                return null;
            }else {
                return this.left.search(value);
            }
        }else {
            if (this.right==null){
                return null;
            }else {
                return this.right.search(value);
            }
        }
    }

    //查找对应节点的父节点
    public Node searchParent(int value){
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }
        if (this.left!=null&&value<this.value){
            return this.left.searchParent(value);//左递归查找父节点
        }
        if (this.right!=null&&value>this.value){
            return this.right.searchParent(value);//右递归查找父节点
        }
        return null;//没找到 返回null
    }
    public void addNode(Node node){
        if (node==null){
            return;
        }
        if (node.value<this.value){
            if (this.left==null){
                this.left=node;
            }else {
                this.left.addNode(node);//递归添加
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                this.right.addNode(node);//递归添加
            }
        }
    }
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
}
