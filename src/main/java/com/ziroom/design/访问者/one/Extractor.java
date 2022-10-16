package com.ziroom.design.访问者.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:21:00
 */
public class Extractor implements Visitor{

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("extract pdf,path:"+pdfFile.getFilePath());
    }

    @Override
    public void visit(PptFile pptFile) {
        System.out.println("extract ppt,path:"+pptFile.getFilePath());
    }
}
