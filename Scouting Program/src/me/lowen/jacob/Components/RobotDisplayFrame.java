package me.lowen.jacob.Components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RobotDisplayFrame extends JPanel{

	private static final long serialVersionUID = 3141433468218715001L;

	public RobotDisplayFrame(Map<Integer, Robot> savedRobots) {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		if (savedRobots == null || savedRobots.isEmpty()) {
			this.add(new JLabel("No robots are saved! Press \"Add More Data\" to add some!"));
		} else
		for (Integer i : savedRobots.keySet()) {
			
			Robot bot = savedRobots.get(i);
		
			this.add(new displaypanel(bot.teamNumber, bot.shootHeight, bot.shootRange, bot.climbHeight, bot.autonMeasure, 
					bot.isEveryBot, bot.extraNotes));
		}
		
		//this.pack();
		this.setVisible(true);
	}
	
	class displaypanel extends JPanel {
		private static final long serialVersionUID = 2782955370956704166L;
		//teamNumber = TeamNumber;
		private displaypanel(int TeamNumber, String shootHeight, String ShootRange, String climbHeight, String AutonMeasure, 
				boolean isEveryBot, String extraNotes) {
		 try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		//int TeamNumber = 1;
		Color TeamColor = Color.BLACK;
		JLabel teamLabel = new JLabel("Team " + TeamNumber);
		teamLabel.setForeground(TeamColor);
		
		JLabel heightLabel = new JLabel("Shoot Height:");
		JTextArea heightBox = new JTextArea();
		heightBox.setText(shootHeight);
		heightBox.setBackground(UIManager.getColor( "Panel.background" ));
		heightBox.setEnabled(false);;
		heightBox.setColumns(5);
		heightBox.setEnabled(false);;
		
		JLabel rangeLabel = new JLabel("Shoot Range:");
		JTextArea rangeBox = new JTextArea();
		rangeBox.setText(ShootRange);
		rangeBox.setBackground(UIManager.getColor( "Panel.background" ));
		rangeBox.setColumns(5);
		rangeBox.setEnabled(false);;
		
		JLabel climbLabel = new JLabel("Climb Height:");
		JTextArea climbBox = new JTextArea();
		climbBox.setText(climbHeight);
		climbBox.setBackground(UIManager.getColor( "Panel.background" ));
		climbBox.setColumns(5);
		climbBox.setEnabled(false);;
		
		JLabel autonLabel = new JLabel("Autonomous Rank:");
		JTextArea autonBox = new JTextArea();
		autonBox.setText(AutonMeasure);
		autonBox.setBackground(UIManager.getColor( "Panel.background" ));
		autonBox.setColumns(5);
		autonBox.setEnabled(false);;
		
		JLabel notesLabel = new JLabel("Extra Notes:");
		JTextArea notesBox = new JTextArea();
		notesBox.setText(extraNotes);
		notesBox.setBackground(UIManager.getColor( "Panel.background" ));
		notesBox.setColumns(16);
		notesBox.setEnabled(false);;
		
		JCheckBox everyBotCBox = new JCheckBox("Every Bot?");
		everyBotCBox.setSelected(isEveryBot);
		everyBotCBox.setEnabled(false);;
		
		this.add(teamLabel);
		this.add(heightLabel);
		this.add(heightBox);
		this.add(rangeLabel);
		this.add(rangeBox);
		this.add(climbLabel);
		this.add(climbBox);
		this.add(autonLabel);
		this.add(autonBox);
		this.add(everyBotCBox);
		this.add(notesLabel);
		this.add(notesBox);
		
		this.setFocusable(true);
		//this.setEnabled(false);;
	}}
}

