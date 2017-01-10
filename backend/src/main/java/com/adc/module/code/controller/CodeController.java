package com.adc.module.code.controller;

import com.adc.core.controller.BaseController;
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
public class CodeController extends BaseController {

	@Autowired
	@Qualifier("adcCrudRepository")
	AdcCrudRepository<Code, String> service;

	@RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
	public String getAll(Model model) throws Exception {
		return "module/code/main";
	}

	@RequestMapping(value = {"code"})
	public String getList(Code param, Model model) {
		if ("#".equals(param.getId())) {
			param.setId("");
		}
		model.addAttribute("result", service.findAll("code", param));
		return "module/code/main";
	}

	@RequestMapping(value = {"get"})
	public void get(Code param, Model model) {
		model.addAttribute("result", service.findOne("code", param));
	}

	@RequestMapping(value = {"update"})
	public void update(Code param, Model model) {
		model.addAttribute("result", service.update("code", param));
	}

	@RequestMapping(value = {"move"})
	public void move(Code param, Model model) {
		model.addAttribute("result", service.update("code", "move", param));
	}

	@RequestMapping(value = {"moveUp"})
	public void moveUp(Code param, Model model) {
		logger.debug(param.toString());
		service.update("code", "moveUp", param);
		service.update("code", "move", param);
	}

	@RequestMapping(value = {"moveDown"})
	public void moveDown(Code param, Model model) {
		service.update("code", "moveDown", param);
		service.update("code", "move", param);
	}

}
