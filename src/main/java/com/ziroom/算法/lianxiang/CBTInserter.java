package com.ziroom.算法.lianxiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author kairanzhang
 * @Description 有序插入完全二叉树
 * @createTime 2022年04月06日 11:08:00
 */
public class CBTInserter {
    List<Node> list = new ArrayList<>();

    public CBTInserter(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node);
            if(node.getLeftChild() != null){
                queue.offer(node.getLeftChild());
            }
            if(node.getRightChild() != null){
                queue.offer(node.getRightChild());
            }
        }
    }

    public void insert(int val) {
        Node node = new Node();
        node.setData(val);
        list.add(node);
        int parent = list.size() / 2 - 1;
        if (list.size() % 2 == 0) {
            list.get(parent).setLeftChild(node);
        } else {
            list.get(parent).setRightChild(node);
        }
    }

}
