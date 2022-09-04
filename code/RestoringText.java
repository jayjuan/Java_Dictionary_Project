package dictionary_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RestoringText {
	private FileWriter myWriter;
	private FileReader myReader;
	private	BufferedReader br;  //creates a buffering character input stream  
	
	String line = "";
	
	public RestoringText()
	{
		Restore();
	}
	
	/*
	 * Creates object with first parameter to read text file and second parameter to write text file
	 */
	public void create_obj(String read, String write)
	{
		try
		{
			myReader = new FileReader(read);   	//reads the file 
			myWriter = new FileWriter(write);	// writes to file
				
			br = new BufferedReader(myReader);  //creates a buffering character input stream  
		}
		catch(IOException ae)
		{
			
		}
	}
	
	/*
	 * Closes all files
	 */
	public void close_file()
	{
		try
		{
			myReader.close();
			myWriter.close();
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("File Not Found!");
		}
	}
	
	/*
	 * Restores output.txt (original text file)
	 * by writing temp.txt (temporary text file)
	 * back to output.txt
	 */
	public void Restore()
	{
		write_text("temp.txt", "output.txt");
	}
	
	
	/*
	 * Writes all of temp.txt contents to output.txt
	 */
	public void write_text(String write, String read)
	{
		try
		{			
			create_obj(write, read);
			
			while(true)
			{			
				// loop what will only stop once BufferedReader reaches end of text file
				while((line=br.readLine())!=null)  
				{  
					myWriter.write(line);
					myWriter.write("\n");
				}		
			close_file();
			}
		}
		catch(IOException e)
		{
			
		}
	}
}
