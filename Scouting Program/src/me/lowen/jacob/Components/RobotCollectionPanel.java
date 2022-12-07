package me.lowen.jacob.Components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.lowen.jacob.TestingMain;
import me.lowen.jacob.Components.DebugThings.ConsoleFrame;
import me.lowen.jacob.Utils.GeneralUtilities;
import me.lowen.jacob.Utils.SerializeObject;

public class RobotCollectionPanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = -1794043423055467965L;
	
	private JPanel theHostPanel;
	
	int teamNumber;
	JLabel teamLabel;
	JLabel heightLabel;
	JLabel rangeLabel;
	JLabel climbLabel;
	JLabel autonLabel;
	JLabel notesLabel;
	
	JTextArea heightBox;
	JTextArea rangeBox;
	JTextArea climbBox;
	JTextArea autonBox;
	JTextArea notesBox;
	
	JCheckBox everyBotCBox;
	public RobotCollectionPanel(JPanel hostPanel, int TeamNumber, Color TeamColor) {
		teamNumber = TeamNumber;
		 try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		theHostPanel = hostPanel;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		teamLabel = new JLabel("Team " + TeamNumber);
		teamLabel.setToolTipText(String.valueOf(TeamNumber));
		teamLabel.setForeground(TeamColor);
		
		heightLabel = new JLabel("Shoot Height:");
		heightBox = new JTextArea();
		heightBox.setToolTipText("heightBox");
		heightBox.addKeyListener(this);
		heightBox.setColumns(5);
		heightBox.addKeyListener(this);
		
		rangeLabel = new JLabel("Shoot Range");
		rangeBox = new JTextArea();
		rangeBox.setToolTipText("rangeBox");
		rangeBox.setColumns(5);
		rangeBox.addKeyListener(this);
		
		climbLabel = new JLabel("Climb Height");
		climbBox = new JTextArea();
		climbBox.setToolTipText("climbBox");
		climbBox.setColumns(5);
		climbBox.addKeyListener(this);
		
		autonLabel = new JLabel("Autonomous Rank");
		autonBox = new JTextArea();
		autonBox.setToolTipText("autonBox");
		autonBox.setColumns(5);
		autonBox.addKeyListener(this);
		
		notesLabel = new JLabel("Extra Notes");
		notesBox = new JTextArea();
		notesBox.setToolTipText("notesBox");
		notesBox.setColumns(16);
		notesBox.addKeyListener(this);
		
		everyBotCBox = new JCheckBox("Every Bot?");
		everyBotCBox.setToolTipText("everyBotCBox");
		everyBotCBox.addKeyListener(this);
		
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
		this.addKeyListener(this);
	}
	
	public void save(Map<Integer, Robot> storage) {
		ConsoleFrame.output("Attempting to save data...", Color.WHITE);
		int teamNum = teamNumber;
		String shootHeight = heightBox.getText();
		String shootRange = rangeBox.getText();
		
		String climbHeight = climbBox.getText();
		String autonRank = autonBox.getText();
		boolean isEveryBot = everyBotCBox.isSelected();
		String extraNotes = notesBox.getText();
		Robot robot = new Robot(teamNum, shootHeight, shootRange, climbHeight, autonRank, isEveryBot, extraNotes);
		String tmpdir = System.getProperty("java.io.tmpdir");
		storage.put(teamNum, robot);
		Object readObj = SerializeObject.ReadObjectFromFile(new File(tmpdir + System.getProperty("file.separator") + "storedrobots.txt"));
		if (readObj == null) {
			ConsoleFrame.output("This is the first time you're saving data, making new file...", Color.WHITE);
		SerializeObject.Serialize(new File(tmpdir + System.getProperty("file.separator") + "storedrobots.txt"), storage);
		} else {
			System.out.println("not null");
			ConsoleFrame.output("You already have data saved, adding new data to old...", Color.WHITE);
			storage.putAll((Map<Integer, Robot>) readObj);
			SerializeObject.Serialize(new File(tmpdir + System.getProperty("file.separator") + "storedrobots.txt"), storage);
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	//This section set each different box to a hotkey that can be pressed to focus it. This is done to make recording data faster
		if ('!' == e.getKeyChar())  {
			e.consume();
			heightBox.requestFocus();
		}
		if ('@' == e.getKeyChar()) { 
			e.consume();
			rangeBox.requestFocus();
		}
		if ('#' == e.getKeyChar()) { 
			e.consume();
			climbBox.requestFocus();
		}
		if ('$' == e.getKeyChar()) {
			e.consume();
			autonBox.requestFocus();
		}
		if ('%' == e.getKeyChar()) {
			e.consume();
			everyBotCBox.requestFocus();
		}
		if ('^' == e.getKeyChar()) {
			e.consume();
			notesBox.requestFocus();
		}
		if ('S' == e.getKeyChar()) {
			e.consume();
			/*Robot bot = new Robot(1, "Hello","Hello" , 2,"Hello" , true, "HEL ");
			Robot bot2 = new Robot(12, "Hello","Hello" , 2,"Hello" , true, "Hello");
			Robot bot3 = new Robot(123, "Hello","Hello" , 2,"Hello" , true, "Hello");
			Map<Integer, Robot> map = new HashMap<Integer, Robot>();
			map.put(1, bot);
			map.put(12, bot2);
			map.put(123, bot3); */
			//save(GeneralUtilities.getValuesFromTextBox(TestingMain.panel));
			save(GeneralUtilities.getValuesFromTextBox(theHostPanel));
			
		}
		
	}

}
