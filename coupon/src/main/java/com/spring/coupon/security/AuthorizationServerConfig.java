//package com.spring.coupon.security;
//
//import java.security.KeyPair;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig implements AuthorizationServerConfigurer {
//
//	@Autowired
//	private AuthenticationManager authenticationManger;
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	public static final String RESOURCE_ID = "couponservice";
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Value("${keyFile}")
//	private String keyfile;
//	@Value("${password}")
//	private String password;
//	@Value("${alias}")
//	private String alias;
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory().withClient("coupon").secret(passwordEncoder.encode("1111"))
//				.authorizedGrantTypes("password", "refresh_token").scopes("read", "write").resourceIds(RESOURCE_ID);
//
//	}
//
//	// jdbc token store
////	@Override
////	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////		endpoints.tokenStore(new JdbcTokenStore(dataSource)).authenticationManager(authenticationManger)
////				.userDetailsService(userDetailsService);
////	}
////	
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore()).accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManger)
//				.userDetailsService(userDetailsService);
//	}
//	// InMemory token store
////	@Override
////	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////		endpoints.tokenStore(new InMemoryTokenStore()).authenticationManager(authenticationManger)
////				.userDetailsService(userDetailsService);
////	}
//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Bean
//	public TokenStore tokenStore() {
//		return new JwtTokenStore(jwtAccessTokenConverter());
//	}
//
//	/// jwt part
//	@Bean
//	public JwtAccessTokenConverter jwtAccessTokenConverter() {
//		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(keyfile),
//				password.toCharArray());
//		KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias);
//		jwtAccessTokenConverter.setKeyPair(keyPair);
//		return jwtAccessTokenConverter;
//	}
//
//}
