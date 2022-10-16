package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月16日 15:58:00
 */
public class 二叉查找树_insert {
    private Node node;

    public void insert(int data){
        if (node == null){
            node = new Node(data);
            return;
        }

        Node p = node;
        while (p != null){
            if (data > p.getData()){
                if (p.getRight() == null){
                    p.setRight(new Node(data));
                    return;
                }
                p = p.getRight();
            }else {
                if (p.getLeft() == null){
                    p.setLeft(new Node(data));
                    return;
                }
                p = p.getLeft();
            }

        }
    }
}
