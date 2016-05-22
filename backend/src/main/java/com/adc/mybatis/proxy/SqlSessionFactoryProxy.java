package com.adc.mybatis.proxy;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-20.
 */
public class SqlSessionFactoryProxy implements InitializingBean {

	private boolean reloadable = false;
	private static final int DEFAULT_REFRESH_DELAY = 5000;




	@Override
	public void afterPropertiesSet() throws Exception {
		doProxy();
	}

	private void doProxy() throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SqlSessionFactory.class);
		enhancer.setCallback(NoOp.INSTANCE);
		Object obj = enhancer.create();
		System.out.println(obj.getClass());
	}
	/*
	enhancer.setSuperclass(MemberServiceImpl.class);
	enhancer.setCallback(NoOp.INSTANCE);
	// 3. enhancer.create()로 프록시 생성
	Object obj = enhancer.create();
	// 4. 프록시를 통해서 간접 접근
	MemberServiceImpl memberService = (MemberServiceImpl)obj;
	memberService.regist(new Member());
	memberService.getMember("madvirus");
	*/

	public static void main(String[] args) throws Exception {
		SqlSessionFactoryProxy proxy = new SqlSessionFactoryProxy();
		proxy.doProxy();
	}
}
