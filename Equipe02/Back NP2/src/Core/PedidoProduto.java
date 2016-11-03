package Core;

import java.util.ArrayList;
import java.util.List;

public class PedidoProduto {

	private int id;
	private String nome;
	private int quantidade;
	
	private List<SolicitacaoOferta> solicitacoesOferta;
	
	public PedidoProduto(){
		this.solicitacoesOferta = new ArrayList<SolicitacaoOferta>();
	}
	
}
