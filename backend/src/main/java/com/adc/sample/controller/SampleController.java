package com.adc.sample.controller;

import com.adc.common.controller.BaseController;
import com.adc.sample.domain.Sample;
import com.adc.sample.service.SampleService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 샘플 Controller
 *
 * @version 1.0
 * @author ky.cho
 * @since 2016-05-08
 */

@Controller
@RequestMapping("/sample")
public class SampleController extends BaseController {

	@Autowired
	SampleService sampleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model, Sample sample) throws Exception {
		model.addAttribute("result", sampleService.getAll(sample));
		return "sample/index";
	}

}
