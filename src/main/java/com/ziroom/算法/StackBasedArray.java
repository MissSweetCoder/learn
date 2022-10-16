package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月27日 16:42:00
 */
public class StackBasedArray {
    private String[] items;
    private int n;
    private int count;

    public StackBasedArray(int n){
        this.n = n;
        items = new String[n];
    }

    public boolean push(String item){
        if (count == n)return false;
        items[count] = item;
        count++;
        return true;
    }

    public String pop(){
        if (count == 0) return null;
        String ret = items[count--];
        return ret;
    }
}
