package edu.asu.cse360.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CreateQuizView extends JPanel{
	private JButton createFromBlankButton;
	private JButton createFromExistingButton;
	private JButton cancelButton = new JButton("Cancel");
	private JPanel createQuizPanel;
	private JPanel createFromBlankPanel;
	private JPanel createFromExistPanel;
	private JPanel assignPanel;
	final static String CARDPANEL1 = "Default";
    final static String CARDPANEL2 = "Create from Blank";
    final static String CARDPANEL3 = "Create from Existing";
    final static String CARDPANEL4 = "Assign Quiz";
    private JPanel Othis = this;
	public CreateQuizView()
	{
		setLayout (new CardLayout());
		
		createFromBlankButton = new JButton("Create from Blank Quiz");
		createFromExistingButton = new JButton("Create from Existing Quiz");
		
		
		ButtonListener listener = new ButtonListener();	
		createFromBlankButton.addActionListener(listener);
		createFromExistingButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		createFromBlankPanel = new CreateBlankQuizView();
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
//		createQuizPanel.add(createFromBlankButton);
    	createQuizPanel.add(Box.createRigidArea(new Dimension(0,10)));
    	createQuizPanel.add(flow2);
//		createQuizPanel.add(createFromExistingButton);
		createQuizPanel.add(Box.createVerticalGlue());
		
		add(createQuizPanel,CARDPANEL1);
		add(createFromBlankPanel,CARDPANEL2);
		add(createFromExistPanel,CARDPANEL3);
		add(assignPanel,CARDPANEL4);
	}
	
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			CardLayout c = (CardLayout)Othis.getLayout();
			if(event.getSource() == createFromBlankButton)
			{
				c.show(Othis,CARDPANEL2);
			}
			else if(event.getSource() == createFromExistingButton)
			{
				
				c.show(Othis, CARDPANEL3);
			}
//			else if(event.getSource() == assignButton)
//			{
//		
//				c.show(Othis, CARDPANEL4);
//			}
			else if(event.getSource() == cancelButton)
			{
				
				c.first(Othis);
			}
		}
	}
	
	public class ExistingQuizView extends JPanel
	{
		JLabel t;
		ExistingQuizView()
		{
			t = new JLabel("Existing Quiz");
			add(t);
			add(cancelButton);
		}
		
	}
	
	public class CreateBlankQuizView extends JPanel{
		JLabel title;
		CreateBlankQuizView()
		{
			title = new JLabel("Blank Quiz");
			add(title);
			add(cancelButton);
		}
	}
	public class AssignQuizView extends JPanel{
		JLabel title;
		AssignQuizView()
		{
			title = new JLabel("Assign Quiz");
			add(title);
			add(cancelButton);
		}
	}
}
