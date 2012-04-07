package edu.asu.cse360.model;

import edu.asu.cse360.data.*;
import java.util.*;

public class ViewReportMod
{
	private Quiz key;
	private Quiz[] studentQuizzes;
	private ArrayList<int[]> studentScores;
	private ArrayList<double[]> answerPercentages;
	
	ViewReportMod()
    {
		key = new Quiz();
		int[] answer = {1, 2, 3, 4};
		studentScores.add(answer);
		double[] percents = {2.3, 323.4, 23.532, 2.52, 1.52};
		answerPercentages.add(percents);
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
