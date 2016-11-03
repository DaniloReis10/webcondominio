package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDao {
	
	public static Integer ultimoId(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.getGeneratedKeys();
		Integer ultimoId = null;
		if (rs.next()) {
		    ultimoId = rs.getInt(1);
		}
		return ultimoId;
	}
	
}
