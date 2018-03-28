package com.br.financas.marcos.financas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.model.Saida;
import com.br.financas.marcos.financas.repository.SaidaRepository;
import com.br.financas.marcos.financas.service.SaidaService;

@Service
public class SaidaServiceImpl implements SaidaService {

	
	@Autowired
	private SaidaRepository saidaRepository;
	
	@Override
	public Saida savaSaida(Saida saida) {
		Saida obj = saidaRepository.save(saida);
		return obj;
	}

	@Override
	public List<Saida> listaTodasPorData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Saida> listaTodasSaidas() {
		
		return saidaRepository.findAll();
	}

	@Override
	public double somaPorData(Data data) {
		
		return saidaRepository.somaPorData(data);
	}

	@Override
	public Optional<Saida> pegaUmaSaidas(Integer id) {
		Optional<Saida> saida = saidaRepository.findById(id); 
		return saida;
	}

}
