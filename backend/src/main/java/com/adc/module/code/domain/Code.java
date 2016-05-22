package com.adc.module.code.domain;

import com.adc.core.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

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
public class Code extends BaseDomain {


	@Id
	private String id;	// 샘플 아이디
	private String parentId;
	private String name;
	private String code;
	private String value1;
	private String value2;
	private String value3;
	private String value4;
	private String value5;
	private int ord;
}
