package com.murphy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.murphy.core.entity.Favorite;

/**
*
* @author MephistoYZH
* @date 2017年4月5日
**/
@Controller

public class IndexController
{

	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("favorite",new Favorite());
		return "Favorite";
	}
}
