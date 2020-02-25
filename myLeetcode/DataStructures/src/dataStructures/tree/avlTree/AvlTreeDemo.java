package dataStructures.tree.avlTree;

/**
 * avl树
 *
 * @author zhuliyang
 * @date 2020-01-09
 * @time 23:48
 **/
public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4,3,6,1,5,7,8};
        AvlTree avlTree = new AvlTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        avlTree.deleteNode(1);
        avlTree.infixOrder();
        System.out.println("左子树高" + avlTree.getRoot().leftHeight());
        System.out.println("右子树高" + avlTree.getRoot().rightHeight());
    }
}

class AvlTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }

    }

    public void infixOrder() {
        root.infixOrder();
    }

    public Node search(int value) {
        return root.search(value);
    }

    public Node searchParent(int value) {
        return root.searchParent(value);
    }

    //删除右子树的最小节点并且返回最小节点的值
    public int delRightTreeMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        int val = node.value;
        deleteNode(val);
        return val;
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;//如果没有找到节点
            }
            if (root.left == null && root.right == null) {
                root = null;//树只有root一个节点
                return;
            }
            Node parent = searchParent(value);
            //如果要删除的是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == targetNode.value) {
                    parent.left = null;//父节点的左子节点是要删除的节点
                }
                if (parent.right != null && parent.right.value == targetNode.value) {
                    parent.right = null;//父节点的右子节点是要删除的节点
                }
            } else if (targetNode.left != null && targetNode.right != null) {//要删除的节点有两个子节点
                int min = delRightTreeMin(targetNode.right);//删除target的右子树的最小的节点
                targetNode.value = min;//target的值覆盖
            } else {//要删除的节点 只有一个子节点
                if (targetNode.left != null) {//只有左子节点
                    if (parent.left.value == value) {//如果targetNode是左子节点
                        parent.left = targetNode.left;
                    } else {//如果targetNode是右子节点
                        parent.right = targetNode.left;
                    }
                } else {//targetNode右子节点不为空
                    if (parent.left.value == value) {//如果targetNode是左子节点
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
        //当右子树高度比左子树高度大1的时候 左旋转
        if (root.rightHeight() - root.leftHeight() > 1) {
            //如果当前节点的右子树的右子树高度比其左子树高度小的时候,先对他的右子树进行右旋转
            if (root.right!=null&&root.right.rightHeight() < root.right.leftHeight()) {
                root.right.rightRotate();
            }
            root.leftRotate();
        }
        //当左子树高度比右子树高度大1的时候 右旋转
        if (root.leftHeight() - root.rightHeight() > 1) {
            //如果当前节点的左子树的左子树高度比其右子树高度小的时候,先对他的左子树进行左旋转
            if (root.left!=null&&root.left.leftHeight() < root.left.rightHeight()) {
                root.left.leftRotate();
            }
            root.rightRotate();//右旋转
        }

    }

    public Node getRoot() {
        return root;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回当前节点做root的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left != null) {
            return left.height();
        } else {
            return 0;
        }
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right != null) {
            return right.height();
        } else {
            return 0;
        }
    }

    //左旋转的方法
    public void leftRotate() {
        Node newNode = new Node(value);//创建一个新节点
        newNode.left = left;//新节点的左子树等于当前节点的左子树
        newNode.right = right.left;//新节点的右子树等于当前节点右子树的左子树
        value = right.value;//当前节点的值等于右子树的值
        right = right.right;//当前节点的右子树指向原右子树的右子树
        left = newNode;//当前节点的左子树指向新节点

    }

    //右旋转的方法
    public void rightRotate() {
        Node newNode = new Node(value);//创建一个新节点
        newNode.right = right;//新节点的右子树等于当前节点的右子树
        newNode.left = left.right;//新节点的左子树等于当前节点左子树的右子树
        value = left.value;//当前节点的值等于左子树的值
        left = left.left;//当前节点的左子树指向原左子树的左子树
        right = newNode;//当前节点的右子树指向新节点

    }

    //查找对应的节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value < this.value) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(value);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(value);
            }
        }
    }

    //查找对应节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        if (this.left != null && value < this.value) {
            return this.left.searchParent(value);//左递归查找父节点
        }
        if (this.right != null && value > this.value) {
            return this.right.searchParent(value);//右递归查找父节点
        }
        return null;//没找到 返回null
    }

    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);//递归添加
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);//递归添加
            }
        }
        //当右子树高度比左子树高度大1的时候 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果当前节点的右子树的右子树高度比其左子树高度小的时候,先对他的右子树进行右旋转
            if (right!=null&&right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
            }
            leftRotate();
        }
        //当左子树高度比右子树高度大1的时候 右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果当前节点的左子树的左子树高度比其右子树高度小的时候,先对他的左子树进行左旋转
            if (left!=null&&left.leftHeight() < left.rightHeight()) {
                left.leftRotate();
            }
            rightRotate();//右旋转
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}