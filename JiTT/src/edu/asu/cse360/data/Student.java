package edu.asu.cse360.data;

import java.sql.ResultSet;

public class Student extends User {

	public Student()
	{
		isInstructor = false;
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
