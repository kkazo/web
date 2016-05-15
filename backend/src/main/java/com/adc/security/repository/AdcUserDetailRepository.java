package com.adc.security.repository;

import com.adc.security.domain.AdcRole;
import com.adc.security.domain.AdcUser;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-16.
 */
@Repository
public class AdcUserDetailRepository implements InitializingBean{

	private Map<String, AdcUser> data;

	public AdcUser getUser(String username) {
		return data.get(username);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String password = "$2a$10$yBNfDfONAA1a/ptr9rIiquDBN7X2uMrHL0EaAC.rHBcigvaTeORfK"; // 1234
		data = new HashMap<String, AdcUser>();

		AdcUser user1 = new AdcUser();
		AdcUser user2 = new AdcUser();
		user1.setUsername("admin");
		user2.setUsername("dba");
		user1.setPassword(password);
		user2.setPassword(password);
		user1.setAuthorities(Lists.newArrayList(new AdcRole("ROLE_ADMIN")));
		user2.setAuthorities(Lists.newArrayList(new AdcRole("ROLE_DBA"), new AdcRole("ROLE_ADMIN")));
		data.put("admin", user1);
		data.put("dba", user2);
	}
}
