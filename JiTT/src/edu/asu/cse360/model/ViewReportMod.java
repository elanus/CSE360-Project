package edu.asu.cse360.model;

import edu.asu.cse360.data.*;
import java.util.*;

public class ViewReportMod extends Model
{
	private Quiz key;
	private Quiz[] studentQuizzes;
	private ArrayList<int[]> studentScores;
	private ArrayList<double[]> answerPercentages;
	
	public ViewReportMod()
    {
		key = new Quiz();
		int[] answer = {1, 2, 3, 4};
		studentScores = new ArrayList();
		studentScores.add(answer);
		double[] percents = {2.3, 323.4, 23.532, 2.52, 1.52};
		answerPercentages = new ArrayList();
		answerPercentages.add(percents);
    }
	
	public void getKeyQuiz(String quiz)
	{
		// go to database & set instructor key Quiz
		// part of setQuizData()
		// returns key?
	}
	
	public void getStudentQuizzes(String quiz)
	{
		// go to database to gather studentQuizzes[]
		// part of setQuizData()
		// returns studentQuizzes?
	}
	
	public Quiz getInstructorKey()
	{
		return key;
	}
	
	public ArrayList<int[]> getStudentScores()
	{
		return studentScores;	
	}
	
	public ArrayList<double[]> getAnswerPercentages()
	{
		return answerPercentages;	
	}
}


