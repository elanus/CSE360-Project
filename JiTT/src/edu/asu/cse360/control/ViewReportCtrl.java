package edu.asu.cse360.control;

import java.awt.event.*;

import edu.asu.cse360.model.*;
import edu.asu.cse360.view.*;

public class ViewReportCtrl extends Controller
{
	public ViewReportCtrl()
	{
		super();
	}
	
	public ViewReportCtrl(Model mod, View view)
	{
		super(mod, view);
	}
	
	public void setQuizData(String ReportName)
	{
//		MODEL.getKeyQuiz(ReportName);
//		MODEL.getStudentQuizzes(ReportName);
		
		// logic for setting studentScores
		// and answerPercentages in model
		
		generateReport();
	}
	
	public void generateReport()
	{
//		MODEL.getStudentScores();
//		MODEL.getAnswerPercentages();
		
		// logic for View ShowReport()
		// send required information from model
		gatherAnswers();
		calculatePercentages();
	}
	
	public void gatherAnswers()//Quiz key, Quiz studentQuiz)
	{
		// send ArrayList<int[4]> to View
		// and logic for ShowReport()
	}
	
	public void calculatePercentages()//ArrayList<int[4]> scores, int total)
	{
		// send ArrayList<double> to View
		// and logic for creating DrawBarGraph()
	}
	
	// don't need?
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //if(event.getSource().equals(button))
            //{
            //}
            //else
            //{
            //}
        }
    }
}