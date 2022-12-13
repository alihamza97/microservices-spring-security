package com.spring.coupon.security;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableResourceServer
public class ResourceServerConfig implements ResourceServerConfigurer {

	public static final String RESOURCE_ID = "couponservice";
//	@Value("${publicKey}")
//	private String publicKey;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID).tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/couponapi/getCoupon").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.POST, "/couponapi/createCoupon").hasAnyRole("ADMIN").and().csrf().disable();
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	/// jwt part
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(keyfile),
//				password.toCharArray());
//		KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias);
//		jwtAccessTokenConverter.setKeyPair(keyPair);
		jwtAccessTokenConverter.setSigningKey("testkey");
		return jwtAccessTokenConverter;
	}
}
