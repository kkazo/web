package com.adc.mybatis.repository;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-22.
 */
public interface BaseRespository<T, ID extends Serializable> extends Repository<T, ID> {

	final Logger logger = LoggerFactory.getLogger("MYBATIS");

	void setSqlSession(SqlSessionFactory sqlSessionFactory);

	public SqlSession getSqlSession();
}
