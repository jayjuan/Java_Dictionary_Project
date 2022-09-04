package dictionary_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDisplay {

	public SortDisplay(){

		String inputFile = "output.txt";
		String outputFile = "temp.txt";

		try
		{
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			
			String inputLine;
			List<String> lineList = new ArrayList<String>();
			while ((inputLine = bufferedReader.readLine()) != null) {
				lineList.add(inputLine);	// reads "output.txt" and concatenates/merges each line to lineList array
			}
			fileReader.close();
	
			Collections.sort(lineList);	// sorts lineList array in ascending order
	
			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter out = new PrintWriter(fileWriter);
			for (String outputLine : lineList) {
				out.println(outputLine);		// writes sorted array onto "temp.txt"
			}
			out.flush();
			out.close();
			fileWriter.close();
			
			new RestoringText();	// prints "temp.txt" to "output.txt"
		}
		catch(Exception e)
		{
			
		}

	}
}