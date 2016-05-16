package com.adc.core.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-08.
 */
public class BaseObjectMapper extends ObjectMapper {

	public BaseObjectMapper () {
		super();
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
	}
}
