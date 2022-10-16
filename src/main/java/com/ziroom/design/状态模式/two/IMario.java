package com.ziroom.design.状态模式.two;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月28日 14:52:00
 */
public interface IMario {
    State getName();

    void obtainMushRoom(MarioStateMachine stateMachine);

    void obtainCape(MarioStateMachine stateMachine);

    void obtainFireFlower(MarioStateMachine stateMachine);

    void meetMonster(MarioStateMachine stateMachine);
}
