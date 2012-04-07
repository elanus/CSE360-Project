package asu.edu.cse360.control;

import asu.edu.cse360.model.Model;
import asu.edu.cse360.view.View;

public class Controller {

	protected Model MODEL;
	protected View VIEW;
	
	public Controller()
	{}
	
	public Controller (Model model, View view)
	{
		MODEL = model;
		VIEW = view;
	}
	
	public View getView()
	{
		return VIEW;
	}
	
}
