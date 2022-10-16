package com.ziroom.design.访问者.two;


import com.google.common.collect.Lists;
import com.ziroom.design.访问者.two.file.PdfFile;
import com.ziroom.design.访问者.two.file.PptFile;
import com.ziroom.design.访问者.two.file.ResourceFile;
import com.ziroom.design.访问者.two.operator.Extractor;

import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:27:00
 */
public class Test {
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAll();
        resourceFiles.stream().forEach(resourceFile -> {
            Extractor extractor = ExtractorFactory.getByType(resourceFile.getType());
            extractor.extract(resourceFile);
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
