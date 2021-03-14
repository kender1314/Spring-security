package com.example.demo.configure;

import com.example.demo.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * 自定义编写实现类（继承UsernamePasswordAuthenticationFilter类，可以通过数据库进行认证）
 */
@Configuration
public class SecurityConfigurationBySql extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring()
                .antMatchers("/demo/**", "/dasd/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    /**
     * 需要将BCryptPasswordEncoder注册到spring容器中
     *
     * @return {@link BCryptPasswordEncoder}
     */
    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()  //自定义自己编写登录页面
                .loginPage("/login.html") //登录页面
                .loginProcessingUrl("/user/login")  //输入用户数据，点击登录按钮之后访问哪个路径
                .defaultSuccessUrl("/demo/hello").permitAll()  //登录成功之后要跳转的路径
                .and().authorizeRequests()
                    .antMatchers("/permit/hello", "/permit/test").permitAll() //设置哪些路径可以直接访问，不需要认证
                .anyRequest().authenticated()  //所有请求都被拦截
                .and().csrf().disable();   //关闭csrf防护
        http.addFilterBefore(new MyFilter(), FilterSecurityInterceptor.class);
    }
}
