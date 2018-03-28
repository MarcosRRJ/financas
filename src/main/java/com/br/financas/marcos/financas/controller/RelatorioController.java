package com.br.financas.marcos.financas.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.financas.marcos.financas.model.Relatorio;
import com.br.financas.marcos.financas.service.RelatorioService;

@Controller
public class RelatorioController {

	private static final Logger logger = LoggerFactory.getLogger(RelatorioController.class);

	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value = "/listaTodosRelatorio", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Relatorio>> listaTodosRelatorio() {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirData");
		List<Relatorio> relatorios = new ArrayList<>();
		try {
			
			relatorios = relatorioService.listaTodosRelatorio();
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		
		relatorios.forEach(list -> System.out.println(list.getBalancoMensal()));
		
		return ResponseEntity.ok().body(relatorios);
	}
}
