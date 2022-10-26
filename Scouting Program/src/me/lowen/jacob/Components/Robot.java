package me.lowen.jacob.Components;

import java.io.Serializable;

public class Robot implements Serializable{

	private static final long serialVersionUID = 7829108401263012458L;
	
	public int teamNumber;
	public String shootHeight;
	public String shootRange;
	public String climbHeight;
	public String autonMeasure;
	public boolean isEveryBot;
	public String extraNotes;
	
	public Robot(int TeamNumber, String ShootHeight, String ShootRange, String ClimbHeight, String AutonMeasure, boolean IsEveryBot, String ExtraNotes) {
		teamNumber = TeamNumber;
		shootHeight = ShootHeight;
		shootRange = ShootRange;
		climbHeight = ClimbHeight;
		autonMeasure = AutonMeasure;
		isEveryBot = IsEveryBot;
		extraNotes = ExtraNotes;
	}
}
