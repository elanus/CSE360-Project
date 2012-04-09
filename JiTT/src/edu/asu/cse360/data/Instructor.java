package edu.asu.cse360.data;

import java.sql.ResultSet;

public class Instructor extends User {

	public Instructor()
	{
		isInstructor = true;
	}
	
	
	
	
/*** SQL Methods ***/
	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet select(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
