package com.ziroom.design.auth;

import lombok.Data;

import java.security.MessageDigest;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月29日 16:32:00
 */
@Data
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1*60*1000;
    private String token;
    private Long creatTime;
    private Long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, Long creatTime, Long expiredTimeInterval) {
        this.token = token;
        this.creatTime = creatTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public AuthToken(String token, Long creatTime) {
        this.token = token;
        this.creatTime = creatTime;
    }

    public static AuthToken generate(String baseUrl,String appId,String pwd,Long timeStamp,Long expiredTimeInterval){
        StringBuilder builder = new StringBuilder();
        builder.append(baseUrl);
        builder.append(appId);
        builder.append(pwd);
        builder.append(timeStamp);
        String MD5 = string2MD5(builder.toString());
        return expiredTimeInterval == null ? new AuthToken(MD5,timeStamp) : new AuthToken(MD5,timeStamp,expiredTimeInterval);
    }

    public boolean isExpired(){
        long currentTimeMillis = System.currentTimeMillis();
        if (creatTime + expiredTimeInterval > currentTimeMillis){
            return true;
        }
        return false;
    }

    public boolean match(AuthToken clientAuthToken){
        String clientToken = clientAuthToken.getToken();
        String thisToken = this.getToken();
        if (clientToken.equals(thisToken)){
            return true;
        }
        return false;
    }


    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }
}
