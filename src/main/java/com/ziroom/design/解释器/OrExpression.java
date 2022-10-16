package com.ziroom.design.解释器;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月08日 10:49:00
 */
public class OrExpression implements Expression{

    private List<Expression> expressions = Lists.newArrayList();

    public OrExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public OrExpression(String strExpression){
        String[] split = strExpression.trim().split("\\|\\|");
        Arrays.stream(split).forEach(expression -> {
            expressions.add(new AndExpression(expression));
        });
    }

    @Override
    public boolean interpret(Map<String, Long> status) {
        for (Expression expression : expressions){
            if (expression.interpret(status)){
                return true;
            }
        }
        return false;
    }
}
