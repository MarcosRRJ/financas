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

	int fazInsert = 0 ;

	@Override
	public int savaData(Data data) {
		fazInsert = 0 ;
		
		dataRepository.findAll().forEach(dataEquals ->{
			if(dataEquals.getDescricao().equals(data.getDescricao())){
				fazInsert = 1;
			System.out.println("igual");
		}
			else
				System.out.println("Diferente");
		});
				
		if (fazInsert == 0) 
			
			dataRepository.save(data);
		
		
		return fazInsert;
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
