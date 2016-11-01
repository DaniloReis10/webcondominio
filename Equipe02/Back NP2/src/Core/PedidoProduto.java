package Core;

public class PedidoProduto {

	private int id;
	private String nome;
	private int quantidade;
	
	private List<SolicitacaoOferta> solicitacoesOferta;
	
	public PedidoProduto(){
		this.solicitacoesOferta = new ArrayList<SolicitacaoOferta>();
	}
	
}
