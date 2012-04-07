package edu.asu.cse360.model;


import edu.asu.cse360.data.*;

public class ViewReportMod
{
	private Quiz key;
	private Quiz[] studentQuizzes;
	//private list<int[4]> studentScores;
	//private list<double[4]> answerPercentages;
	
	ViewReportMod()
    {
		key = new Quiz();
		
    	
    }
	
	public void getKeyQuiz(String quiz)
	{
		// go to database & set instructor key Quiz
		// part of setQuizData()
	}
	
	public void getStudentQuizzes(String quiz)
	{
		// go to database to gather studentQuizzes[]
		// part of setQuizData()
	}
	
	public Quiz getInstructorKey()
	{
		return key;
	}
	
	public void getStudentScores()
	{
		
	}
	
	public void getAnswerPercentages()
	{
		
	}
}
