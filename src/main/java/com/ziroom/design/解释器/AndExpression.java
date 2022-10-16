package com.ziroom.design.解释器;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月08日 10:40:00
 */
public class AndExpression implements Expression{

    private List<Expression> expressions = Lists.newArrayList();

    public AndExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public AndExpression(String strExpression){
        String[] split = strExpression.trim().split("&&");
        Arrays.stream(split).forEach(expression -> {
            if (expression.contains(">")){
                expressions.add(new GreaterExpression(expression));
            }else if (expression.contains("<")){
                expressions.add(new LessExpression(expression));
            }else if (expression.contains("=")){
                expressions.add(new EqualExpression(expression));
            }
        });
    }

    @Override
    public boolean interpret(Map<String, Long> status) {
        for (Expression expression : expressions){
            if (!expression.interpret(status)){
                return false;
            }
        }
        return true;
    }
}
