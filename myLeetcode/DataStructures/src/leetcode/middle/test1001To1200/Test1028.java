package leetcode.middle.test1001To1200;

import leetcode.utils.TreeNode;
import org.omg.CORBA.TRANSACTION_MODE;

import java.nio.IntBuffer;

/**
 * @author zhuliyang
 * @date 2020-06-18
 * @time 0:19
 **/
public class Test1028 {
    public TreeNode recoverFromPreorder(String s) {
        return buildTree(s, "-");
    }

    public TreeNode buildTree(String s, String prefix) {
        if (s == null || s.length() == 0) return null;
        s = s.substring(prefix.length());
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, 1)));
        String remain = s.substring(1);

        int start = 0;
        int start2 = remain.length();
        for(int i = prefix.length();i<remain.length();i++){
            if (i>0 && i+prefix.length()<remain.length()
                    &&remain.substring(i, i+prefix.length()).equals(prefix)){
                    start2 = i;
            }
        }
        String strLeft = s.substring(start,start2);
        String strRight = s.substring(start2);
        root.left = buildTree(strLeft, prefix + "-");
        root.right = buildTree(strRight, prefix + "-");
        return root;
    }
    public boolean isNumber(char c){
        return c>='0'&&c<='9';
    }

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(5);
        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
        buffer.flip();
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.get());
    }
}
