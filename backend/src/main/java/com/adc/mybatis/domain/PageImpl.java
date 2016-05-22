package com.adc.mybatis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@XmlRootElement(name="page")
public class PageImpl<T> implements Page<T>, Serializable {

	private static final long serialVersionUID = 867755909294344406L;
	private final List<T> content = new ArrayList<T>();
	private final Pageable pageable;
	private final long total;

	public PageImpl() {
		this(null, null, 0);
	}

	public PageImpl(List<T> content, Pageable pageable, long total) {
		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}

		this.content.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}

	public PageImpl(List<T> content) {
		this(content, null, (null == content) ? 0 : content.size());
	}

	@XmlElement
	public List<T> getContent() {
		return Collections.unmodifiableList(content);
	}

	public int getNumber() {
		return pageable == null ? 0 : pageable.getPageNumber();
	}

	public int getSize() {
		return pageable == null ? 10 : pageable.getPageSize();
	}

	public int getTotalPages() {
		return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
	}

	public int getNumberOfElements() {
		return content.size();
	}

	public long getTotalElements() {
		return total;
	}

	public boolean hasPreviousPage() {
		return getNumber() > 1;
	}

	public boolean isFirstPage() {
		return !hasPreviousPage();
	}

	public boolean hasNextPage() {
		return getNumber() < getTotalPages();
	}

	public boolean isLastPage() {
		return !hasNextPage();
	}

	public Iterator<T> iterator() {
		return content.iterator();
	}

	public boolean hasContent() {
		return !content.isEmpty();
	}

	public Sort getSort() {
		return pageable == null ? null : pageable.getSort();
	}

	public int getPageOffset() {

		return ((int)((getNumber() - 1) / 10)) + 1;
	}

}
