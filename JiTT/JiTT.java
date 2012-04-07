import javax.swing.JFrame;


public class JiTT
{
	public static void main(String[] args)
	{
        //Create and set up the window.
        JFrame frame = new JFrame("JiTT Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        NavigatorPanel demo = new NavigatorPanel();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
}