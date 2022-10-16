package com.ziroom.design.状态模式.two;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月28日 14:55:00
 */
public class SmallMario implements IMario{
    private static final SmallMario instance = new SmallMario();

    private SmallMario(){};

    public static SmallMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        //转换状态，触发动作
//        stateMachine.setCurrentState(SuperMario.getInstance());
//        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {

    }
}
