package edu.asu.cse360.view;

import java.awt.Color;
import javax.swing.JLabel;

public class ViewQuizScoreView extends View {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	final private Color right = Color.green, wrong = Color.red;
	
	@SuppressWarnings("unused") //no Getter methods
	private JLabel earnedPoints, totalPoints, quizName, instructions,
					questionNumber, question, ABCorD, studentAnswer;
	
	
	
/*** Setters ***/
	
	public void setEarnedPoints(JLabel earnedPoints) {
		this.earnedPoints = earnedPoints;
	}


public void setTotalPoints(JLabel totalPoints) {
	this.totalPoints = totalPoints;
}


public void setQuizName(JLabel quizName) {
	this.quizName = quizName;
}


public void setInstructions(JLabel instructions) {
	this.instructions = instructions;
}


public void setQuestionNumber(JLabel questionNumber) {
	this.questionNumber = questionNumber;
}


public void setQuestion(JLabel question) {
	this.question = question;
}


public void setABCorD(JLabel aBCorD) {
	ABCorD = aBCorD;
}


public void setStudentAnswer(JLabel studentAnswer) {
	this.studentAnswer = studentAnswer;
}


}
