package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * @Auther: zhaotj
 * @Date: 2021/5/30 0030 - 05 - 30 - 21:25
 * @Description: com.study.config
 * @version: 1.0
 */
@Configuration
public class CoreConfig {
    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //配置跨域的请求 * 代表所有
        corsConfiguration.addAllowedOriginPattern("*");
        //配置跨域的方法
        corsConfiguration.addAllowedMethod("*");
        //配置跨域的请求头
        corsConfiguration.addAllowedHeader("*");
        //表示跨域请求的时候是否使用的是同一个session
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }
}
