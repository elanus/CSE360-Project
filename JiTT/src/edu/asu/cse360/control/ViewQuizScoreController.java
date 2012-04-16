package edu.asu.cse360.control;

import edu.asu.cse360.model.ViewQuizScoreModel;
import edu.asu.cse360.view.ViewQuizScoreView;


public class ViewQuizScoreController extends Controller {

	public ViewQuizScoreController ()
	{
		VIEW = new ViewQuizScoreView();
		MODEL = new ViewQuizScoreModel();
		
		((ViewQuizScoreView) VIEW).setQuizName(((ViewQuizScoreModel) MODEL).getQuizName());
		((ViewQuizScoreView) VIEW).setInstructions(((ViewQuizScoreModel) MODEL).getInstructions());
		
		for(int i=0; i < ((ViewQuizScoreModel)MODEL).getTotalPoints(); ++i)
		{
			((ViewQuizScoreView) VIEW).setQuestionNumber(i+1);
			//((ViewQuizScoreView) VIEW).setQuestion(((ViewQuizScoreModel) MODEL).getQuestion(i+1));

			
		}
	}
	
	

}
