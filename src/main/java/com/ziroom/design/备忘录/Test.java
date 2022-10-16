package com.ziroom.design.备忘录;

import java.util.Scanner;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 17:50:00
 */
public class Test {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            if (next.equals(":list")){
                System.out.println(inputText.getText());
            }else if (next.equals(":undo")){
                Snapshot snapshot = snapshotHolder.popStack();
                inputText.restoreSnapshot(snapshot);
            }else {
                Snapshot snapshot = inputText.creatSnapshot();
                snapshotHolder.pushStack(snapshot);
                inputText.append(next);
            }
        }
    }
}
