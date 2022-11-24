package com.spring.coupon.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig implements ResourceServerConfigurer {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(AuthorizationServerConfig.RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/couponapi/getCoupon").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.POST, "/couponapi/createCoupon").hasAnyRole("ADMIN").and().csrf().disable();
	}

}
