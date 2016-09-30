package primeThreads.util;

import java.io.IOException;
import java.io.Writer;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Logger{
    private static int debugLevel;
    private static BufferedWriter writer = null;
    
    /**
    * Constructor
    */
    public Logger(){
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter("log.txt");
            writer = new BufferedWriter(fileWriter );
        }catch(IOException e){
            System.out.println("Exception thrown :" + e);
            System.exit(0);
        }
    }
    
    /**
    * Sets debug value
    */
    public static void setDebugValue (int levelIn) {
	    debugLevel = levelIn;
    }
    
    /**
    * Prints to screen and saves to log file if matches debug value
    */
    public static void writeMessage (String message, int levelIn) {
	   if (levelIn == debugLevel){
	        System.out.println(message);
		    writeOutput(message);
        }
    }
    
    /**
    * Closes the open file
    */
    public static void close(){
       	try{            
            writer.close();
    	}catch(IOException e){
            System.out.println("Exception thrown :" + e);
            System.exit(0);
        }
    }
    
    //http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
    /**
    * Writes to file
    */
    public static void writeOutput(String message){
       	try{            
            writer.write(message);
            writer.flush();
    	}catch(IOException e){
            System.out.println("Exception thrown :" + e);
            System.exit(0);
        }
    }

    /**
    * Logger toString
    */
    public String toString(){
        return "Debug Level is " + debugLevel;
    }
}
