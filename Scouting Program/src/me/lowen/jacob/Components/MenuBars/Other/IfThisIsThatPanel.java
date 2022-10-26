package me.lowen.jacob.Components.MenuBars.Other;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IfThisIsThatPanel extends JPanel {


	private static final long serialVersionUID = 1372108469600497888L;

	public IfThisIsThatPanel() {
		this.add(new JLabel("If"));
		chooseBox cbox = new chooseBox();
		this.add(cbox);
		this.add(new JLabel("equals"));
		JTextField input = new JTextField();
		input.setColumns(5);
		this.add(input);
	}
	
	private class chooseBox extends JComboBox {
		private static final long serialVersionUID = 6307525559923773104L;
		private chooseBox() {
			super(new String[] {"Shoot Height", "ShootRange", "Climb Height", "Autonomous Rank", "Is Every Bot", "Extra Notes"});
		
		
	}}

	

}
