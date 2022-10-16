package com.ziroom.design.auth;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月29日 17:47:00
 */
public class DefaultApiAuthenticationImpl implements ApiAuthentication{

    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticationImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    public DefaultApiAuthenticationImpl(){
        this.credentialStorage = new MysqlCredentialStorage();
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromGetUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimeStamp();
        String baseUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()){
            throw new RuntimeException("expired token");
        }

        String pwd = credentialStorage.getPwdByAppId(appId);
        AuthToken serverAuthToken = AuthToken.generate(baseUrl,appId,pwd,timestamp,null);
        if (!clientAuthToken.match(serverAuthToken)){
            throw new RuntimeException("token not match");
        }

    }
}
