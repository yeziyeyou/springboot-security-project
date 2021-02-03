package com.aaron.security.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 将用户设置在内存中
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void config(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中配置用户，配置多个用户调用`and()`方法
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder()) // 指定加密方式
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("test").password(passwordEncoder().encode("123456")).roles("USER");

        // 配置 UserDetailsService, 用户自定义查询用户的信息
//        auth.userDetailsService(myUserDetailsService);
    }

    /**
     * 自定义 加密器
     *
     * 注:只需要将其注册进入容器中即可，InitializeUserDetailsBeanManagerConfigurer类会从容器
     *    拿去PasswordEncoder.class实现，作为其加密器
     *
     * @date 2019/12/21 17:59
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder：Spring Security 提供的加密工具，可快速实现加密加盐
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()//关闭跨站csrf攻击防御，不然访问不了
                .formLogin() //开启formLogin模式认证
                //登录认证逻辑（静态）
                .loginPage("/login")   //登录页面
                .loginProcessingUrl("/loginAction") //登录请求哪个url，与前端的form action保持一致
                .failureUrl("/login")
                .defaultSuccessUrl("/index")  //登录成功后请求哪个url
                .usernameParameter("username") //默认是username，与前端中的name保持一致
                .passwordParameter("password") //默认是password，与前端中的name保持一致
                .and()
                //资源权限访问控制（动态）
                .authorizeRequests()
                .antMatchers("/login").permitAll() //不需要认证就可以访问的页面和url
//                .antMatchers("/home", "/index", "/").hasAnyAuthority("ROLE_user", "ROLE_admin") //需要user或者admin权限才能访问
                //除了上面设置过的请求 ，其余任何请求都需要授权认证
                .anyRequest().authenticated();
    }


    /**
     * 忽略拦截
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略url - 会直接过滤该url - 将不会经过Spring Security过滤器链
        web.ignoring().antMatchers("/getUserInfo");
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
        // 开发时，可以将SpringSecurity的debug打开
        web.debug(true);
    }
}
