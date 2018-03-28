package com.br.financas.marcos.financas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_seq")
	@SequenceGenerator(name = "data_seq", sequenceName = "data_seq", allocationSize = 1)
	private Integer id;

	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "data")
	private List<Entrada> entradas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "data")
	private List<Saida> saidas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "data")
	private List<Relatorio> relatorios = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public List<Saida> getSaidas() {
		return saidas;
	}

	public void setSaidas(List<Saida> saidas) {
		this.saidas = saidas;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}
}
