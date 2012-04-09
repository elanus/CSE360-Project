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
		
	}
	
	public void generateReport()
	{
		
	}
	
	public void gatherAnswers()//Quiz key, Quiz studentQuiz)
	{
		// returns ArrayList<int[4]>
	}
	
	public void calculatePercentages()//ArrayList<int[4]> scores, int total)
	{
		// returns ArrayList<double>
	}
	
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