package com.ziroom.design.访问者.two.file;


/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:09:00
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String filePath){
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }


}
