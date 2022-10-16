package com.ziroom.design.解释器;

import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月08日 10:08:00
 */
public interface Expression {

    boolean interpret(Map<String,Long> status);

}
