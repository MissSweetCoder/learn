package com.ziroom.design.解释器;

import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月08日 10:52:00
 */
public class AlertRuleInterpreter {

    private Expression expression;

    public AlertRuleInterpreter(String strExpression){
        expression = new OrExpression(strExpression);
    }

    public boolean interpret(Map<String, Long> status) {
        return expression.interpret(status);
    }
}

