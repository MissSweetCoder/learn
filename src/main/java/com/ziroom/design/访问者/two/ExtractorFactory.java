package com.ziroom.design.访问者.two;

import com.google.common.collect.Maps;
import com.ziroom.design.访问者.two.file.ResourceFileType;
import com.ziroom.design.访问者.two.operator.Extractor;
import com.ziroom.design.访问者.two.operator.PdfExtractor;
import com.ziroom.design.访问者.two.operator.PptExtractor;

import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月03日 14:55:00
 */
public class ExtractorFactory {

    public static final Map<ResourceFileType, Extractor> extractors = Maps.newHashMap();

    static {
        extractors.put(ResourceFileType.PDF,new PdfExtractor());
        extractors.put(ResourceFileType.PPT,new PptExtractor());
    }

    public static Extractor getByType(ResourceFileType type){
        return extractors.get(type);
    }
}
