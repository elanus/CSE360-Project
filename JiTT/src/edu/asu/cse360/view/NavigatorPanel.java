package edu.asu.cse360.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.asu.cse360.model.*;
import edu.asu.cse360.view.*;
import edu.asu.cse360.control.*;

public class NavigatorPanel extends JFrame
{
	static final long serialVersionUID = 1l;
	
	final static String CARDPANEL1 = "Create Course";
    final static String CARDPANEL2 = "Create Quiz";
    final static String CARDPANEL3 = "View Quiz Report";
    final static String CARDPANEL4 = "Take Quiz";
    final static String CARDPANEL5 = "View Quiz Scores";
    JPanel cards; //a panel that uses CardLayout
    JComboBox CreateCourseButton, CreateQuizButton, ViewReportButton,
    		TakeQuizButton, ViewScoresButton;
    JButton asInstructButton, asStudentButton, LogoutButton;

    public void addComponentToPane(Container pane)
    {
        // these will be contained in the OuterPane
        JLabel hello = new JLabel("Welcome to the JiTT Program");
        hello.setHorizontalAlignment(JLabel.CENTER);
        LogoutButton = new JButton("Logout");
        LogoutButton.addActionListener(new ButtonListener());
        JPanel upperPane = new JPanel(); // FlowLayout default
        upperPane.add(hello);
        upperPane.add(LogoutButton);
        
        // Navigation Buttons. JMenu, JTree or whatever works best...
        JPanel navigationPane = new JPanel();
        
        // changes based on user, temporary: JConfirmDialogBox
        int n = JOptionPane.showConfirmDialog(
        		new JFrame(),
        		"Would you like to log in as an Instructor?",
        		"Log in", // frame's title
        		JOptionPane.YES_NO_OPTION
        		);
        if (n == JOptionPane.YES_OPTION)
        	navigationPane = makeInstructor();
        else if (n == JOptionPane.NO_OPTION)
            navigationPane = makeStudent();
        /* see also:
        String s = (String)JOptionPane.showInputDialog(
        		new JFrame(),
        		"Enter Log In Number:",
        		"Customized Dialog",
        		JOptionPane.PLAIN_MESSAGE,
        		null,
        		null,
        		"Enter ID Number here"
        		);
        System.out.println(s);
        */
        
        // CardLayout's not really good idea...
        cards = new JPanel(new CardLayout());
        
        // put everything together
        pane.add(upperPane, BorderLayout.NORTH);
        pane.add(navigationPane, BorderLayout.WEST);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    private JPanel makeInstructor()
    {
        // Instructor uses:
        CreateCourseButton = new JComboBox();
        CreateCourseButton.addItem(CARDPANEL1);
        // add created courses (in the case of edits)
        CreateCourseButton.addItem("Create New Course");
        CreateCourseButton.addItem("Edit Temp Course 1");
        CreateCourseButton.addItem("Edit Temp Course 2");
        
        CreateQuizButton = new JComboBox();
        CreateQuizButton.addItem(CARDPANEL2);
        // add created quizzes (in the case of edits)
//        CreateQuizButton.addItem("Create New Quiz");
//        CreateQuizButton.addItem("Edit Temp Quiz 1");
//        CreateQuizButton.addItem("Edit Temp Quiz 2");
        
        ViewReportButton = new JComboBox();
        ViewReportButton.addItem(CARDPANEL3);
        // add available quiz reports
        ViewReportButton.addItem("View Temp Quiz Report 1");
        ViewReportButton.addItem("View Temp Quiz Report 2");
        ViewReportButton.addItem("View Temp Quiz Report 3");
        
        CreateCourseButton.addActionListener(new ButtonListener());
        CreateQuizButton.addActionListener(new ButtonListener());
        ViewReportButton.addActionListener(new ButtonListener());
        JPanel toReturn = new JPanel(new GridLayout(3,1));
        toReturn.add(CreateCourseButton);
        toReturn.add(CreateQuizButton);
        toReturn.add(ViewReportButton);
        
        return toReturn;
    }
    
    public JPanel makeStudent()
    {
        // Student uses:
        TakeQuizButton = new JComboBox();
        TakeQuizButton.addItem(CARDPANEL4);
        // add available quizzes to take
        TakeQuizButton.addItem("Take Temp Quiz 1");
        TakeQuizButton.addItem("Take Temp Quiz 2");
        TakeQuizButton.addItem("Take Temp Quiz 3");

        ViewScoresButton = new JComboBox();
        ViewScoresButton.addItem(CARDPANEL5);
        // add available quizzes to view
        ViewScoresButton.addItem("View Temp Quiz Scores 1");
        ViewScoresButton.addItem("View Temp Quiz Scores 2");
        ViewScoresButton.addItem("View Temp Quiz Scores 3");
        
        TakeQuizButton.addActionListener(new ButtonListener());
        ViewScoresButton.addActionListener(new ButtonListener());
        JPanel toReturn = new JPanel(new GridLayout(2,1));
        toReturn.add(TakeQuizButton);
        toReturn.add(ViewScoresButton);
        
        return toReturn;
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	// specific cards are identified by their names (Strings)
        	// CardLayout = bad idea, change later
            CardLayout c1 = (CardLayout)cards.getLayout();
            if(e.getSource() == CreateCourseButton)
            {
                JPanel CreateCourseCard = new JPanel();
                CreateCourseCard.add(new JLabel("Create Course View Panel"));
                cards.add(CreateCourseCard, CARDPANEL1);
                c1.show(cards, CARDPANEL1);
            }
            else if(e.getSource() == CreateQuizButton)
            {
                JPanel CreateQuizCard = new CreateQuizView();
               // CreateQuizCard.add(new JLabel("Create Quiz View Panel"));
                cards.add(CreateQuizCard, CARDPANEL2);
                c1.show(cards, CARDPANEL2);
            }
            else if(e.getSource() == ViewReportButton)
            {
            	//JPanel ViewReportCard = new ViewReportView();
            	View ViewReportUI = new ViewReportView((String)ViewReportButton.getSelectedItem());
            	Model ViewReportModel = new ViewReportMod();
            	Controller ViewReportController = new ViewReportCtrl(ViewReportModel, ViewReportUI);
            	cards.add(ViewReportUI, CARDPANEL3);
                c1.show(cards, CARDPANEL3);
            }
            else if(e.getSource() == TakeQuizButton)
            {
                JPanel TakeQuizCard = new JPanel();
                TakeQuizCard.add(new JLabel("Take Quiz View Panel"));
                cards.add(TakeQuizCard, CARDPANEL4);
                c1.show(cards, CARDPANEL4);
            }
            else if(e.getSource() == ViewScoresButton)
            {
                JPanel ViewScoresCard = new JPanel();
                ViewScoresCard.add(new JLabel("View Quiz Scores View Panel"));
                cards.add(ViewScoresCard, CARDPANEL5);
                c1.show(cards, CARDPANEL5);
            }
            else if(e.getSource() == LogoutButton)
            {
            	System.out.println("logging off");
            	//	logout procedure
            }
            else
            {
                System.out.println("Unknown Source");
            }
        }
    }
}