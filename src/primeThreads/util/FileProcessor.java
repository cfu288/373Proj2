package primeThreads.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileProcessor {
    
	/**
	 * Opens file
	 * @param fileName String
	 * @return bufferedReader BufferedReader
	 */
	public BufferedReader openReader(String fileName){
		FileReader fileReader;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			bufferedReader = new BufferedReader(fileReader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return bufferedReader;
	}
	
	/**
	 * Closes Reader
	 * @param bufferedReader BufferedReader
	 */
	public void closeReader(BufferedReader bufferedReader){
		try {
			bufferedReader.close();
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
	public String getLine(BufferedReader bufferedReader){
			String str = null;
			try {
				str = bufferedReader.readLine();
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
	public String[] getStringArray(BufferedReader bufferedReader){
		String str = getLine(bufferedReader);
		String[] splittedLine = str.split(" ");
		return splittedLine;
	}
	
	/**
	 * Opens writer 
	 * @param filename String
	 * @return writer PrintWriter
	 */
	public PrintWriter openWriter(String filename){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filename, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return writer;
	}
	
	/**
	 * Closes PrintWriter
	 * @param writer PrintWriter
	 */
	public void closeWriter(PrintWriter writer){
		 writer.close(); 
	}
	
	/**
	 * Writes a line in file
	 * @param writer PrintWriter
	 * @param str String
	 */
	public void writeLine(PrintWriter writer, String str){
		writer.println(str);
	}
}
