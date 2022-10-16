package com.ziroom.design.备忘录;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 17:16:00
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText(){
        return text.toString();
    }

    public void append(String input){
        text.append(input);
    }

    public Snapshot creatSnapshot(){
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot){
        this.text.replace(0,text.length(),snapshot.getText());
    }
}
