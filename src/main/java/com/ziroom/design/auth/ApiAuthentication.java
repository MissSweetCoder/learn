package com.ziroom.design.auth;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月29日 17:45:00
 */
public interface ApiAuthentication {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
