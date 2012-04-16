package edu.asu.cse360.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import edu.asu.cse360.data.*;

public class ViewReportView extends View
{
	static final long serialVersionUID = 1l;
	
	private Color wrong = Color.red;
	private Color right = Color.green;
	// private JLabel selectQuiz; // in navigator
	//private JComboBox availableReports; // in navigator
	//private JButton GoButton; // in navigator

	private String reportName;
	//private JLabel question;
	//private JLabel answer;
	//private JLabel percent;
	//private Bar Graphs
	
	private JPanel report;

    public ViewReportView()
    { }
    
    public void setReportName(String name)
    {
    	reportName = name;
    }

    public String getReportName()
    {
    	return reportName;
    }
   
    // should only be called from control
    public void showReport(Quiz key, ArrayList<double[]> percents)
    {
    	report = new JPanel(); // clear old report, if any
    	report.setLayout(new BoxLayout(report, BoxLayout.Y_AXIS));
    	JLabel title = new JLabel("<html><font size=\"5\">"
    			+ getReportName() + "</font></html>");
    	report.add(title); // title of report

    	// get from instructor key quiz in module
    	
    	// for each QuizContent in key:
    		int correctAnswer = 0;
	    	JLabel answerA = new JLabel("A) Answer 1");
	    	JLabel answerB = new JLabel("B) Answer 2");
	    	JLabel answerC = new JLabel("C) Answer 3");
	    	JLabel answerD = new JLabel("D) Answer 4");
	    	
	    	// determine correctAnswer to color green
	    	switch(correctAnswer)
	    	{
	    	case 0: answerA.setForeground(right); break;
	    	case 1: answerB.setForeground(right); break;
	    	case 2: answerC.setForeground(right); break;
	    	case 3: answerD.setForeground(right); break;
	    	default: System.out.println("error, answer not enumerated type"); return;
	    	}

	    	// add each question to report
	    	JPanel question = new JPanel();
	    	question.setLayout(new BoxLayout(question, BoxLayout.Y_AXIS));
	    	question.add(new JLabel("Question 1"));
	    	question.add(answerA);
	    	question.add(answerB);
	    	question.add(answerC);
	    	question.add(answerD);
	    	report.add(question);
	    	
	    	// DrawBarGraph(percents[i])
	    	JPanel barGraph = DrawBarGraph(0.1, correctAnswer);
	    	report.add(barGraph);
	    	
	    	// Dummy Filler Data:
	    	JPanel question2 = new JPanel();
	    	question2.add(new JLabel("<html><br>Question 2<br>really<br>long<br>filler<br></html>"));
	    	question2.setLayout(new BoxLayout(question2, BoxLayout.Y_AXIS));
	    	JPanel question3 = new JPanel();
	    	question3.add(new JLabel("<html><br><br>Question" +
	    			"<br>3<br><br>another<br><br>even<br><br>longer<br><br>" +
	    			"filler<br><br>than<br><br>the<br><br>last<br><br>one<br><br><br>the<br><br>end"));
	    	question3.setLayout(new BoxLayout(question3, BoxLayout.Y_AXIS));
	    	report.add(question2);
	    	report.add(question3);
	    
	    // place on this JPanel's view
	    JScrollPane scroll = new JScrollPane(report);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    Dimension d = new Dimension(500,300);
	    scroll.setPreferredSize(d);
    	add(scroll, BorderLayout.CENTER);
    	//validate() or revalidate()???
    	revalidate();
    }
    
    public JPanel DrawBarGraph(double percent, int correctAnswer)
    {
    	// from ChartPanel.java example 
    	double[] values = {1,2,4,3};
    	Graph bar = new Graph(values, correctAnswer);
		return bar;
    }
    
    private class Graph extends JPanel
    {
		private String[] answers = {"A", "B", "C", "D"};
    	private double[] values;
		private int correct;
	    
		// pre-set dimensions
		private Dimension d = new Dimension(200,200);
	    private int clientWidth = (int)d.getWidth();
		private int clientHeight = (int)d.getHeight();
		private int top = 0; // top of bars
		private int bottom = 30; // bottom of bars
		private int barWidth = clientWidth/4;
		private int y = clientHeight-10; // y position for labels
		private int labelWidth = 10;
		
		public Graph(double[] v, int correct)
		{
		    values = v;
		    this.correct = correct;
		    this.setPreferredSize(d);
    	}
    	  
    	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		if (values.length != 4)
      			return;
    		double minValue = 0;
    		double maxValue = 0;
    		for (int i = 0; i < values.length; i++)
    		{
      			if (minValue > values[i])
        			minValue = values[i];
      			if (maxValue < values[i])
        			maxValue = values[i];
    		}
    		if (maxValue == minValue)
      			return;
    		
    		double scale = (clientHeight-top-bottom)/(maxValue-minValue);
    		
    		for (int i=0; i<values.length; i++)
    		{
      			int valueX = i*barWidth+1;
      			int valueY = top;
      			int height = (int)(values[i]*scale);
      			if (values[i]>=0)
        			valueY += (int)((maxValue-values[i])*scale);
      			else
      			{
        			valueY += (int)(maxValue*scale);
        			height = -height;
      			}
      			
      			if(i == correct)
      				g.setColor(right);
      			else
      				g.setColor(wrong);
	      		g.fillRect(valueX, valueY, barWidth-2, height);
	      		g.setColor(Color.black);
	      		g.drawRect(valueX, valueY, barWidth-2, height);
	      		
	      		int x = i*barWidth+(barWidth-labelWidth)/2;
	      		g.drawString(answers[i], x, y);
    		}
      	}
    }
} // end of ViewReportView.java


