package com.ziroom.算法.lianxiang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年04月05日 21:38:00
 */
public class BinaryTree {

    /**
     * @Description: 获取二叉树深度（深度优先）
     * @Author: kairanzhang
     * @Date: 2022/4/5 9:58 下午
     * @param root:
     * @return: int
     **/
    public int calcTreeHeight(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(calcTreeHeight(root.getLeftChild()),calcTreeHeight(root.getRightChild())) + 1;
    }

    /**
     * @Description: 是否完全二叉树
     * @Author: kairanzhang
     * @Date: 2022/4/5 11:06 下午
     * @param root:
     * @return: boolean
     **/
    public boolean isCompleteTree(Node root) {
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root,1));
        int i = 0;
        while(i < list.size()){
            ANode aNode = list.get(i++);
            if(aNode.node != null){
                list.add(new ANode(aNode.node.getLeftChild(),aNode.code * 2));
                list.add(new ANode(aNode.node.getRightChild(),aNode.code * 2 + 1));
            }
        }
        return list.get(i - 1).code == list.size();
    }

    class ANode{
        Node node;
        int code;
        ANode(Node node,int code){
            this.node = node;
            this.code = code;
        }
    }

}
