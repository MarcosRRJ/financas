package com.br.financas.marcos.financas.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.financas.marcos.financas.model.Entrada;
import com.br.financas.marcos.financas.model.Relatorio;
import com.br.financas.marcos.financas.model.Saida;
import com.br.financas.marcos.financas.repository.RelatorioRepository;
import com.br.financas.marcos.financas.service.RelatorioService;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	private RelatorioRepository relatorioRepository;

	public Relatorio realizaRelatorioEntrada(Entrada obj, double somaEntra) {
		Relatorio relatorio = new Relatorio();
		try {
			for (Relatorio list : relatorioRepository.findAll()) {

				relatorio = list.getData().getId() == obj.getData().getId() ? salvaRelatorioEntrada(somaEntra, list)
						: relatorio;

			}
			if (relatorio.getId() == 0) {
				relatorio.setData(obj.getData());
				salvaRelatorioEntrada(somaEntra, relatorio);

			}

			return relatorio;
		} catch (Exception e) {

			relatorio.setData(obj.getData());
			salvaRelatorioEntrada(somaEntra, relatorio);

			return relatorio;
		}

	}

	public Relatorio realizaRelatorioSaida(Saida obj, double somaSaida) {
		
		Relatorio relatorio = new Relatorio();
		try {
			for (Relatorio list : relatorioRepository.findAll()) {

				relatorio = list.getData().getId() == obj.getData().getId() ? salvaRelatorioSaida(somaSaida, list)
						: relatorio;

			}
			if (relatorio.getId() == 0) {
				relatorio.setData(obj.getData());
				salvaRelatorioSaida(somaSaida, relatorio);

			}

			return relatorio;
		} catch (Exception e) {

			relatorio.setData(obj.getData());
			salvaRelatorioSaida(somaSaida, relatorio);

			return relatorio;
		}

	}

	private Relatorio salvaRelatorioEntrada(double somaEntra, Relatorio relatorio) {
		relatorio.setSomaEntra(somaEntra);
		relatorio.setBalancoMensal(relatorio.getSomaEntra() - relatorio.getSomaSaida());
		return relatorioRepository.save(relatorio);
	}

	private Relatorio salvaRelatorioSaida(double somaSaida, Relatorio relatorio) {
		relatorio.setSomaSaida(somaSaida);
		relatorio.setBalancoMensal(relatorio.getSomaEntra() - relatorio.getSomaSaida());
		return relatorioRepository.save(relatorio);
	}

	@Override
	public List<Relatorio> listaTodosRelatorio() {
	
		return relatorioRepository.findAll();
	}

}