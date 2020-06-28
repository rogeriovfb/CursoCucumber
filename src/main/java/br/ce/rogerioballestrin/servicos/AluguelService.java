package br.ce.rogerioballestrin.servicos;

import br.ce.rogerioballestrin.entidades.Filme;
import br.ce.rogerioballestrin.entidades.NotaAluguel;
import br.ce.rogerioballestrin.utils.DateUtils;

public class AluguelService {
	

	public NotaAluguel alugar(Filme filme, String tipoAluguel) {
		if (filme.getEstoque() == 0) 
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		
		if("extendido".equals(tipoAluguel)){
			nota.setPreco(2*filme.getAluguel());
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			nota.setPontuacao(2);
		}else {
		nota.setPreco(filme.getAluguel());
		nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		nota.setPontuacao(1);
		}
		filme.setEstoque(filme.getEstoque()-1);
		return nota;
	}
}
