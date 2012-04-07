package asu.edu.cse360.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NavigatorPanel
{
    final static String CARDPANEL1 = "Create Course";
    final static String CARDPANEL2 = "Create Quiz";
    final static String CARDPANEL3 = "View Quiz Report";
    final static String CARDPANEL4 = "Take Quiz";
    final static String CARDPANEL5 = "View Quiz Scores";
    JPanel cards; //a panel that uses CardLayout
    JButton CreateCourseButton, CreateQuizButton, ViewReportButton,
    		TakeQuizButton, ViewScoresButton, LogoutButton;

    public void addComponentToPane(Container pane)
    {
        // these will be contained in the OuterPane
        JLabel hello = new JLabel("Start up");
        hello.setHorizontalAlignment(JLabel.CENTER);

        LogoutButton = new JButton("Logout");
        LogoutButton.addActionListener(new ButtonListener());
        JPanel upperPane = new JPanel(); // FlowLayout default
        upperPane.add(hello);
        upperPane.add(LogoutButton);
        
        // Navigation Buttons
        CreateCourseButton = new JButton(CARDPANEL1);
        CreateQuizButton = new JButton(CARDPANEL2);
        ViewReportButton = new JButton(CARDPANEL3);
        TakeQuizButton = new JButton(CARDPANEL4);
        ViewScoresButton = new JButton(CARDPANEL5);
        CreateCourseButton.addActionListener(new ButtonListener());
        CreateQuizButton.addActionListener(new ButtonListener());
        ViewReportButton.addActionListener(new ButtonListener());
        TakeQuizButton.addActionListener(new ButtonListener());
        ViewScoresButton.addActionListener(new ButtonListener());
        
        // ButtonPane will be placed next to cards
        JPanel ButtonPane = new JPanel(new GridLayout(5,1));
        ButtonPane.add(CreateCourseButton);
        ButtonPane.add(CreateQuizButton);
        ButtonPane.add(ViewReportButton);
        ButtonPane.add(TakeQuizButton);
        ButtonPane.add(ViewScoresButton);

        /** Create the "cards" **/
        JPanel CreateCourseCard = new JPanel();
        JPanel CreateQuizCard = new JPanel();
        JPanel ViewReportCard = new ViewReportView(new ViewReportMod());
        JPanel TakeQuizCard = new JPanel();
        JPanel ViewScoresCard = new JPanel();
        CreateCourseCard.add(new JLabel("<html>Create Course<br>View Panel</html>"));
        CreateQuizCard.add(new JLabel("Create Quiz View Panel"));
        //ViewReportCard.add(new JLabel("View Quiz Report View Panel"));
        TakeQuizCard.add(new JLabel("Take Quiz View Panel"));
        ViewScoresCard.add(new JLabel("View Quiz Scores View Panel"));
        
        //Create the panel that actually contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(CreateCourseCard, CARDPANEL1);
        cards.add(CreateQuizCard, CARDPANEL2);
        cards.add(ViewReportCard, CARDPANEL3);
        cards.add(TakeQuizCard, CARDPANEL4);
        cards.add(ViewScoresCard, CARDPANEL5);

        // put everything together
        pane.add(upperPane, BorderLayout.NORTH);
        pane.add(ButtonPane, BorderLayout.WEST);
        pane.add(cards, BorderLayout.CENTER);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	// specific cards are identified by their names (Strings)
            CardLayout c1 = (CardLayout)cards.getLayout();
            if(e.getSource() == CreateCourseButton)
            	c1.show(cards, CARDPANEL1);
            else if(e.getSource() == CreateQuizButton)
                c1.show(cards, CARDPANEL2);
            else if(e.getSource() == ViewReportButton)
                c1.show(cards, CARDPANEL3);
            else if(e.getSource() == TakeQuizButton)
                c1.show(cards, CARDPANEL4);
            else if(e.getSource() == ViewScoresButton)
                c1.show(cards, CARDPANEL5);
            else if(e.getSource() == LogoutButton)
            	System.out.println("logging off"); //	logout procedure
            else
                System.out.println("Unknown Source");
        }
    }
}