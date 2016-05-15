package com.adc.security.provider;

import com.adc.security.service.AdcUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-16.
 */
@Component
public class AdcAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(AdcAuthenticationProvider.class);

	@Autowired
	AdcUserDetailService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		UserDetails user;
		Collection<? extends GrantedAuthority> authorities;

		try {

			user = userService.loadUserByUsername(username);

			String hashedPassword = passwordEncoder.encode(password);

			logger.info("username : " + username + " / password : " + password + " / hash password : " + hashedPassword);
			logger.info("username : " + user.getUsername() + " / password : " + user.getPassword());

			if ( !passwordEncoder.matches(password, user.getPassword()) ) {
				throw new BadCredentialsException( "암호가 일치하지 않습니다." );
			}
		//	if (!hashedPassword.equals(user.getPassword())) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");

			authorities = user.getAuthorities();
		} catch (UsernameNotFoundException e) {
			logger.info(e.toString());
			throw new UsernameNotFoundException(e.getMessage());
		} catch (BadCredentialsException e) {
			logger.info(e.toString());
			throw new BadCredentialsException(e.getMessage());
		} catch (Exception e) {
			logger.info(e.toString());
			throw new RuntimeException(e.getMessage());
		}

		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		System.out.println(bpe.encode("1234"));
		System.out.println(bpe.encode("adcap0902!"));
		System.out.println(bpe.encode("q1w2e3r4T%"));
		System.out.println(bpe.encode("adcap0903!@#$"));

//		$2a$10$yBNfDfONAA1a/ptr9rIiquDBN7X2uMrHL0EaAC.rHBcigvaTeORfK
//		$2a$10$ZZA/2g/i0TkW3J3NQJBlXeCBRWAa95tBoGCNs7WYXVrbm9GHJIkiu
//		$2a$10$Il3l.vyIX9bEMFOe/mgg/e6FYNFzGHEzOjAT1diYmGfHVxVasVEse
//		$2a$10$/ECFFiOVvluR.Gs7SiMlmupMnDzuLKd5kv88bezF4qGms0pF.LcqG
	}
}