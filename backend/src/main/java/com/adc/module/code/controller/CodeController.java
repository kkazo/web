package com.adc.module.code.controller;

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
@RequestMapping("/module/code")
public class CodeController {
	@RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
	public String getAll(Model model) throws Exception {
		return "module/code/main";
	}
}
