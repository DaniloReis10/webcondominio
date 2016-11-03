package Core;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
	
	private int id;
	private String nomeFornecedor;
	private String email;
	private String senha;
	private Endereco endereco;
	private String telefone;
	
	private List<SolicitacaoOferta> solicitacoesOferta;
	
	public Fornecedor() {
		this.solicitacoesOferta = new ArrayList<SolicitacaoOferta>();
	}
	
}
