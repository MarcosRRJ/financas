
package com.br.financas.marcos.financas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rela_seq")
	@SequenceGenerator(name = "rela_seq", sequenceName = "rela_seq", allocationSize = 1)
	private Integer id;

	private double somaEntra = 0;

	private double somaSaida = 0;

	@ManyToOne
	@JoinColumn(name = "data_id")
	private Data data;

	private double balancoMensal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSomaEntra() {
		return somaEntra;
	}

	public void setSomaEntra(double somaEntra) {
		this.somaEntra = somaEntra;
	}

	public double getSomaSaida() {
		return somaSaida;
	}

	public void setSomaSaida(double somaSaida) {
		this.somaSaida = somaSaida;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public double getBalancoMensal() {
		return balancoMensal;
	}

	public void setBalancoMensal(double balancoMensal) {
		this.balancoMensal = balancoMensal;
	}

}