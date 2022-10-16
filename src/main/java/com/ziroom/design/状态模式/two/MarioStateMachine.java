package com.ziroom.design.状态模式.two;

import lombok.Data;

import static com.ziroom.design.状态模式.one.State.SMALL;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月28日 14:52:00
 */
@Data
public class MarioStateMachine {
    private int score;
    private IMario currentState;

    public MarioStateMachine(){
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }
}
