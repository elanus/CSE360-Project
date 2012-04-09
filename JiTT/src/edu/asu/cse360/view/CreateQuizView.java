package edu.asu.cse360.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class CreateQuizView extends JPanel{
	JButton createFromBlankButton;
	JButton createFromExistingButton;
	
	JButton cancelButton1 = new JButton("Cancel");
	JButton cancelButton2 = new JButton("Cancel");
	JButton cancelButton3 = new JButton("Cancel");	
	JButton nextButton = new JButton("Next");
	JButton completeButton = new JButton("Complete");
	JButton okButton = new JButton("OK");
	JButton nextPageButton = new JButton("Next Page");
	JButton previousPageButton = new JButton("Previous Page");

	private JPanel createQuizPanel;
	private JPanel createFromExistPanel;
	private JPanel assignPanel;
	private JPanel createFromBlankPanel;
	boolean isCreateFromBlank = true;
	
	int questionNumber = 1;
	JLabel questionLabel = new JLabel("Question " + questionNumber + ": ");
	JTextField questionText = new JTextField();	
	JTextField answerAText = new JTextField();
	JTextField answerBText = new JTextField();
	JTextField answerCText = new JTextField();
	JTextField answerDText = new JTextField();

	
	final static String CARDPanel = "Default";
    final static String CARDPANEL2 = "Create from Existing";
    final static String CARDPANEL3 = "Assign Quiz";
    final static String CARDPANEL4 = "Create from Blank";
    
    JRadioButton quiz1;
	JRadioButton quiz2;
	JRadioButton quiz3;
	JRadioButton quiz4;
	JLabel quiz1CourseLabel;
	JLabel quiz2CourseLabel;
	JLabel quiz3CourseLabel;
	JLabel quiz4CourseLabel;
    String[] existQuizList;
    String[] courseOfExistQuiz;
    int numberOfExistQuiz = 0;
    int quizNumber = 0;
    
    private JPanel Othis = this;
    
    
    
    
	public CreateQuizView()
	{
		setLayout (new CardLayout());
		
		createFromBlankButton = new JButton("Create from Blank Quiz");
		createFromExistingButton = new JButton("Create from Existing Quiz");
		
		
		ButtonListener listener = new ButtonListener();	
		createFromBlankButton.addActionListener(listener);
		createFromExistingButton.addActionListener(listener);
		
		createFromBlankPanel = new createFromBlankView();
		createFromExistPanel = new ExistingQuizView();
		assignPanel = new AssignQuizView();	
		createQuizPanel = new JPanel();
		JPanel flow1 = new JPanel();
		JPanel flow2 = new JPanel();
		
		flow1.add(createFromBlankButton);
		flow2.add(createFromExistingButton);
		createQuizPanel.setLayout(new BoxLayout(createQuizPanel,BoxLayout.Y_AXIS));
		createQuizPanel.add(Box.createVerticalGlue());
		createQuizPanel.add(flow1);
    	createQuizPanel.add(Box.createRigidArea(new Dimension(0,10)));
    	createQuizPanel.add(flow2);
		createQuizPanel.add(Box.createVerticalGlue());
		
		add(createQuizPanel,CARDPanel);		
		add(createFromExistPanel,CARDPANEL2);
		add(assignPanel,CARDPANEL3);
		add(createFromBlankPanel,CARDPANEL4);
	}
	
	
	
	
	public class ExistingQuizView extends JPanel
	{
		JLabel t;
		
		
		JPanel buttonPanel;
		JPanel contentPanel;
		JPanel radioButtonPanel;
		JPanel quizPanel;
		
		
		
		
		
		ExistingQuizView()
		{
			//read in the number of Existing Quiz
			numberOfExistQuiz = 7;// for testing
			
			existQuizList = new String[numberOfExistQuiz];
			courseOfExistQuiz = new String[numberOfExistQuiz];
			
			//parse in the content of existQuizList and courseOfExistQuiz
			for(int i = 0; i < numberOfExistQuiz; i++)
			{
				existQuizList[i] = "for testing";
				courseOfExistQuiz[i] = " CSE 360";
			}
			
			quiz1 = new JRadioButton(existQuizList[0] + "   " + courseOfExistQuiz[0]);
			quiz1.setSelected(true);
			quiz2 = new JRadioButton(existQuizList[1] + "   " + courseOfExistQuiz[1]);
			quiz2.setSelected(false);
			quiz3 = new JRadioButton(existQuizList[2] + "   " + courseOfExistQuiz[2]);
			quiz3.setSelected(false);
			quiz4 = new JRadioButton(existQuizList[3] + "   " + courseOfExistQuiz[3]);
			quiz4.setSelected(false);
			
			ButtonGroup group = new ButtonGroup();
			group.add(quiz1);
			group.add(quiz2);
			group.add(quiz3);
			group.add(quiz4);
			
			quiz1.addActionListener(new RadioButtonListener());
			quiz2.addActionListener(new RadioButtonListener());
			quiz3.addActionListener(new RadioButtonListener());
			quiz4.addActionListener(new RadioButtonListener());
			
			quizPanel = new JPanel();
			quizPanel.setLayout(new BoxLayout(quizPanel,BoxLayout.Y_AXIS));
			quizPanel.add(quiz1);
			quizPanel.add(quiz2);
			quizPanel.add(quiz3);
			quizPanel.add(quiz4);
			
			contentPanel = new JPanel();
			contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.X_AXIS));
			contentPanel.add(quizPanel);
			
			ButtonListener listener = new ButtonListener();
			cancelButton1.addActionListener(listener);
			okButton.addActionListener(listener);
			nextPageButton.addActionListener(listener);
			previousPageButton.addActionListener(listener);
			
			buttonPanel = new JPanel();
			buttonPanel.add(okButton);
			buttonPanel.add(previousPageButton);
			buttonPanel.add(nextPageButton);
			buttonPanel.add(cancelButton1);
			
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

			add(contentPanel);
			add(buttonPanel);
		}
		
		private class RadioButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event) {

				Object source = event.getSource();
				//parse the quiz name with its course name of the selected quiz into Model Class
				
			}
			
		}
	}
	
	public class createFromBlankView extends JPanel{
		JLabel hint = new JLabel("Please select one of the four answers as the correct answer.");
		JPanel answer;
		JPanel buttonPanel;
		JRadioButton radioButtonA;
		JRadioButton radioButtonB;
		JRadioButton radioButtonC;
		JRadioButton radioButtonD;
		
		createFromBlankView()
		{			
			completeButton.addActionListener(new ButtonListener());
			nextButton.addActionListener(new ButtonListener());
			cancelButton2.addActionListener(new ButtonListener());

			buttonPanel = new JPanel();
			buttonPanel.add(nextButton);
			buttonPanel.add(completeButton);
			buttonPanel.add(cancelButton2);
			
			JPanel questionPanel = new JPanel();
			questionPanel.setLayout(new BorderLayout());
							
			questionPanel.add(questionLabel,BorderLayout.WEST);
			questionPanel.add(questionText,BorderLayout.CENTER);

			radioButtonA = new JRadioButton("A");
		    radioButtonA.setSelected(true);		    
		    radioButtonB = new JRadioButton("B");
		    radioButtonB.setSelected(false);		    
		    radioButtonC = new JRadioButton("C");
		    radioButtonC.setSelected(false);		    
		    radioButtonD = new JRadioButton("D");
		    radioButtonD.setSelected(false);		    
		    ButtonGroup group = new ButtonGroup();
		    group.add(radioButtonA);
		    group.add(radioButtonB);
		    group.add(radioButtonC);
		    group.add(radioButtonD);
		    		 	    
		    radioButtonA.addActionListener(new RadioButtonListener());
		    radioButtonB.addActionListener(new RadioButtonListener());
		    radioButtonC.addActionListener(new RadioButtonListener());
		    radioButtonD.addActionListener(new RadioButtonListener());
		    
		    JPanel answerAPanel = new JPanel();
		    JPanel aAPanel = new JPanel();
		    aAPanel.setLayout(new BoxLayout(aAPanel,BoxLayout.X_AXIS));
		    aAPanel.add(Box.createHorizontalStrut(34));
		    aAPanel.add(radioButtonA);
		    answerAPanel.setLayout(new BorderLayout());
		    answerAPanel.add(aAPanel,BorderLayout.WEST);
		    answerAPanel.add(answerAText,BorderLayout.CENTER);
		    
		    JPanel answerBPanel = new JPanel();
		    JPanel aBPanel = new JPanel();
		    aBPanel.setLayout(new BoxLayout(aBPanel,BoxLayout.X_AXIS));
		    aBPanel.add(Box.createHorizontalStrut(34));
		    aBPanel.add(radioButtonB);
		    answerBPanel.setLayout(new BorderLayout());
		    answerBPanel.add(aBPanel,BorderLayout.WEST);
		    answerBPanel.add(answerBText,BorderLayout.CENTER);
		    
		    JPanel answerCPanel = new JPanel();
		    JPanel aCPanel = new JPanel();
		    aCPanel.setLayout(new BoxLayout(aCPanel,BoxLayout.X_AXIS));
		    aCPanel.add(Box.createHorizontalStrut(34));
		    aCPanel.add(radioButtonC);
		    answerCPanel.setLayout(new BorderLayout());
		    answerCPanel.add(aCPanel,BorderLayout.WEST);
		    answerCPanel.add(answerCText,BorderLayout.CENTER);
		    
		    JPanel answerDPanel = new JPanel();
		    JPanel aDPanel = new JPanel();
		    aDPanel.setLayout(new BoxLayout(aDPanel,BoxLayout.X_AXIS));
		    aDPanel.add(Box.createHorizontalStrut(34));
		    aDPanel.add(radioButtonD);
		    answerDPanel.setLayout(new BorderLayout());
		    answerDPanel.add(aDPanel,BorderLayout.WEST);
		    answerDPanel.add(answerDText,BorderLayout.CENTER);
		    
		    answer = new JPanel();
			answer.setLayout(new BoxLayout(answer,BoxLayout.Y_AXIS));
			answer.add(hint);
			answer.add(questionPanel);
			answer.add(answerAPanel);
			answer.add(answerBPanel);
			answer.add(answerCPanel);
			answer.add(answerDPanel);
			answer.add(buttonPanel);
			
			add(answer);
					
		}
		private class RadioButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event) {
				//parse the correct answer into Model Class
				Object source = event.getSource();
				//correct answer = sourse --->  "A" or "B" or "C" or "D"
				if(source == radioButtonB)
					answerBText.setText("for testing!");
			}
			
		}

	}
	public class AssignQuizView extends JPanel{
		JLabel title;
		AssignQuizView()
		{
			title = new JLabel("Assign Quiz");
			add(title);
			ButtonListener listener = new ButtonListener();
			cancelButton3.addActionListener(listener);
			add(cancelButton3);
		}
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			CardLayout c = (CardLayout)Othis.getLayout();
			if(event.getSource() == createFromBlankButton)
			{
				c.show(Othis,CARDPANEL4);
			}
			else if(event.getSource() == createFromExistingButton)
			{
				
				c.show(Othis, CARDPANEL2);
			}
			else if((event.getSource() == cancelButton1)||(event.getSource() == cancelButton2)||(event.getSource() == cancelButton3))
			{
				//delete records already typed in
				c.first(Othis);
			}
			else if(event.getSource() == okButton)
			{
				isCreateFromBlank = false;
				//parse existing quiz into create blank quiz page
				questionText.setText(existQuizList[0]);//for testing
				c.show(Othis,CARDPANEL4);
			}
			else if(event.getSource() == nextPageButton)
			{	
				if(quizNumber+4 >= numberOfExistQuiz)
					JOptionPane.showMessageDialog(null,"It's the last page!");
				else
				{
					//parse in next 4 existing quiz names with their course names
					quizNumber += 4;
					quiz1.setText(existQuizList[quizNumber] + "   " + courseOfExistQuiz[quizNumber]);
					if(quizNumber+1 < numberOfExistQuiz)
					{
						quiz2.setText(existQuizList[quizNumber+1]+ "   " + courseOfExistQuiz[quizNumber+1]);
					}					
					else
					{
						quiz2.setText("No more quizzes.");
					}
						
					if(quizNumber+2 < numberOfExistQuiz)
					{
						quiz3.setText(existQuizList[quizNumber+2]+ "   " + courseOfExistQuiz[quizNumber+2]);
					}						
					else
					{
						quiz3.setText("No more quizzes.");
					}
					
					if(quizNumber+3 < numberOfExistQuiz)
					{
						quiz4.setText(existQuizList[quizNumber+3]+ "   " + courseOfExistQuiz[quizNumber+3]);
					}				
					else
					{
						quiz4.setText("No more quizzes.");
					}
						
					
				}
			
			}
			else if(event.getSource() == previousPageButton)
			{	
				if(quizNumber == 0)
					JOptionPane.showMessageDialog(null,"It's the first page!");
				else
				{
					//parse in next 4 existing quiz names with their course names
					quizNumber -= 4;
					
					quiz1.setText(existQuizList[quizNumber]+ "   " + courseOfExistQuiz[quizNumber]);
					quiz2.setText(existQuizList[quizNumber+1]+ "   " + courseOfExistQuiz[quizNumber+1]);
					quiz3.setText(existQuizList[quizNumber+2]+ "   " + courseOfExistQuiz[quizNumber+2]);
					quiz4.setText(existQuizList[quizNumber+3]+ "   " + courseOfExistQuiz[quizNumber+3]);
					
					
				}
			
			}
			else if(event.getSource() == nextButton)
			{	
				
				if(isCreateFromBlank)
				{
					if(questionText.getText().equals("")||(answerAText.getText().equals(""))||(answerBText.getText().equals(""))||(answerBText.getText().equals(""))||(answerDText.getText().equals("")))
						JOptionPane.showMessageDialog(null,"Question or some answers are blank, please fill them in.");
					else
					{
						//save the questions and answers into database
						questionNumber += 1;
						questionLabel.setText("Question "+ questionNumber + ": ");
						questionText.setText(null);
						answerAText.setText(null);
						answerBText.setText(null);
						answerCText.setText(null);
						answerDText.setText(null);
						
					}
					
				}
				else
				{
					if(questionText.getText().equals("")||(answerAText.getText().equals(""))||(answerBText.getText().equals(""))||(answerBText.getText().equals(""))||(answerDText.getText().equals("")))
						JOptionPane.showMessageDialog(null,"There's no more questions!");
					else
					{
						//save the questions and answers into database
						questionNumber += 1;
						questionLabel.setText("Question "+ questionNumber + ": ");
						//parse in next question with its answers
//						questionText.setText(????);
//						answerAText.setText(????);
//						answerBText.setText(????);
//						answerCText.setText(????);
//						answerDText.setText(????);
					}
				}
				
			}
			else if(event.getSource() == completeButton)
					{
					//if some answers of a question are empty, then show up an alert message	
					c.show(Othis, CARDPANEL3);
					}
		}
	}
}
