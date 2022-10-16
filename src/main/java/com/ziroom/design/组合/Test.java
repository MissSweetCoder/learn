package com.ziroom.design.组合;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月08日 15:14:00
 */
public class Test {
    public static void main(String[] args) {
        Directory root = new Directory("/Users/kairanzhang/Desktop/test");
        Directory aDirectory = new Directory("/Users/kairanzhang/Desktop/test/a");
        Directory bDirectory = new Directory("/Users/kairanzhang/Desktop/test/b");
        File testtestFile = new File("/Users/kairanzhang/Desktop/test/testtest");
        root.addNode(aDirectory);
        root.addNode(bDirectory);
        root.addNode(testtestFile);

        File testaFile = new File("/Users/kairanzhang/Desktop/test/a/testa");
        aDirectory.addNode(testaFile);

        System.out.println(root.countNumsOfFiles());
        System.out.println(root.countSizeOfFiles());

    }
}
