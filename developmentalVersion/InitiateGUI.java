package developmentalVersion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InitiateGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 100;

	public InitiateGUI() {
	
		setTitle("Nile.Com - Amazon's worst nightmare."); // set title of frame
		setSize(WIDTH, HEIGHT); // set size of frame
		
		//Defines a content pane to hold the gui implementation
		Container pane = getContentPane();
		
		// set up the grid layouts arguments (rows, columns, horizontal space, vertical space)
		GridLayout grid5by2 = new GridLayout(5,2,8,4);
		GridLayout grid7by2 = new GridLayout(7,2,8, 4);
		
		// create panels
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		// set the panel's layout
		topPanel.setLayout(grid5by2);
		centerPanel.setLayout(grid7by2);
		bottomPanel.setLayout(grid5by2);
		
		pane.add(topPanel, BorderLayout.NORTH);
		pane.add(centerPanel, BorderLayout.CENTER);
		pane.add(bottomPanel, BorderLayout.SOUTH);
		
		pane.setBackground(Color.CYAN);
		topPanel.setBackground(Color.lightGray);
		centerPanel.setBackground(Color.darkGray);
		bottomPanel.setBackground(Color.GREEN);
		
		centerFrame(WIDTH,HEIGHT);
	} // end constructor
	
	public void centerFrame(int frameWidth, int frameHeight) {
		
		Toolkit aToolKit = Toolkit.getDefaultToolkit();
		
		Dimension screen = aToolKit.getScreenSize();
		
		int xpos = (screen.width - frameWidth) / 2;
		int ypos = (screen.height - frameHeight) / 2;
		
		setBounds(xpos, ypos, frameWidth, frameHeight);
		
	} // end of method
	
	public static void main(String [] args) {
		JFrame aNewStore = new InitiateGUI();
		aNewStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aNewStore.setVisible(true);
	}
}
