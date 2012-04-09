package edu.asu.cse360.data;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Course extends SQLEntity {

	private String courseName;
	private ArrayList<Student> studentRoster;
	private ArrayList<Quiz> quizzes;
	private Semester semester;
	private Instructor instructor;
	
	
	public Course(String name)
	{
		courseName = name;
	}
	
	
	
/*** Getter and Setter ***/
	
public String getCourseName() {
		return courseName;
	}




	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}




	public ArrayList<Student> getStudentRoster() {
		return studentRoster;
	}




	public void setStudentRoster(ArrayList<Student> studentRoster) {
		this.studentRoster = studentRoster;
	}




	public ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}




	public void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = quizzes;
	}




	public Semester getSemester() {
		return semester;
	}




	public void setSemester(Semester semester) {
		this.semester = semester;
	}




	public Instructor getInstructor() {
		return instructor;
	}




	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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
