package edu.asu.cse360.model;

import edu.asu.cse360.data.*;
import java.util.ArrayList;

public class ViewReportMod extends Model
{
	private Quiz key;
	private Quiz[] studentQuizzes;
	private ArrayList<int[]> studentScores;
	private ArrayList<double[]> answerPercentages;
	
	public ViewReportMod()
    { }
	
	public void getQuizData(String quiz)
	{
		// use String quiz to get instructor key from database
		key = new Quiz();
		
		// use String quiz to get studentQuizzes from database
		studentQuizzes = new Quiz[4];
		studentQuizzes[0] = new Quiz();
		studentQuizzes[1] = new Quiz();
		studentQuizzes[2] = new Quiz();
		studentQuizzes[3] = new Quiz();
	}

	public Quiz getInstructorKey()
	{
		return key;
	}

	public Quiz[] getStudentQuizzes()
	{
		return studentQuizzes;
	}
	
	public void setStudentScores()
	{
		int[] answer = {1, 2, 3, 4};
		studentScores = new ArrayList<int[]>();
		studentScores.add(answer);
	}
	
	public void setAnswerPercentages()
	{
		double[] percents = {2.3, 323.4, 23.532, 2.52, 1.52};
		answerPercentages = new ArrayList<double[]>();
		answerPercentages.add(percents);
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

