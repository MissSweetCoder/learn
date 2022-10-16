package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月16日 15:41:00
 */
public class 二叉查找树_查找 {
    private Node node;

    public Node search(int data){
        Node p = node;
        while (p != null){
            if (data > p.getData()) {
                p = p.getRight();
            }else if (data < p.getData()){
                p = p.getLeft();
            }else {
                return p;
            }
        }
        return null;
    }
}
