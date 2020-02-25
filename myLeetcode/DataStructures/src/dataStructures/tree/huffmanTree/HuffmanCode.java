package dataStructures.tree.huffmanTree;

import java.util.*;

/**
 * 哈夫曼编码
 *
 * @author zhuliyang
 * @date 2020-01-04
 * @time 23:11
 **/
public class HuffmanCode {
    static Map<Byte, String> huffmanCodeMap = new HashMap();//哈夫曼编码表

    public static void main(String[] args) {
        String s = "i like like like java do you like a java";
        byte[] bytes = s.getBytes();
        byte[] huffmanZip = huffmanZip(bytes);
        System.out.println(Arrays.toString(huffmanZip));//压缩后的byte数组
        System.out.println(new String(decode(huffmanZip)));//解压后的字符串
    }

    //把字符串的byte数组转换成一颗huffman树
    private static CodeNode getNodes(byte[] bytes) {
        Map<Byte, Integer> map = new HashMap();
        //每个字符出现的次数
        for (byte b : bytes) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }
        List<CodeNode> list = new ArrayList();
        //构建list中的节点
        for (Map.Entry<Byte, Integer> entrySet : map.entrySet()) {
            list.add(new CodeNode(entrySet.getKey(), entrySet.getValue()));
        }
        //进行构建哈夫曼树
        while (list.size() > 1) {
            Collections.sort(list);
            CodeNode node1 = list.get(0);
            CodeNode node2 = list.get(1);
            CodeNode newNode = new CodeNode(null, node1.weight + node2.weight);
            newNode.left = node1;
            newNode.right = node2;
            list.add(newNode);
            list.remove(1);
            list.remove(0);
        }
        return list.get(0);
    }

    //递归遍历整棵树   构建huffman表 106 0010  111 0011
    private static void createHuffmanMap(CodeNode node, String point, String sb) {
        if (node != null) {
            sb = sb + point;
            if (node.data == null) {//data==null 说明是非叶子节点
                createHuffmanMap(node.left, "0", sb);
                createHuffmanMap(node.right, "1", sb);
            } else {
                //说明当前是叶子节点
                huffmanCodeMap.put(node.data, sb.toString());
            }
        }
    }

    //把byte[]数组 通过赫夫曼编码表进行压缩
    private  static byte[] zip(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes) {
            sb.append(huffmanCodeMap.get(b));// 通过赫夫曼编码表进行字符串拼接
        }
        int len = (sb.length() + 7) / 8; //获取到压缩后的数组长度 ，sb的长度不能被8整除 就补一位长度
        byte[] huffmanByteArray = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String substring;
            if (i + 8 >= sb.length()) {
                substring = sb.substring(i, sb.length());
            } else {
                substring = sb.substring(i, i + 8);
            }
            huffmanByteArray[index++] = (byte) Integer.parseInt(substring, 2);
        }
        return huffmanByteArray;
    }
    //对前面的方法进行一个整合封装  对一个byte数组进行压缩
    private static byte[] huffmanZip(byte[] bytes){
        CodeNode root = getNodes(bytes);//根据byte数组创建赫夫曼树
        createHuffmanMap(root, "", "");//根据哈夫曼树得到赫夫曼编码表
        byte[] zip = zip(bytes);//根据赫夫曼编码表和byte数组得到压缩后的数组
        return zip;
    }
    //将一个byte转换成二进制字符串
    private static String byteToString(byte b,boolean flag){
        int temp =b;//将b转换成int
        if (flag){
            temp |=256;  //对int进行补位，主要是对正数进行补位      或上1,0000,0000
        }
        String str = Integer.toBinaryString(temp);//int转换成二进制的字符串
        if (flag){
            return str.substring(str.length()-8 );
        }else {
            return str ;
        }
    }
    //将压缩后的数组解压
    private static byte[] decode(byte[] huffmanCode){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < huffmanCode.length; i++) {
            boolean flag = (i==huffmanCode.length-1);//是否是最后一个元素
            sb.append(byteToString(huffmanCode[i],!flag ));
        }
        HashMap<String,Byte> decodeMap = new HashMap<>();//解压表、
        //解压表赋值
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            decodeMap.put(entry.getValue(),entry.getKey() );
        }
        List<Byte> list = new ArrayList();
        for (int i = 0; i <sb.length();) {
            int count =1;
            while (true){//动态匹配  第一位匹配不上 就匹配前两位 ，前三位，前四位，。。。。。。
                String key =sb.substring(i,i+count );
                if (decodeMap.containsKey(key)){
                    list.add(decodeMap.get(key));
                    break;
                }
                count++;
            }
            i+=count;//重新定义匹配的起点
        }
        byte[] bytes = new byte[list.size()];//list中的数据存到byte数组
        for (int i = 0; i <list.size() ; i++) {
            bytes[i]=list.get(i);
        }
        return bytes;
    }
}

class CodeNode implements Comparable<CodeNode> {
    Byte data;//数据
    int weight;//权重
    CodeNode left;
    CodeNode right;

    public CodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(CodeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "CodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
