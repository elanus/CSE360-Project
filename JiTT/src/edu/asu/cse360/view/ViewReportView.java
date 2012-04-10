package edu.asu.cse360.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewReportView extends View
{
	static final long serialVersionUID = 1l;
	
	// private Color wrong = Color.red; // don't need
	private Color right = Color.green;
	// private JLabel selectQuiz; // changed to local
	private JComboBox availableReports;
	private JButton GoButton;

	private String reportName;
	//private JLabel question;
	//private JLabel answer;
	//private JLabel percent;
	//private Bar Graphs
	
	private JPanel report;

    ViewReportView()
    {
    	JLabel selectQuiz = new JLabel("Please select a quiz: ");
    	availableReports = new JComboBox();
    	// // go to module, gather available reports from database
    	// for(int i=0; i<numOfReports; i++)
    	//		availableReports.addItem(Reports[i]);
    	// // where Reports[] is an array of strings
    	// // designating quizzes that are closed
    	// availableReports = new JComboBox(Reports); // is cleaner
    	availableReports.addItem("Quiz 1");
    	availableReports.addItem("Quiz 2");
    	availableReports.addItem("Quiz 3");
    	GoButton = new JButton("Go!");
    	GoButton.addActionListener(new GoListener()); // in controller?

    	JPanel selectQuizBar = new JPanel();
    	selectQuizBar.add(selectQuiz);
    	selectQuizBar.add(availableReports);
    	selectQuizBar.add(GoButton);
    	
    	report = new JPanel(); // black report
    	
    	setLayout(new BorderLayout());
        add(selectQuizBar, BorderLayout.NORTH);
        add(report, BorderLayout.CENTER);
    }
    
    ViewReportView(String reportName)
    {
    	this.reportName = reportName;
        report = new JPanel(); // blank report
        showReport();
        add(report);
    }

    public String getReportName()
    {
    	return reportName;
    }
   
    // should only be called from control
    public void showReport()
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

	    	// DrawBarGraph()
	    	
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
    
    // should be in control ...don't need?
    private class GoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	// when GoButton is pressed "goEvent"
        	// set View's reportName to that in comboBox
        	reportName = (String)availableReports.getSelectedItem(); // is this allowed?
        	
        	// set module's quizzes using View's reportName
        	// setQuizData(ReportName);
        	
        	// Controller generates the report
        	// generateReport();
        	
        	showReport();
        }
    }
} // end of ViewReportView.java


