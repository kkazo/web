package com.adc.mybatis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 * Created by ChoKwangyo on 2016-05-23.
 */
public interface AdcCrudRepository<T, ID extends Serializable> {

	final String SUFFIX_LIST = ".findByList";
	final String SUFFIX_COUNT = ".count";
	final String SUFFIX_CONTAINS = ".contains";
	final String SUFFIX_ONE = ".find";
	final String SUFFIX_INSERT = ".insert";
	final String SUFFIX_UPDATE = ".update";
	final String SUFFIX_DELETE = ".delete";


	List<T> findAll(String queryId);
	List<T> findAll(String queryId, List<ID> ids);
	Page<T> findAll(String queryId, Pageable pageable);

	T findOne(String queryId, ID id);
	T findOne(String queryId, T domain);

	boolean contains(String queryId, ID id);

	long count(String queryId, Pageable pageable);

 	int insert(String queryId, T entity);
	int insert(String queryId, List<T> entities);

	int update(String queryId, T entity);
	int update(String queryId, List<T> entities);

	int delete(String queryId, ID id);
	int delete(String queryId, T entity);
	int delete(String queryId, List<? extends T> entities);

	int deleteAll(String queryId);
}
