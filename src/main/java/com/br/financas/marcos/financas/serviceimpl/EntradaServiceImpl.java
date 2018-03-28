package com.br.financas.marcos.financas.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.model.Entrada;
import com.br.financas.marcos.financas.repository.EntradaRepository;
import com.br.financas.marcos.financas.service.EntradaService;

@Service
public class EntradaServiceImpl implements EntradaService {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Override
	public Entrada savaEntrada(Entrada entrada) {
		Entrada obj = entradaRepository.save(entrada);
		return obj;
	}

	@Override
	public List<Entrada> listaTodasPorData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entrada> listaTodasEntradas() {
		
		return entradaRepository.findAll();
	}

	@Override
	public double somaPorData(Data data) {
		
		return entradaRepository.somaPorData(data);
	}

}
