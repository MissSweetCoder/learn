package com.ziroom.design.解释器;

import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月08日 10:10:00
 */
public class EqualExpression implements Expression{

    private String key;

    private Long value;

    public EqualExpression(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public EqualExpression(String strExpression){
        String[] split = strExpression.trim().split("\\s+");
        if (split.length != 3 && !split[1].equals("=")){
            throw new RuntimeException("Expression is invalid" + strExpression);
        }
        this.key = split[0].trim();
        this.value = Long.valueOf(split[2].trim());
    }

    @Override
    public boolean interpret(Map<String,Long> status) {
        if (!status.containsKey(key)){
            return false;
        }
        Long statusValue = status.get(key);
        return statusValue.equals(value);
    }
}
