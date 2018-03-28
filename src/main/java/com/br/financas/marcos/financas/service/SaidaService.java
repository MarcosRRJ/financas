package com.br.financas.marcos.financas.service;

import java.util.List;
import java.util.Optional;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.model.Saida;

public interface SaidaService {
	
	public Saida savaSaida(Saida saida);

	public List<Saida> listaTodasPorData();
	
	public List<Saida> listaTodasSaidas();
	
	public double somaPorData(Data data);

	public Optional<Saida> pegaUmaSaidas(Integer id);
}
