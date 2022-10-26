package me.lowen.jacob.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeObject {

	public SerializeObject() {
		// TODO Auto-generated constructor stub
	}
	public static void Serialize(File path, Object obj) {
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	        objectOut.writeObject(obj);
	        objectOut.close();
	        System.out.println("The Object  was succesfully written to a file");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	 public static Object ReadObjectFromFile(File path) {
		 
	        try {
	        	if (!path.exists()) 
	        		return null;
	            FileInputStream fileIn = new FileInputStream(path);
	            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	 
	            Object obj = objectIn.readObject();
	 
	            System.out.println("The Object has been read from the file");
	            objectIn.close();
	            return obj;
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }

}
