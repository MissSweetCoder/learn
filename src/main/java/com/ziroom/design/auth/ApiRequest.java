package com.ziroom.design.auth;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月29日 17:07:00
 */
@Data
public class ApiRequest {
    private String baseUrl;
    private String token;
    private Long timeStamp;
    private String appId;

    public ApiRequest(String baseUrl, String token, Long timeStamp, String appId) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.timeStamp = timeStamp;
        this.appId = appId;
    }

    public static ApiRequest createFromGetUrl(String url){
        int index = url.indexOf("?");
        String substring = url.substring(index + 1);
        String[] substringSplit = substring.split("&");

        Map<String,String> splitMap = Maps.newHashMap();
        for (int i = 0 ; i < substringSplit.length ; i++){
            String[] split = substringSplit[i].split("=");
            splitMap.put(split[0],split[1]);
        }

        String token = splitMap.get("token");
        Long timeStamp = Long.valueOf(splitMap.get("timeStamp"));
        String appId = splitMap.get("appId");
        String baseUrl = url.substring(0,index);
        return new ApiRequest(baseUrl,token,timeStamp,appId);
    }
}
