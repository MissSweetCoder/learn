package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月27日 17:10:00
 */
public class QueueBasedLink {
    private LinkNode head;
    private LinkNode tail;

    public boolean enqueue(LinkNode node){
        if (tail == null){
            head = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public LinkNode dequeue(){
        if (head == null) return null;
        LinkNode old = head;
        head = head.next;
        return old;
    }
    public static class LinkNode{
        private String val;
        private LinkNode next;
    }
}
