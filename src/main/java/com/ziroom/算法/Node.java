package com.ziroom.算法;

import lombok.Data;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月16日 15:41:00
 */
@Data
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }
}
