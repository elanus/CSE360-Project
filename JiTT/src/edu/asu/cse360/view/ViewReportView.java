package edu.asu.cse360.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import edu.asu.cse360.data.*;

public class ViewReportView extends View
{
	static final long serialVersionUID = 1l;
	
	// private Color wrong = Color.red; // don't need
	private Color right = Color.green;
	// private JLabel selectQuiz; // changed to local
	//private JComboBox availableReports; // in navigator
	//private JButton GoButton; // in navigator

	private String reportName;
	//private JLabel question;
	//private JLabel answer;
	//private JLabel percent;
	//private Bar Graphs
	
	private JPanel report;

    public ViewReportView()
    {
    	JLabel selectQuiz = new JLabel("Please select a quiz");
        add(selectQuiz);
    }
    
    ViewReportView(String reportName)
    {
    	this.reportName = reportName;
        report = new JPanel(); // blank report
        //showReport();
        add(report);
    }
    
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
    	report = new JPanel(); // clear old report
    	report.setLayout(new BoxLayout(report, BoxLayout.Y_AXIS));
    	report.add(new JLabel(getReportName())); // title of report

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

	    	// DrawBarGraph(percents[i])
	    	
	    	// add each question to report
	    	report.add(new JLabel("Question 1"));
	    	report.add(answerA);
	    	report.add(answerB);
	    	report.add(answerC);
	    	report.add(answerD);
    	
	    // place on this JPanel's view
    	add(report, BorderLayout.CENTER);
    	//validate() or revalidate()???
    	revalidate();
    }
    
    public void DrawBarGraph(double percent)
    {
    	/* from ChartPanel.java example 
    	double[] values = new double[4];
        values[0] = 1;
        values[1] = 2;
        values[2] = 4;
        values[3] = 3;
    	String[] answers = {"A", "B", "C", "D"};
		String title;
  		
		public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		if (values == null || values.length == 0)
      			return;
    		double minValue = 0;
    		double maxValue = 0;
    		for (int i = 0; i < values.length; i++) {
      			if (minValue > values[i])
        			minValue = values[i];
      			if (maxValue < values[i])
        			maxValue = values[i];
    		}
    	
    		Dimension d = getSize();
    		int clientWidth = d.width;
    		int clientHeight = d.height;
    		int barWidth = clientWidth / values.length;

    		Font titleFont = new Font("SansSerif", Font.BOLD, 20);
    		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
    		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    		int titleWidth = titleFontMetrics.stringWidth(title);
    		int y = titleFontMetrics.getAscent();
    		int x = (clientWidth - titleWidth) / 2;
    		g.setFont(titleFont);
    		g.drawString(title, x, y);

    		int top = titleFontMetrics.getHeight();
    		int bottom = labelFontMetrics.getHeight();
    		if (maxValue == minValue)
      			return;
    		double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    		y = clientHeight - labelFontMetrics.getDescent();
    		g.setFont(labelFont);

    		for (int i = 0; i < values.length; i++) {
      			int valueX = i * barWidth + 1;
      			int valueY = top;
      			int height = (int) (values[i] * scale);
      			if (values[i] >= 0)
        			valueY += (int) ((maxValue - values[i]) * scale);
      			else {
        			valueY += (int) (maxValue * scale);
        			height = -height;
      			}

      		g.setColor(Color.red);
      		g.fillRect(valueX, valueY, barWidth - 2, height);
      		g.setColor(Color.black);
      		g.drawRect(valueX, valueY, barWidth - 2, height);
      		int labelWidth = labelFontMetrics.stringWidth(names[i]);
      		x = i * barWidth + (barWidth - labelWidth) / 2;
      		g.drawString(names[i], x, y);
      	} */
    }
} // end of ViewReportView.java


