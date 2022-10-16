package com.ziroom.算法;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.common.collect.Maps;
import org.jboss.netty.util.internal.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年08月13日 17:00:00
 */
public class 最大公共子串 {
    public static String maxSubString(String str1 , String str2){
        if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2)){
            return "-1";
        }

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        int maxLength = 0;
        int maxIndex = 0;

        for (int i = 0 ; i < charArr1.length ; i++){
            for (int j = 0 ; j < charArr2.length ; j++){
                if (charArr1[i] == charArr2[j]){
                    int tempMaxLength = 0;
                    int m = i;
                    int n = j;
                    while (m < charArr1.length && n < charArr2.length && charArr1[m] == charArr2[n]){
                        m++;
                        n++;
                        tempMaxLength++;
                    }
                    if (tempMaxLength > maxLength){
                        maxLength = tempMaxLength;
                        maxIndex = m;
                    }
                }
            }
        }
        if (maxLength == 0){
            return "-1";
        }else {
            return str1.substring(maxIndex - maxLength,maxIndex);
        }
    }

    public static String maxSubString1(String str1 , String str2){
        if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2)){
            return "-1";
        }

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        int maxLength = 0;
        int maxIndex = 0;

        Map<Character,String> char2Map = Maps.newHashMap();
        for(int i = 0 ; i < charArr2.length ; i++){
            if (char2Map.containsKey(charArr2[i])){
                char2Map.put(charArr2[i] , char2Map.get(charArr2[i]) + "," + i);
            }else {
                char2Map.put(charArr2[i],i + "");
            }
        }

        for (int i = 0 ; i < charArr1.length ; i++){
            if (char2Map.containsKey(charArr1[i])){
                List<Integer> indexList = Stream.of(char2Map.get(charArr1[i]).split(",")).map(Integer::parseInt).collect(Collectors.toList());
                for (Integer index2 : indexList){
                    int tempMaxLength = 0;
                    int index1 = i;
                    while(index2 < charArr2.length && index1 < charArr1.length && charArr1[index1] == charArr2[index2]){
                        index1++;
                        index2++;
                        tempMaxLength++;
                    }
                    if (tempMaxLength > maxLength){
                        maxLength = tempMaxLength;
                        maxIndex = index1;
                    }
                }
            }
        }

        if (maxLength == 0){
            return "-1";
        }else {
            return str1.substring(maxIndex - maxLength,maxIndex);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("1234");
    }
}
