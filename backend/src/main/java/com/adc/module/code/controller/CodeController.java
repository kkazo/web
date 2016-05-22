package com.adc.module.code.controller;

import com.adc.module.code.domain.Code;
import com.adc.mybatis.repository.AdcCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/module/code")
public class CodeController {

	@Autowired
	@Qualifier("adcCrudRepository")
	AdcCrudRepository<Code, String> service;

	@RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
	public String getAll(Model model) throws Exception {
		return "module/code/main";
	}

	@RequestMapping(value = {"code"})
	public String getList(Code param, Model model) {
		model.addAttribute("result", service.findAll("code", param));
		return "module/code/main";
	}
}
