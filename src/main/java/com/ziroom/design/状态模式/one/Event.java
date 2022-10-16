package com.ziroom.design.状态模式.one;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月28日 14:27:00
 */
@Getter
@AllArgsConstructor
public enum Event {
    GOT_MUSHROOM(0), GOT_CAPE(1), GOT_FIRE(2), MET_MONSTER(3);
    private Integer value;
}
