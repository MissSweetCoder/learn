package com.ziroom.spi.dubbospi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年03月06日 16:37:00
 */
public class Test {
    public static void main(String[] args) {
        ExtensionLoader<Search> extensionLoader = ExtensionLoader.getExtensionLoader(Search.class);
        Search extension = extensionLoader.getExtension("file");
        extension.search("hello world");
    }
}
