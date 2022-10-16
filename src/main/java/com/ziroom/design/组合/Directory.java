package com.ziroom.design.组合;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月08日 14:53:00
 */
public class Directory extends FileSystemNode{
    List<FileSystemNode> subNode = Lists.newArrayList();

    public Directory(String path){
        super(path);
    }

    @Override
    public int countNumsOfFiles() {
        int num = 0;
        for (int i = 0 ; i < subNode.size() ; i++){
            num += subNode.get(i).countNumsOfFiles();
        }
        return num;
    }

    @Override
    public long countSizeOfFiles() {
        int size = 0;
        for (FileSystemNode node : subNode){
            size += node.countSizeOfFiles();
        }
        return size;
    }

    public void addNode(FileSystemNode node){
        subNode.add(node);
    }

    public void removeNode(FileSystemNode node){
        int i = 0;
        int size = subNode.size();
        for (; i < size ; i++){
            if (node.getPath().equalsIgnoreCase(subNode.get(i).getPath())){
                break;
            }
        }
        if (i < size){
            subNode.remove(i);
        }
    }
}
