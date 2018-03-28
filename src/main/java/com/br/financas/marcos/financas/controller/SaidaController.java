package com.br.financas.marcos.financas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.financas.marcos.financas.model.Saida;
import com.br.financas.marcos.financas.service.RelatorioService;
import com.br.financas.marcos.financas.service.SaidaService;

@Controller
public class SaidaController {

	private static final Logger logger = LoggerFactory.getLogger(SaidaController.class);

	@Autowired
	private SaidaService saidaService;

	@Autowired
	private RelatorioService relatorioService;

	@RequestMapping(value = "/inserirSaida", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Saida> inserirSaida(Saida saida) {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirSaida");

		try {
			Saida obj = saidaService.savaSaida(saida);
			double somaSaida = saidaService.somaPorData(obj.getData());
			relatorioService.realizaRelatorioSaida(obj, somaSaida);

		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirSaida #");
		return ResponseEntity.ok().body(saida);
	}

	@RequestMapping(value = "/listaTodasSaidas", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Saida>> listaTodasSaidas() {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirEntrada");
		List<Saida> saidas = new ArrayList<>();
		try {

			saidas = saidaService.listaTodasSaidas();
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(saidas);
	}

	@RequestMapping(value = "/editarSaida", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Saida> editarSaida(Saida saida) {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirSaida");

		try {

			Saida obj = saidaService.savaSaida(saida);
			double somaSaida = saidaService.somaPorData(obj.getData());
			relatorioService.realizaRelatorioSaida(obj, somaSaida);

		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirSaida #");
		return ResponseEntity.ok().body(saida);
	}

	@RequestMapping(value = "/pegaUmaSaidas", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Optional<Saida>> pegaUmaSaidas(Integer id) {
		logger.debug("# Entrei Controlle de Finanças - Metodo: inserirEntrada");
		Optional<Saida> saidas = null;
		try {

			saidas = saidaService.pegaUmaSaidas(id);
		} catch (Exception e) {

		}
		logger.debug("# Fim do Metodo: inserirEntrada #");
		return ResponseEntity.ok().body(saidas);
	}
}
