package com.adc.mybatis.repository.impl;

import com.adc.core.util.StringUtils;
import com.adc.mybatis.domain.PageImpl;
import com.adc.mybatis.repository.AdcCrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 * Created by ChoKwangyo on 2016-05-22.
 */
@Repository("adcCrudRepository")
public class AdcCrudRepositoryImpl<T, ID extends Serializable> extends BaseRepositoryImpl<T, ID> implements AdcCrudRepository<T, ID> {

	@Override
	public List<T> findAll(String namespace) {
		return getSqlSession().selectList(namespace + SUFFIX_LIST);
	}

	@Override
	public List<T> findAll(String namespace, List<ID> ids) {
		return getSqlSession().selectList(namespace+ SUFFIX_LIST, ids);
	}

	@Override
	public Page<T> findAll(String namespace, Pageable pageable) {
		List<T> resultList = getSqlSession().selectList(namespace + SUFFIX_LIST, pageable);
		if (pageable.getPageNumber() > 0) {
			return new PageImpl<T>(resultList, pageable, count(namespace + SUFFIX_COUNT, pageable));
		}
		return new PageImpl<T>(resultList, pageable, resultList.size());
	}

	@Override
	public T findOne(String namespace, ID id) {
		return getSqlSession().selectOne(namespace + SUFFIX_ONE, id);
	}

	@Override
	public T findOne(String namespace, T domain) {
		return getSqlSession().selectOne(namespace + SUFFIX_ONE, domain);
	}

	@Override
	public boolean contains(String namespace, ID id) {
		return findOne(namespace + SUFFIX_CONTAINS, id) != null;
	}

	@Override
	public long count(String namespace, Pageable pageable) {
		return getSqlSession().selectOne(namespace + SUFFIX_COUNT, pageable);
	}

	@Override
	public int insert(String namespace, T entity) {
		return getSqlSession().insert(namespace + SUFFIX_INSERT, entity);
	}

	@Override
	public int insert(String namespace, List<T> entities) {
		return getSqlSession().insert(namespace + SUFFIX_INSERT, entities);
	}

	@Override
	public int update(String namespace, T entity) {
		return getSqlSession().update(namespace + SUFFIX_UPDATE, entity);
	}

	@Override
	public int update(String namespace, List<T> entities) {
		return getSqlSession().update(namespace + SUFFIX_UPDATE, entities);
	}

	@Override
	public int delete(String namespace, ID id) {
		return getSqlSession().delete(namespace + SUFFIX_DELETE, id);
	}

	@Override
	public int delete(String namespace, T entity) {
		return getSqlSession().delete(namespace + SUFFIX_DELETE, entity);
	}

	@Override
	public int delete(String namespace, List<? extends T> entities) {
		return getSqlSession().delete(namespace + SUFFIX_UPDATE, entities);
	}

	@Override
	public int deleteAll(String namespace) {
		return getSqlSession().delete(namespace + SUFFIX_DELETE);
	}

	@Override
	public List<T> findAll(String namespace, String name) {
		return getSqlSession().selectList(namespace + SUFFIX_LIST + StringUtils.capitalize(name));
	}

	@Override
	public List<T> findAll(String namespace, String name, List<ID> ids) {
		return getSqlSession().selectList(namespace+ SUFFIX_LIST + StringUtils.capitalize(name), ids);
	}

	@Override
	public Page<T> findAll(String namespace, String name, Pageable pageable) {
		List<T> resultList = getSqlSession().selectList(namespace + SUFFIX_LIST + StringUtils.capitalize(name), pageable);
		if (pageable.getPageNumber() > 0) {
			return new PageImpl<T>(resultList, pageable, count(namespace, name, pageable));
		}
		return new PageImpl<T>(resultList, pageable, resultList.size());
	}

	@Override
	public T findOne(String namespace, String name, ID id) {
		return getSqlSession().selectOne(namespace + SUFFIX_ONE + StringUtils.capitalize(name), id);
	}

	@Override
	public T findOne(String namespace, String name, T domain) {
		return getSqlSession().selectOne(namespace + SUFFIX_ONE + StringUtils.capitalize(name), domain);
	}

	@Override
	public boolean contains(String namespace, String name, ID id) {
		return findOne(namespace + SUFFIX_CONTAINS + StringUtils.capitalize(name), id) != null;
	}

	@Override
	public long count(String namespace, String name, Pageable pageable) {
		return getSqlSession().selectOne(namespace + SUFFIX_COUNT + StringUtils.capitalize(name), pageable);
	}

	@Override
	public int insert(String namespace, String name, T entity) {
		return getSqlSession().insert(namespace + SUFFIX_INSERT + StringUtils.capitalize(name), entity);
	}

	@Override
	public int insert(String namespace, String name, List<T> entities) {
		return getSqlSession().insert(namespace + SUFFIX_INSERT + StringUtils.capitalize(name), entities);
	}

	@Override
	public int update(String namespace, String name, T entity) {
		return getSqlSession().update(namespace + SUFFIX_UPDATE + StringUtils.capitalize(name), entity);
	}

	@Override
	public int update(String namespace, String name, List<T> entities) {
		return getSqlSession().update(namespace + SUFFIX_UPDATE + StringUtils.capitalize(name), entities);
	}

	@Override
	public int delete(String namespace, String name, ID id) {
		return getSqlSession().delete(namespace + SUFFIX_DELETE + StringUtils.capitalize(name), id);
	}

	@Override
	public int delete(String namespace, String name, T entity) {
		return getSqlSession().delete(namespace + SUFFIX_DELETE + StringUtils.capitalize(name), entity);
	}

	@Override
	public int delete(String namespace, String name, List<? extends T> entities) {
		return getSqlSession().delete(namespace + SUFFIX_UPDATE + StringUtils.capitalize(name), entities);
	}

	@Override
	public int deleteAll(String namespace, String name) {
		return getSqlSession().delete(namespace + SUFFIX_DELETE + StringUtils.capitalize(name));
	}
}
