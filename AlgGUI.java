//John McQuown
//December 22, 2014 1:32 AM
//The main program for the algorithmic GUI


import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

public class AlgGUI {
	private JFrame theWindow;
	private mainPanel inputPanel;
	private JButton calc;
	private JTextField intMatrix;
	private JLabel calcMatrix, warshallLabel;
	private buttonListener myListener;
	
	public AlgGUI()
	{
		JFrame theWindow = new JFrame("Warshall Algorithm GUI");
		theWindow.setDefaultCloseOperation(theWindow.EXIT_ON_CLOSE);
		mainPanel inputPanel = new mainPanel(300,120);
		inputPanel.setLayout(new GridLayout(1,3));
		intMatrix = new JTextField();
		calcMatrix = new JLabel();
		calc = new JButton("Calculate");
		buttonListener myListener = new buttonListener();
		intMatrix.addActionListener(myListener);
		calc.addActionListener(myListener);
		
		inputPanel.add(intMatrix);
		inputPanel.add(calc);
		inputPanel.add(calcMatrix);
		calc.setEnabled(false);
		
		theWindow.add(inputPanel, BorderLayout.CENTER);
		theWindow.pack();
		theWindow.setVisible(true);
		
	}
	private class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == intMatrix)
			{
				calc.setEnabled(true);
				
			}
			
			else if (e.getSource() == calc)
			{
				String matrix = intMatrix.getText();
				
			}
			
		}
	}
	
	private class mainPanel extends JPanel
	{
		private int prefWidth, prefHeight;
		public mainPanel (int prefw, int prefh)
		{
			prefWidth = prefw;
			prefHeight = prefh;
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(prefWidth,prefHeight);
		}
	}
	
	public static void main(String [] args)
	{
		new AlgGUI();
	}
}

