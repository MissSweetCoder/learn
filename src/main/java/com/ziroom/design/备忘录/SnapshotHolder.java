package com.ziroom.design.备忘录;

import java.util.Stack;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 17:25:00
 */
public class SnapshotHolder {

    private Stack<Snapshot> stack = new Stack<>();

    public Snapshot popStack(){
        return stack.pop();
    }

    public void pushStack(Snapshot snapshot){
        stack.push(snapshot);
    }

}
