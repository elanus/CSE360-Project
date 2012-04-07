package edu.asu.cse360.data;

public class QuizContent {

	private int questionNumber;
	private String question;
	private Answers studentAnswer, correctAnswer;
	
	public QuizContent()
	{
		question = "Type question here...";
	}

	
/*** Getter and Setter ***/
	
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setStudentAnswer(Answers answerChoice) {
		this.studentAnswer = answerChoice;
	}

	public Answers getStudentAnswer() {
		return studentAnswer;
	}

	public void setCorrectAnswer(Answers correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Answers getCorrectAnswer() {
		return correctAnswer;
	}
	
}
