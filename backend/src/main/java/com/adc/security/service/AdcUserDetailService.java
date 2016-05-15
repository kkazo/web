package com.adc.security.service;

import com.adc.security.domain.AdcRole;
import com.adc.security.domain.AdcUser;
import com.adc.security.repository.AdcUserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 * Created by ChoKwangyo on 2016-05-15.
 */
@Service
public class AdcUserDetailService implements UserDetailsService {

	@Autowired
	AdcUserDetailRepository adcUserDetailRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return adcUserDetailRepository.getUser(username);
		/*
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("admin"));
		//User user = new User("admin", "admin1234", authorities);
//		return user;


//		logger.info("username : " + username);

		// 회원 정보 dao 에서 데이터를 읽어 옴.

		// test 값을 암호화함.
		//String password = "aabcb987e4b425751e210413562e78f776de6285";
		String password = "test1111";

		AdcUser user = new AdcUser();
		user.setUsername(username);
		user.setPassword(password);

		AdcRole role = new AdcRole();
		role.setName("ROLE_USER");

		List<AdcRole> roles = new ArrayList<AdcRole>();
		roles.add(role);
		user.setAuthorities(roles);

		if (user == null) throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");

		return user;
		*/


	}

}
