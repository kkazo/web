package com.adc.core.domain;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 */

@MappedSuperclass
@Data
public abstract class BaseDomain implements Pageable, Serializable {

	@Column(nullable = false)
	private String regId;	// 등록 아이디

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar regDate = Calendar.getInstance();	// 등록 일자

	@Column
	private String modId;	// 수정 아이디

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modDate;	// 수정 일자

	@Column(nullable = false)
	private char useYn;		// 사용 여부

	@Column(nullable = false)
	private char delYn;		// 삭제 여부

	@Override
	public int getPageNumber() {
		return 0;
	}

	@Override
	public int getPageSize() {
		return 0;
	}

	@Override
	public int getOffset() {
		return 0;
	}

	@Override
	public Sort getSort() {
		return null;
	}
}
