package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月27日 16:17:00
 */
public class QueueBasedArray {
    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public QueueBasedArray(int n){
        this.n = n;
        items = new String[n];
    }

    public boolean enqueue(String item){
        if (tail == n){
            if (head == 0) return false;
            //数据搬移
            for (int i = head ; i < tail ; i++){
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if (tail == head) return null;
        String ret = items[head];
        head ++;
        return ret;
    }
}
