package primeThreads.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileProcessor {
    
	private BufferedReader br = null;
	private PrintWriter wt = null;
	/**
	 * Opens file
	 * @param fileName String
	 * @return bufferedReader BufferedReader
	 */
	public void openReader(String fileName){
		FileReader fileReader;
		try {
			fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			br = new BufferedReader(fileReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Closes Reader
	 * @param bufferedReader BufferedReader
	 */
	public void closeReader(){
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}  
	}
	
	/**
	 * gets line of input file
	 * @param bufferedReader BufferedReader
	 * @return str String
	 */
	public String getLine(){
			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		return str;
	}
	
	/**
	 * Splits a line into an array of words 
	 * @param bufferedReader BufferedReader 
	 * @return splittedLine array of Strings
	 */
	public String[] getStringArray(){
		String str = getLine();
		String[] splittedLine = str.split("\\s+");
		return splittedLine;
	}
	
	/**
	 * Opens writer 
	 * @param filename String
	 * @return writer PrintWriter
	 */
	public void openWriter(String filename){
		try {
			wt = new PrintWriter(filename, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Closes PrintWriter
	 * @param writer PrintWriter
	 */
	public void closeWriter(){
		 wt.close(); 
	}
	
	/**
	 * Writes a line in file
	 * @param writer PrintWriter
	 * @param str String
	 */
	public void writeLine(String str){
		wt.println(str);
	}
}
