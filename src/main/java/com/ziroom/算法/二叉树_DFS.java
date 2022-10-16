package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月17日 17:53:00
 */
public class 二叉树_DFS {
    public void dfs(Node root){
        if (root == null)return;
        dfs(root.getLeft());
        dfs(root.getRight());
    }
}
