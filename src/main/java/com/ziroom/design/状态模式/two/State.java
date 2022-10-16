package com.ziroom.design.状态模式.two;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月28日 14:26:00
 */
@Getter
@AllArgsConstructor
public enum State {
    SMALL(0), SUPER(1), FIRE(2), CAPE(3);
    private Integer value;
}
