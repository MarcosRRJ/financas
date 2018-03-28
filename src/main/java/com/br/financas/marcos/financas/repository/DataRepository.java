package com.br.financas.marcos.financas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.financas.marcos.financas.model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer>{
	
	@Query("SELECT d.descricao, SUM(ent.valor) as somaEnt, SUM(sai.valor) as somaSai from Data d, Entrada ent, Saida sai "
			+ "WHERE d.id = sai.data and d.id = ent.data ")
	public List<?> listaTudoPorData();
	
}