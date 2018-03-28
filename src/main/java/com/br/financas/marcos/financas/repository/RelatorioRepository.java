package com.br.financas.marcos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.financas.marcos.financas.model.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer>{
	
}