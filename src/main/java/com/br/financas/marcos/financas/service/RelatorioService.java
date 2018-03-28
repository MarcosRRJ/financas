package com.br.financas.marcos.financas.service;

import java.util.List;

import com.br.financas.marcos.financas.model.Entrada;
import com.br.financas.marcos.financas.model.Relatorio;
import com.br.financas.marcos.financas.model.Saida;

public interface RelatorioService {
	
	public  Relatorio realizaRelatorioEntrada(Entrada obj, double somaEntra);
	
	public  Relatorio realizaRelatorioSaida(Saida obj, double somaSaida);

	public List<Relatorio> listaTodosRelatorio();

}
