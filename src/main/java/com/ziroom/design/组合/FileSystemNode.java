package com.ziroom.design.组合;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月08日 14:44:00
 */
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract int countNumsOfFiles();

    public abstract long countSizeOfFiles();
}
