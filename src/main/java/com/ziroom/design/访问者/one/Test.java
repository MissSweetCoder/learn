package com.ziroom.design.访问者.one;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:27:00
 */
public class Test {
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAll();
        Extractor extractor = new Extractor();
        resourceFiles.stream().forEach(resourceFile -> {
            resourceFile.accept(extractor);
        });
    }

    private static List<ResourceFile> listAll() {
        List<ResourceFile> resourceFiles = Lists.newArrayList();

        PdfFile pdfFilePath = new PdfFile("pdfFilePath");
        resourceFiles.add(pdfFilePath);

        PptFile pptFilePath = new PptFile("pptFilePath");
        resourceFiles.add(pptFilePath);

        return resourceFiles;
    }
}
