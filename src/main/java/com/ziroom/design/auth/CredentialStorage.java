package com.ziroom.design.auth;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月29日 17:32:00
 */
public interface CredentialStorage {

    String getPwdByAppId(String appId);

}
