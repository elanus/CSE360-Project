package edu.asu.cse360.control;

import java.util.ArrayList;

import edu.asu.cse360.model.*;
import edu.asu.cse360.view.*;
import edu.asu.cse360.data.*;

public class ViewReportCtrl extends Controller
{
	public ViewReportCtrl()
	{
		VIEW = new ViewReportView();
		MODEL = new ViewReportMod();
	}
	
	public ViewReportCtrl(Model mod, View view)
	{
		super(mod, view);
	}
	
	public void gatherAnswers()//Quiz key, Quiz studentQuiz)
	{
		Quiz key = ((ViewReportMod) MODEL).getInstructorKey();
		Quiz[] studentQuizzes = ((ViewReportMod) MODEL).getStudentQuizzes();
		
		/* Pseudocode:
		list<int[4]> scores;
		foreach QuizContent i in key
		int a=0, b=0, c=0, d=0;
		foreach Quiz j in studentQuizzes[]
			QuizContent current = studentQuizzes[j].content.get(i.questionNumber);
			switch (current.correctAnswer):
				case A: a++; break;
			case B: b++; break;
				case C: c++; break;
					case D: d++; break;
					default: break;
			int[] temp = {a, b, c, d};
			scores.add(temp);
		return scores;
		*/
		
		// set studentScores ArrayList<int[4]> in Model
		((ViewReportMod) MODEL).setStudentScores();
	}
	
	public void calculatePercentages()//ArrayList<int[4]> studentScores, int total)
	{
		ArrayList<int[]> studentScores = ((ViewReportMod) MODEL).getStudentScores();
		// TODO: Logic for calculating Percentages.
		// this information will be used for creating the bar graphs in View
		
		// set answerPercentages ArrayList<double[]> in Model
		((ViewReportMod) MODEL).setAnswerPercentages();
	}
	
	public void generateReport(String ReportName)
	{		
		// set the quiz data in model using String ReportName
		((ViewReportMod) MODEL).getQuizData(ReportName);
		
		// logic for setting studentScores and answerPercentages
		gatherAnswers();
		calculatePercentages();
		
		// logic for View's showReport()
    	((ViewReportView) VIEW).setReportName(ReportName);
    	((ViewReportView) VIEW).showReport(
    			((ViewReportMod) MODEL).getInstructorKey(),
    			((ViewReportMod) MODEL).getAnswerPercentages()
    			);
	}
}