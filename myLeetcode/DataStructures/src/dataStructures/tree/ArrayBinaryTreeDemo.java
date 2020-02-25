package dataStructures.tree;

/**
 * @author zhuliyang
 * @date 2019-12-29
 * @time 20:54
 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }
}
class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //前序遍历
    public void preOrder(){
        preOrder(0);
    }
    private void preOrder(int index){
        if (arr==null||arr.length==0){
            return;
        }
        System.out.println(arr[index]);
        if ((2*index+1)<arr.length){
            preOrder(2*index+1);
        }
        if ((2*index+2)<arr.length){
            preOrder(2*index+2);
        }
    }
}
