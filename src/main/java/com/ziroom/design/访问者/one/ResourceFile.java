package com.ziroom.design.访问者.one;

import lombok.Data;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:08:00
 */
@Data
public abstract class ResourceFile {
    private String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(Visitor visitor);
}
