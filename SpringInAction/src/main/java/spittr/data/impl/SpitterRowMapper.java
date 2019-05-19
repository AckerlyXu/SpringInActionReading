package spittr.data.impl;

import java.sql.ResultSet;
import java.sql.SQLException;



import spittr.model.Spitter;

public  class SpitterRowMapper{


	public static Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Spitter spitter=new Spitter(
				rs.getLong("id"),
				rs.getString("username"),
			    rs.getString("password"),
			    rs.getString("fullName"),
			    rs.getString("email"),
			    rs.getBoolean("updateByEmail")
				);
		return spitter;
	}

}
