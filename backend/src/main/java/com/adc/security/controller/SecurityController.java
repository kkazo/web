package com.adc.security.controller;

import com.adc.sample.domain.Sample;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-17.
 */
@Controller
public class SecurityController {

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String getAll(Model model, Sample sample) throws Exception {
		return "security/login";
	}
}
