package com.adc.sample.domain;

import com.adc.common.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2015-11-15.
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="SAMPLE")
public class Sample extends BaseDomain{

	@Id
	private String sampleId;	// 샘플 아이디

	@Column
	private String subject;		// 주제

	@Column
	private String desc;		// 설명

	@Column
	private String imgGroupId;	// 이미지 그룹 아이디

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;	// 시작 일자

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;		// 종료 일자
}
