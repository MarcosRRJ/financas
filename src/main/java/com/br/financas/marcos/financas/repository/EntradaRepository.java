package com.br.financas.marcos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.financas.marcos.financas.model.Data;
import com.br.financas.marcos.financas.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {

	@Query("SELECT SUM(e.valor) from Entrada e WHERE e.data = :data")
	public double somaPorData(@Param("data") Data data);
}