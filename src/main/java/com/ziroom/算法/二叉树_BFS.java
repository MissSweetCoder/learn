package com.ziroom.算法;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月17日 17:56:00
 */
public class 二叉树_BFS {
    public void bfs(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if (node.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }
}
