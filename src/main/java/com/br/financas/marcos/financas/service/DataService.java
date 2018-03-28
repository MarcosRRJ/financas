package com.br.financas.marcos.financas.service;

import java.util.List;

import com.br.financas.marcos.financas.model.Data;

public interface DataService {

	public Data savaData(Data data);

	public List<?> listaTudoPorData();

	public List<Data> listaTodasDatas();

}
