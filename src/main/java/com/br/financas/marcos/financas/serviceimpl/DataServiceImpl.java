package com.br.financas.marcos.financas.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.repository.DataRepository;
import com.br.financas.marcos.financas.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataRepository dataRepository;

	@Override
	public Data savaData(Data data) {
		Data obj = dataRepository.save(data);
		return obj;
	}

	@Override
	public List<?> listaTudoPorData() {
		return dataRepository.listaTudoPorData();
	}

	@Override
	public List<Data> listaTodasDatas() {

		return dataRepository.findAll();
	}

}
