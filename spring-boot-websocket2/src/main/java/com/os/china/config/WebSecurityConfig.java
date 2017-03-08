package com.os.china.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-8
 * @Version 1.0.0
 */
@Configuration
//开启WebSecurity功能
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//对/和/log请求的路径不拦截
				.antMatchers("/", "/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//登录页面访问的路劲为/login
				.loginPage("/login")
				//登录成功后转向/chat路径
				.defaultSuccessUrl("/chat")
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				//内存中添加两个用户
				.withUser("admin").password("admin").roles("USER")
				.and()
				.withUser("feinik").password("feinik").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//配置/resources/static/**下的静态资源不拦截
		web.ignoring().antMatchers("/resources/static/**");
	}
}
