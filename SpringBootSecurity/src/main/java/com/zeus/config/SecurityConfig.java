package com.zeus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;

import jakarta.servlet.DispatcherType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("security configuration");
		http.csrf(csrf -> csrf.disable());

		http.authorizeHttpRequests(auth -> auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/accessError", "/login", "/logout", "/css/**", "/js/**", "/error").permitAll()
				.requestMatchers("/board/list").permitAll() // 게시판 목록: 누구나
				.requestMatchers("/board/insertForm").hasRole("MEMBER") // 게시판 등록: 회원만
				.requestMatchers("/notice/list").permitAll() // 공지사항 목록: 누구나
				.requestMatchers("/notice/insertForm").hasRole("ADMIN") // 공지사항 등록: 관리자만
				.anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
		);
		
		// 접근 거부 처리자에 대한 페이지 이동 URI를 지정
		// 페이지 포워딩:서버내부에서 요청을 사용자가 지정한 /accessError경로로 포워딩(Forwarding)처리한다.
		//(브라우저 주소창은 바뀌지 않고 서버 내부에서 해당 페이지를 보여준다.
		http.exceptionHandling(exception -> exception.accessDeniedPage("/error/accessError"));
		http.exceptionHandling(exception -> exception.accessDeniedHandler(createAccessDeniedHandler()));
		
//		http.formLogin(form -> form
//				// .loginPage("/login") // 커스텀 로그인 페이지가 있다면 지정
//				.defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 기본 URL
//		);

		// 사용자 정의 폼
		http.formLogin(form -> form
				 .loginPage("/login/insertForm") // 커스텀 로그인 페이지 URL get
				 .loginProcessingUrl("/login") // 로그인 폼 Action URL post(Security가 낚아챔)
//				 .defaultSuccessUrl("/", true) // 성공시 기본 화면 설정
				 .successHandler(createAuthenticationSuccessHandler())
				 .permitAll() // 로그인 페이지는 누구나 접근 가능해야 함
		);

		http.logout(logout -> logout
				 .logoutUrl("/logout") // 로그아웃을 처리할 URL (기본값: /logout)
				 .logoutSuccessUrl("/") // 로그아웃 성공 시 이동할 페이지
				 .invalidateHttpSession(true) // HTTP 세션 무효화 (기본값: true)
				 .deleteCookies("JSESSIONID", "remember-me") // 로그아웃 시 관련 쿠키 삭제
				 .permitAll() // 로그아웃 요청은 누구나 접근 가능해야 함
		);

		
		return http.build();
	}

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN", "MANAGER", "MEMBER");
	}

	
	// CustomAccessDeniedHandler를 빈으로 등록한다.
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	// CustomLoginSuccessHandler를 빈으로 등록한다.
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	
}
