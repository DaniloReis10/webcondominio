package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/*
 * Classe com funções utilitárias para as classes DAO
 * 
 * @autor Caio Ponte
 * */
public class UtilDao {
	
	/*
	 * Função que retorna o ultimo id do ultimo registro inserido
	 * 
	 * @param um PreparedStatement com a consulta realizada (amarrando qual a tabela 
	 * deve-se pegar o ultimo registro)
	 * 
	 * @return um <code>integer</code> especificando o id no DB do último registro
	 * */
	public static Integer ultimoId(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.getGeneratedKeys();
		Integer ultimoId = null;
		if (rs.next()) {
		    ultimoId = rs.getInt(1);
		}
		return ultimoId;
	}
	
	/*
	 * Converte de Date para Calendar
	 * 
	 * @param o obejto Date a ser convertido
	 * 
	 * @return um obejto Calendar
	 * */
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
}
