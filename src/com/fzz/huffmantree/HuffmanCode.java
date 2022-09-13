package com.fzz.huffmantree;

import java.util.*;


public class HuffmanCode {
    public static void main(String[] args) {
        String content="i like like like java do you like java";
        byte[] baseBytes = content.getBytes();

        byte[] huffmanBytes = fromBaseBytesToHuffmanBytes(baseBytes);
//        preOrder(huffmanTreeRoot);
        System.out.println(Arrays.toString(huffmanBytes));

        byte[] decode = decode(huffmanCodes, huffmanBytes);

        System.out.println(new String(decode));


    }


    //解码哈夫曼编码字节数组成原字符字节数组
    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<huffmanBytes.length;i++){
            boolean flag=(i==huffmanBytes.length-1);
            String str=byteToBitString(!flag,huffmanBytes[i]);
            stringBuilder.append(str);
        }
        System.out.println(stringBuilder);
        Map<String,Byte> map=new HashMap<>();
        for(Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list=new ArrayList<>();
        for(int i=0;i<stringBuilder.length();){
            int index=1;
            boolean flag=true;
            Byte b=null;
            while(flag){
                String key;
                if(i+index>stringBuilder.length()-1){
                    key=stringBuilder.substring(i);
                    flag=false;
                }else{
                    key=stringBuilder.substring(i,i+index);
                }
                b=map.get(key);
                if(b==null){
                    index++;
                }else{
                    flag=false;
                }

            }
            list.add(b);
            i=i+index;
        }

        byte[] bytes=new byte[list.size()];
        for(int j=0;j< list.size()-1;j++){
            bytes[j]=list.get(j);
        }
        return bytes;

    }

    public static String byteToBitString(boolean flag,byte huffmanByte){
        int temp=huffmanByte;
        if(flag){
            temp|=256;
        }
        String s = Integer.toBinaryString(temp);
        if(flag){
            return s.substring(s.length()-8);
        }else{
            return s;
        }


    }



    //整合：获取哈夫曼编码的字节数组
    public static byte[] fromBaseBytesToHuffmanBytes(byte[] baseBytes){
        List<Node> nodes = getNodes(baseBytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getHuffmanCodes(huffmanTreeRoot);
        byte[] huffmanBytes = getHuffmanBytes(baseBytes, huffmanCodes);
        return huffmanBytes;
    }

    //根据存放的字符对应的2进制数 和 原字节数组 获得一个二进制长串，并8个为一位存入新字节数组中
    public static byte[] getHuffmanBytes(byte[] baseBytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder=new StringBuilder();

        for(Byte b:baseBytes){
            String s = huffmanCodes.get(b);
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder.toString());
        int len;
        if(stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else{
            len=stringBuilder.length()/8+1;
        }
        int index=0;
        byte[] newBytes=new byte[len];
        for(int i=0;i<stringBuilder.length();i=i+8){
            String substring;
            if(i+8>stringBuilder.length()){
                substring = stringBuilder.substring(i);
            }else{
                substring = stringBuilder.substring(i,i+8);
            }
            newBytes[index]= (byte) Integer.parseInt(substring,2);
            index++;
        }
        return newBytes;


    }

    static Map<Byte,String> huffmanCodes=new HashMap<>();

    static StringBuilder stringBuilder=new StringBuilder();


    public static Map<Byte,String> getHuffmanCodes(Node root){
        if(root==null){
            return null;
        }
        getHuffmanCode(root.left,"0",stringBuilder);
        getHuffmanCode(root.right,"1",stringBuilder);
        return huffmanCodes;
    }


    //根据哈夫曼树获取编码
    public static void getHuffmanCode(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node!=null) {
            if(node.data==null){
                getHuffmanCode(node.left,"0",stringBuilder2);
                getHuffmanCode(node.right,"1",stringBuilder2);
            }else{
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }



    //将字节数组转成结点存入list集合中
    public static List<Node> getNodes(byte[] bytes){
        List<Node> list=new ArrayList<>();
        Map<Byte,Integer> map=new HashMap<>();
        for(byte b:bytes){
            Integer count=map.get(b);
            if(count==null){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }

        for(Map.Entry<Byte,Integer> entry: map.entrySet()){
            list.add(new Node(entry.getKey(),entry.getValue()));
        }
        return list;
    }

    //创建哈夫曼树
    public static Node createHuffmanTree(List<Node> nodes){
        while(nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent=new Node(null, leftNode.count+ rightNode.count);
            parent.left=leftNode;
            parent.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    //前序遍历
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("树为空");
        }
    }
}


//数结点
class Node implements Comparable<Node> {
    Byte data;
    int count;
    Node left;
    Node right;

    public Node(Byte data,int count){
        this.count=count;
        this.data=data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.count-o.count;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}

