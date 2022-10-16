package com.ziroom.design.访问者.two.operator;

import com.ziroom.design.访问者.two.file.ResourceFile;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:53:00
 */
public class PdfExtractor implements Extractor {

    @Override
    public void extract(ResourceFile resourceFile) {
        System.out.println("extract pdf,path:"+resourceFile.getFilePath());
    }

}
