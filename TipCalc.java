//Tip calculator
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.util.Locale;
import java.text.*;

public class TipCalc {
	private JFrame theWindow;
	private mainPanel tipPanel;
	private buttonHandler bHandler;
	private JButton noTip, normTip, genTip;
	private JTextField userTip, subTotal;
	private JLabel total, tip, blank;
	
	public TipCalc()
	{
		JFrame theWindow = new JFrame("Tip Calculator");
		theWindow.setDefaultCloseOperation(theWindow.EXIT_ON_CLOSE);
		mainPanel tipPanel = new mainPanel(400,120);
		tipPanel.setLayout(new GridLayout(4,2));
		buttonHandler bHandler = new buttonHandler();
		
		subTotal = new JTextField("Enter the amount");
		subTotal.setHorizontalAlignment(JTextField.CENTER);
		tipPanel.add(subTotal);
		noTip = new JButton("No Tip");
		noTip.addActionListener(bHandler);
		tipPanel.add(noTip);
		blank = new JLabel(" ");
		blank.setHorizontalAlignment(JLabel.CENTER);
		tipPanel.add(blank);
		normTip = new JButton("15% Tip");
		normTip.addActionListener(bHandler);
		tipPanel.add(normTip);
		tip = new JLabel(" ");
		tip.setHorizontalAlignment(JLabel.CENTER);
		tipPanel.add(tip);
		genTip = new JButton("20% Tip");
		genTip.addActionListener(bHandler);
		tipPanel.add(genTip);
		total = new JLabel(" ");
		total.setHorizontalAlignment(JLabel.CENTER);
		tipPanel.add(total);
		userTip = new JTextField("Different Amount (No %)");
		userTip.setHorizontalAlignment(JTextField.CENTER);
		userTip.addActionListener(bHandler);
		tipPanel.add(userTip);
		
		theWindow.add(tipPanel, BorderLayout.CENTER);
		theWindow.pack();
		theWindow.setVisible(true);
		
	}
	
	private class buttonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
				if (e.getSource() == noTip)
				{
					double sub = Double.parseDouble(subTotal.getText());
					blank.setText("Subtotal: " + formatter.format(sub));
					tip.setText("Tip: " + formatter.format(0));
					total.setText("Total: " + formatter.format(sub));
					
				}
				
				else if (e.getSource() == normTip)
				{
					double sub = Double.parseDouble(subTotal.getText());
					double tipMath = sub * .15;
					double theTotal = sub + tipMath;
					blank.setText("Subtotal: " + formatter.format(sub));
					tip.setText("Tip: " + formatter.format(tipMath));
					total.setText("Total: " + formatter.format(theTotal));
				}
				
				else if (e.getSource() == genTip)
				{
					double sub = Double.parseDouble(subTotal.getText());
					double tipMath = sub * .20;
					double theTotal = sub + tipMath;
					blank.setText("Subtotal: " + formatter.format(sub));
					tip.setText("Tip: " + formatter.format(tipMath));
					total.setText("Total: " + formatter.format(theTotal));
				}
				
				else if (e.getSource() == userTip)
				{
					double sub = Double.parseDouble(subTotal.getText());
					double inputTip = Double.parseDouble(userTip.getText()) * .01;
					double tipMath = sub * inputTip;
					double theTotal = sub + tipMath;
					blank.setText("Subtotal: " + formatter.format(sub));
					tip.setText("Tip: " + formatter.format(tipMath));
					total.setText("Total: " + formatter.format(theTotal));
				}
			}
			catch (NumberFormatException e1)
			{
				subTotal.setText("Please enter a valid number");
			}
		}
	}
	
	public class mainPanel extends JPanel
	{
		int prefWidth, prefHeight;
		public mainPanel (int prefH, int prefW)
		{
			prefWidth = prefW;
			prefHeight = prefH;
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(prefHeight,prefWidth);
		}
	}
	
	public static void main(String [] args)
	{
		new TipCalc();
	}
	
}
