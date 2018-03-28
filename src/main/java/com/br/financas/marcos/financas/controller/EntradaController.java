package com.br.financas.marcos.financas.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.financas.marcos.financas.model.Entrada;
import com.br.financas.marcos.financas.service.RelatorioService;
import com.br.financas.marcos.financas.service.EntradaService;

@Controller
public class EntradaController {

	private static final Logger logger = LoggerFactory.getLogger(EntradaController.class);

	@Autowired
	private EntradaService entradaService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value = "/inserirEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Entrada> inserirEntrada(Entrada entrada) {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirEntrada");

		try {
			Entrada obj = entradaService.savaEntrada(entrada);

			double somaEntra = entradaService.somaPorData(obj.getData());
			relatorioService.realizaRelatorioEntrada(obj, somaEntra);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(entrada);
	}
	
	@RequestMapping(value = "/listaTodasEntradas", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Entrada>> listaTodasEntradas() {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirEntrada");
		List<Entrada> entradas = new ArrayList<>();
		try {

			entradas = entradaService.listaTodasEntradas();
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(entradas);
	}
	
	@RequestMapping(value = "/editarEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Entrada> editarEntrada(Entrada entrada) {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirEntrada");

		try {
			Entrada obj = entradaService.savaEntrada(entrada);

			double somaEntra = entradaService.somaPorData(obj.getData());
			relatorioService.realizaRelatorioEntrada(obj, somaEntra);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(entrada);
	}
}
