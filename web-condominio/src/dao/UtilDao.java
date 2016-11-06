package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class UtilDao {
	
	public static Integer ultimoId(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.getGeneratedKeys();
		Integer ultimoId = null;
		if (rs.next()) {
		    ultimoId = rs.getInt(1);
		}
		return ultimoId;
	}
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
}
