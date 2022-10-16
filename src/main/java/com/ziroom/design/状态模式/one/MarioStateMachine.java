package com.ziroom.design.状态模式.one;

import static com.ziroom.design.状态模式.one.State.*;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月28日 14:29:00
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    private static final State[][] stateChangeTable = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL} };

    private static final int[][] scoreChangeTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300} };

    public MarioStateMachine(){
        this.score = 0;
        this.currentState = SMALL;
    }

    public void obtainMushRoom() { 
        executeEvent(Event.GOT_MUSHROOM); 
    } 
    
    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    } 
    
    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }
    
    public void meetMonster() { 
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        Integer stateValue = this.currentState.getValue();
        Integer eventValue = event.getValue();
        
        State state = stateChangeTable[stateValue][eventValue];
        int score = scoreChangeTable[stateValue][eventValue];
        this.currentState = state;
        this.score = score;
    }
}
