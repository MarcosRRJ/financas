package com.br.financas.marcos.financas.service;

import java.util.List;
import java.util.Optional;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.model.Entrada;

public interface EntradaService {

	public Entrada savaEntrada(Entrada entrada);
	
	public List<Entrada> listaTodasPorData();
	
	public List<Entrada> listaTodasEntradas();
	
	public double somaPorData(Data id);

	public Optional<Entrada> pegaUmaEntrada(Integer id);
}
