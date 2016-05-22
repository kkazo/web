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
	public List<T> findAll(String queryId) {
		return getSqlSession().selectList(queryId + SUFFIX_LIST);
	}

	@Override
	public List<T> findAll(String queryId, List<ID> ids) {
		return getSqlSession().selectList(queryId+ SUFFIX_LIST, ids);
	}

	@Override
	public Page<T> findAll(String queryId, Pageable pageable) {
		List<T> resultList = getSqlSession().selectList(queryId + SUFFIX_LIST, pageable);
		if (pageable.getPageNumber() > 0) {
			return new PageImpl<T>(resultList, pageable, count(queryId + SUFFIX_COUNT, pageable));
		}
		return new PageImpl<T>(resultList, pageable, resultList.size());
	}

	@Override
	public T findOne(String queryId, ID id) {
		return getSqlSession().selectOne(queryId + SUFFIX_ONE, id);
	}

	@Override
	public T findOne(String queryId, T domain) {
		return getSqlSession().selectOne(queryId + SUFFIX_ONE, domain);
	}

	@Override
	public boolean contains(String queryId, ID id) {
		return findOne(queryId + SUFFIX_CONTAINS, id) != null;
	}

	@Override
	public long count(String queryId, Pageable pageable) {
		return getSqlSession().selectOne(queryId + SUFFIX_COUNT, pageable);
	}

	@Override
	public int insert(String queryId, T entity) {
		return getSqlSession().insert(queryId + SUFFIX_INSERT, entity);
	}

	@Override
	public int insert(String queryId, List<T> entities) {
		return getSqlSession().insert(queryId + SUFFIX_INSERT, entities);
	}

	@Override
	public int update(String queryId, T entity) {
		return getSqlSession().update(queryId + SUFFIX_UPDATE, entity);
	}

	@Override
	public int update(String queryId, List<T> entities) {
		return getSqlSession().update(queryId + SUFFIX_UPDATE, entities);
	}

	@Override
	public int delete(String queryId, ID id) {
		return getSqlSession().delete(queryId + SUFFIX_DELETE, id);
	}

	@Override
	public int delete(String queryId, T entity) {
		return getSqlSession().delete(queryId + SUFFIX_DELETE, entity);
	}

	@Override
	public int delete(String queryId, List<? extends T> entities) {
		return getSqlSession().delete(queryId + SUFFIX_UPDATE, entities);
	}

	@Override
	public int deleteAll(String queryId) {
		return getSqlSession().delete(queryId + SUFFIX_DELETE);
	}
}
