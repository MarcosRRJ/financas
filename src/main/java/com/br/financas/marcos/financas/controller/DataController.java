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

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.service.DataService;

@Controller
public class DataController {

	private static final Logger logger = LoggerFactory.getLogger(DataController.class);

	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/inserirData", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Data> inserirData(Data data) {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirData");

		try {
			dataService.savaData(data);
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirData #");
		return ResponseEntity.ok().body(data);
	}
	
	@RequestMapping(value = "/listaTodasDatas", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Data>> listaTodasDatas() {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirData");
		List<Data> datas = new ArrayList<>();
		try {
			
			datas = dataService.listaTodasDatas();
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(datas);
	}
	
	@RequestMapping(value = "/listaTudoPorData", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<?>> listaTudoPorData() {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirData");
		List<?> datas = new ArrayList<>();
		try {
			
			datas = dataService.listaTudoPorData();
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(datas);
	}
}
