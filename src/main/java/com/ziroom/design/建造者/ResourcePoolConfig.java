package com.ziroom.design.建造者;


import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月06日 17:47:00
 */
@Getter
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;



    private ResourcePoolConfig(ResourcePoolConfig.Builder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder{
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 0;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig builder(){
            if (!StringUtils.hasText(name)){
                throw new IllegalArgumentException("name empty");
            }
            if (maxIdle > maxTotal){
                throw new IllegalArgumentException("maxIdle error");
            }
            if (minIdle > maxIdle || minIdle > maxTotal){
                throw new IllegalArgumentException("minIdle error");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (!StringUtils.hasText(name)){
                throw new IllegalArgumentException("name empty");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal < 0){
                throw new IllegalArgumentException("maxTotal error");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0){
                throw new IllegalArgumentException("maxIdle error");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0){
                throw new IllegalArgumentException("minIdle error");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
}
