package com.ziroom.design.访问者.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:17:00
 */
public interface Visitor {

    void visit(PdfFile pdfFile);

    void visit(PptFile pptFile);
}
