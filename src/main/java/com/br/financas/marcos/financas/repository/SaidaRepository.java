package com.br.financas.marcos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.model.Saida;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Integer>{
	
	@Query("SELECT SUM(s.valor) from Saida s WHERE s.data = :data")
	public double somaPorData(@Param("data") Data data);
	
}