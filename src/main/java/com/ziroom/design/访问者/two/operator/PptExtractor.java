package com.ziroom.design.访问者.two.operator;

import com.ziroom.design.访问者.two.file.ResourceFile;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:54:00
 */
public class PptExtractor implements Extractor {

    @Override
    public void extract(ResourceFile resourceFile) {
        System.out.println("extract ppt,path:"+resourceFile.getFilePath());
    }

}
