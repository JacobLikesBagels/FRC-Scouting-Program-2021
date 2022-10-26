package me.lowen.jacob.Components.MenuBars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class HelpMenu extends JMenu {

	private static final long serialVersionUID = 4L;

	public HelpMenu() {
		super("Help");
		
		this.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem preferences = new JMenuItem("Preferences", KeyEvent.VK_P);
		preferences.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    		
		           // new DefaultPathsGUI().sourceAndOutputGUI("Change Your Default File Paths");
		    }
		});
		add(preferences);
		
		JMenuItem About = new JMenuItem("About", KeyEvent.VK_A);
		About.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		            System.exit(0);
		    }
		});
		add(About);
	}



}