package com.ziroom.spi.dubbospi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年03月06日 16:35:00
 */
@SPI
public interface Search {
    public void search(String word);
}
