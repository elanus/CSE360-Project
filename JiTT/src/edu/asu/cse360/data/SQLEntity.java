package edu.asu.cse360.data;

import java.sql.*;

public abstract class SQLEntity {
	
	public abstract int insert();

	public abstract int update();

	public abstract int delete();
	
	public abstract ResultSet select(String str); 
	
}
