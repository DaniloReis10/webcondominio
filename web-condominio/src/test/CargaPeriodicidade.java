package test;

import java.sql.SQLException;

import org.junit.Test;

import dao.PeriodicidadeDao;
import model.Periodicidade;

public class CargaPeriodicidade {

	@Test
	public void carga() throws SQLException {
		
		String[] lista = {
			"Mensal",
			"Trimestral",
			"Bimestral",
			"Anual"
		};
		
		for (String descricao: lista) {
			Periodicidade periodo = new Periodicidade();
			periodo.setDescricao(descricao);
			
			PeriodicidadeDao dao = new PeriodicidadeDao();
			dao.salvar(periodo);
		}
	}
	
}
