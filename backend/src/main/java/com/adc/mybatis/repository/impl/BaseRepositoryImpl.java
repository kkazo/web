package com.adc.mybatis.repository.impl;

import com.adc.mybatis.repository.BaseRespository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;

public class BaseRepositoryImpl<T, ID extends Serializable> implements BaseRespository<T, ID> {

	protected SqlSession sqlSession;

	@Override
	@Autowired
	@Qualifier("sqlSessionFactory")
	public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
	}

	@Override
	public SqlSession getSqlSession() {
		return this.sqlSession;
	}

}
