package com.ziroom.design.auth;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月29日 17:50:00
 */
public class MysqlCredentialStorage implements CredentialStorage{

    @Override
    public String getPwdByAppId(String appId) {
        return "pwd";
    }

}
