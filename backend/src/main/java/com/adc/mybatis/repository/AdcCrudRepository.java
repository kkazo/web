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


	List<T> findAll(String namespace);
	List<T> findAll(String namespace, List<ID> ids);
	Page<T> findAll(String namespace, Pageable pageable);

	T findOne(String namespace, ID id);
	T findOne(String namespace, T domain);

	boolean contains(String namespace, ID id);

	long count(String namespace, Pageable pageable);

 	int insert(String namespace, T entity);
	int insert(String namespace, List<T> entities);

	int update(String namespace, T entity);
	int update(String namespace, List<T> entities);

	int delete(String namespace, ID id);
	int delete(String namespace, T entity);
	int delete(String namespace, List<? extends T> entities);

	int deleteAll(String namespace);

	List<T> findAll(String namespace, String name);
	List<T> findAll(String namespace, String name, List<ID> ids);
	Page<T> findAll(String namespace, String name, Pageable pageable);

	T findOne(String namespace, String name, ID id);
	T findOne(String namespace, String name, T domain);

	boolean contains(String namespace, String name, ID id);

	long count(String namespace, String name, Pageable pageable);

	int insert(String namespace, String name, T entity);
	int insert(String namespace, String name, List<T> entities);

	int update(String namespace, String name, T entity);
	int update(String namespace, String name, List<T> entities);

	int delete(String namespace, String name, ID id);
	int delete(String namespace, String name, T entity);
	int delete(String namespace, String name, List<? extends T> entities);

	int deleteAll(String namespace, String name);
}
