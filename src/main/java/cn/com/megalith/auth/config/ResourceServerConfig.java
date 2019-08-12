package cn.com.megalith.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @Description: 资源提供端的配置  目前和授权认证端处于同一应用
 * @author: zhoum
 * @Date: 2018-11-22
 * @Time: 16:58
 */
@Configuration
@EnableResourceServer //开启资源提供服务的配置  是默认情况下spring security oauth2的http配置   会被WebSecurityConfigurerAdapter的配置覆盖
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/oauth/token" , "oauth/check_token").permitAll()//定义这两个链接不需要登录可访问
                .antMatchers("/user/hello").permitAll()
                .anyRequest().authenticated(); //其他的都需要登录
    }


}
