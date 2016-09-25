package primeThreads.util;

import java.io.IOException;
import java.io.Writer;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;

public class Logger{
    private static int debugLevel;

    public static void setDebugValue (int levelIn) {
	    debugLevel = levelIn;
    }
    
    public static void writeMessage (String message, int levelIn ) {
	    if (levelIn == debugLevel)
	        System.out.println(message);
    }
    
    //http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
    public static void writeOutput(String message, int levelIn){
        if(levelIn == debugLevel){
            try(Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("log.txt"), "utf-8"))){
                writer.write(message);
            }catch(IOException e ){
                System.out.println("Exception thrown :" + e);
            }
        }
    }

    public String toString(){
        return "Debug Level is " + debugLevel;
    }
}
