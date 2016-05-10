package com.adc.sample.service;

import com.adc.sample.domain.Sample;
import com.adc.sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 * Created by ChoKwangyo on 2015-11-15.
 */

@Service("sampleService")
public class SampleService {

	@Autowired
	SampleRepository sampleRepository;

	public List<Sample> getAll(Sample param) {
		return sampleRepository.listSamples();
	}

}
