package dataStructures.tree.huffmanTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author zhuliyang
 * @date 2020-01-01
 * @time 22:45
 **/
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node huffman = getHuffman(arr);
        huffman.preOrder();
    }
    public static Node getHuffman(int[] arr){
        LinkedList<Node> linkedList = new LinkedList();
        Arrays.sort(arr);
        for (int i : arr) {
            linkedList.add(new Node(i));
        }
        while (linkedList.size()>1){
            Collections.sort(linkedList);
            Node left = linkedList.get(0);
            Node right = linkedList.get(1);
            Node root = new Node(left.value+right.value);
            root.setLeft(left);
            root.setRight(right);
            linkedList.remove(1);
            linkedList.remove(0);
            linkedList.add(root);
        }
        return linkedList.get(0);
    }
}
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //从小到大比较
    @Override
    public int compareTo(Node node) {
        return this.value-node.value;
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