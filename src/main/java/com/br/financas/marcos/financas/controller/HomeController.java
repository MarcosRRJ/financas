package com.br.financas.marcos.financas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	private String home(){
		return "index";
	}
	
	@RequestMapping("entra")
	private String entra(){
		return "entra";
	}
}
