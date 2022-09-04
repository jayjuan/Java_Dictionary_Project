package dictionary_test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class EditGUI {

	private JFrame frmEditMenu;
	private JTextField tF_word;
	private JTextField tF_synonym;
	private JTextArea tA_definition, tA_example;
	private JButton button_search, button_submit, button_delete, button_back;

	/*
	 * Create the application.
	 */
	public EditGUI() {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					frmEditMenu.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditMenu = new JFrame();
		frmEditMenu.setTitle("Edit Menu");
		frmEditMenu.setBounds(100, 100, 410, 450);
		frmEditMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmEditMenu.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 436, SpringLayout.WEST, frmEditMenu.getContentPane());
		frmEditMenu.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel label_word = new JLabel("Word:");
		frmEditMenu.getContentPane().add(label_word);
		
		tF_word = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, label_word, 3, SpringLayout.NORTH, tF_word);
		springLayout.putConstraint(SpringLayout.EAST, label_word, -6, SpringLayout.WEST, tF_word);
		springLayout.putConstraint(SpringLayout.WEST, tF_word, 126, SpringLayout.WEST, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tF_word, -10, SpringLayout.EAST, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, tF_word, 10, SpringLayout.SOUTH, panel);
		frmEditMenu.getContentPane().add(tF_word);
		tF_word.setColumns(10);
		
		button_search = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, button_search, 6, SpringLayout.SOUTH, tF_word);
		springLayout.putConstraint(SpringLayout.EAST, button_search, -107, SpringLayout.EAST, frmEditMenu.getContentPane());
		frmEditMenu.getContentPane().add(button_search);
		button_search.addActionListener(new ButtonListener());
		
		JLabel label_definition = new JLabel("Definition:");
		springLayout.putConstraint(SpringLayout.NORTH, label_definition, 41, SpringLayout.SOUTH, label_word);
		frmEditMenu.getContentPane().add(label_definition);
		
		tA_definition = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, button_search, -11, SpringLayout.NORTH, tA_definition);
		springLayout.putConstraint(SpringLayout.EAST, label_definition, -6, SpringLayout.WEST, tA_definition);
		springLayout.putConstraint(SpringLayout.NORTH, tA_definition, 0, SpringLayout.NORTH, label_definition);
		springLayout.putConstraint(SpringLayout.WEST, tA_definition, 0, SpringLayout.WEST, tF_word);
		springLayout.putConstraint(SpringLayout.EAST, tA_definition, -10, SpringLayout.EAST, frmEditMenu.getContentPane());
		frmEditMenu.getContentPane().add(tA_definition);
		
		JLabel label_synonym = new JLabel("Synonym:");
		frmEditMenu.getContentPane().add(label_synonym);
		
		tF_synonym = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, tA_definition, -12, SpringLayout.NORTH, tF_synonym);
		springLayout.putConstraint(SpringLayout.NORTH, label_synonym, 3, SpringLayout.NORTH, tF_synonym);
		springLayout.putConstraint(SpringLayout.EAST, label_synonym, -6, SpringLayout.WEST, tF_synonym);
		springLayout.putConstraint(SpringLayout.WEST, tF_synonym, 126, SpringLayout.WEST, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tF_synonym, -10, SpringLayout.EAST, frmEditMenu.getContentPane());
		frmEditMenu.getContentPane().add(tF_synonym);
		tF_synonym.setColumns(10);
		
		JLabel label_example = new JLabel("Example Sentence:");
		springLayout.putConstraint(SpringLayout.EAST, label_example, 0, SpringLayout.EAST, label_word);
		frmEditMenu.getContentPane().add(label_example);
		
		tA_example = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, label_example, 6, SpringLayout.NORTH, tA_example);
		springLayout.putConstraint(SpringLayout.SOUTH, tF_synonym, -14, SpringLayout.NORTH, tA_example);
		springLayout.putConstraint(SpringLayout.WEST, tA_example, 0, SpringLayout.WEST, tF_word);
		springLayout.putConstraint(SpringLayout.NORTH, tA_example, 240, SpringLayout.NORTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tA_example, -45, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tA_example, -10, SpringLayout.EAST, frmEditMenu.getContentPane());
		frmEditMenu.getContentPane().add(tA_example);
		
		button_back = new JButton("Back");
		springLayout.putConstraint(SpringLayout.SOUTH, button_back, -10, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_back, 0, SpringLayout.EAST, label_word);
		frmEditMenu.getContentPane().add(button_back);
		button_back.addActionListener(new ButtonListener());
		
		button_submit = new JButton("Submit");
		springLayout.putConstraint(SpringLayout.SOUTH, button_submit, -10, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_submit, 0, SpringLayout.EAST, tF_word);
		frmEditMenu.getContentPane().add(button_submit);
		button_submit.addActionListener(new ButtonListener());
		
		button_delete = new JButton("Delete");
		springLayout.putConstraint(SpringLayout.SOUTH, button_delete, -10, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_delete, -6, SpringLayout.WEST, button_submit);
		frmEditMenu.getContentPane().add(button_delete);
		button_delete.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener extends actionAbstract implements ActionListener
    {
		String word, definition, synonym, example, first_word;
		String [] arrOfStr;
		
		String line = "";
		
		
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
		 * Splits String by semicolon (";") and returns the first element only, which is the Word
		 */
		public String getWordOnly(String str)
		{
			arrOfStr = str.split(";", 0);
			first_word = arrOfStr[0];
			return first_word; 
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
		
    	public void actionPerformed(ActionEvent ae)
    	{
    		//For searching word to edit
    		if (ae.getSource() == button_search)
    		{
    			word = tF_word.getText();
    			String line = "";
    			boolean check_if_found = false;
    			
    			try
    			{
    				create_obj("output.txt", "temp.txt");			// Calls the create_obj function with create_obj(read file, write file) as arguments

    				// loop what will only stop once BufferedReader reaches end of text file
    				while((line=br.readLine())!=null)  
    				{  
    					if(getWordOnly(line).matches(".*\\b" + word + "\\b"))
    					{
    						arrOfStr = line.split(";", 4);			// Splits the matched line with semicolon (";")
    	        			tA_definition.setText(arrOfStr[1]);		// Sets text area for definition with arrOfStr[1]
    	        			tF_synonym.setText(arrOfStr[2]);		// Sets text area for definition with arrOfStr[2]
    	        			tA_example.setText(arrOfStr[3]);		// Sets text area for definition with arrOfStr[3]
    	        			
    	        			check_if_found = true;		// check_if_found turns true when word is found, which avoids error prompt in line 225
    					}
    				}
    				close_file();
    				
    				if(!check_if_found)
					{
						tA_definition.setText("");	//	text areas turns empty
	        			tF_synonym.setText("");		//	if searched word 
	        			tA_example.setText("");		//	is not found
	        			
	        			JOptionPane.showMessageDialog(null, "Word not found");
					}
	
    			}
    			catch(Exception e2)
        		{
        			JOptionPane.showMessageDialog(null, "An error occured while searching");
                    e2.getStackTrace();
        		}
    		
    		
    		}
    		
    		
    		/*
    		 * Submits edited word
    		 */
    		if (ae.getSource() == button_submit)
    		{
    			try
    			{
    				create_obj("output.txt", "temp.txt"); 		// Calls the create_obj function with create_obj(read file, write file) as arguments
    				
    				word = tF_word.getText();
    				definition = tA_definition.getText();
    				synonym = tF_synonym.getText();
    				example = tA_example.getText();
    				
    				if(!(word.isEmpty() || definition.isEmpty() || synonym.isEmpty() || example.isEmpty()))
                    {
    					while((line=br.readLine())!=null)  
        				{      						
        					if(getWordOnly(line).matches(".*\\b" + word + "\\b"))
        					{
        	        			line = word + ";" + definition +";"+ synonym + ";" + example; 	// concatenate the word, definition,  
        	        																			// synonym and example to line variable
        					}

	                        myWriter.write(line);		// writes concatenated line to temp.txt
	                        myWriter.write("\n");	                      
        				}
    					close_file();		// calls function to close the files
    					
    					Restore();			// writes contents of temp.txt to output.txt
        				
                        JOptionPane.showMessageDialog(null, "Word added to dictionary");
                    }
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Please complete the information");	// Prompts when one of the text field is empty
    				}
    			}
    			catch(Exception e2)
    			{
    				JOptionPane.showMessageDialog(null, "Form not complete! ");		// Prompts when an exception error occurs
                    e2.getStackTrace();
    			}
    			
    		}
    		
    		/*
    		 * Deletes searched word
    		 */
    		if (ae.getSource() == button_delete)
    		{
    			boolean delete_condition, delete_word_found = false;
    			
    			try
    			{
    				create_obj("output.txt", "temp.txt");	// Calls the create_obj function with create_obj(read file, write file) as arguments
    				
    				word = tF_word.getText();
    				
    				while((line=br.readLine())!=null)  
    				{  
    					delete_condition = true;
    					
    					if(getWordOnly(line).matches(".*\\b" + word + "\\b"))
    					{
    						delete_condition = false; 	// delete_condiiton turns false when word is found and if statement in line 311 wont run
    						delete_word_found = true;
    					}
 
    					if(delete_condition)
	                    {
	                        myWriter.write(line);
	                        myWriter.write("\n");	                      
	                    }   					    					
    					   

    				}
    				
    				if(delete_word_found)
    				{
    					JOptionPane.showMessageDialog(null, "Word Deleted.");
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Word Not Found.");
    				}
    				
    				
    				close_file();			// calls function to close the files
    				
    				Restore();				// writes contents of temp.txt to output.txt
    				
    				

    			}
    			catch(Exception e2)
    			{
    				JOptionPane.showMessageDialog(null, "Form not complete! ");
                    e2.getStackTrace();
    			}
    			
    		}
    		
    		if (ae.getSource() == button_back)
	    	{
    			close_frame(frmEditMenu); // closes current frame
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
}
