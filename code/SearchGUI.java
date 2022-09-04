package dictionary_test;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JPanel;

public class SearchGUI {

	private JFrame frmSearchMenu;
	private JTextField textField;
	private JButton buttonBack;
	private JLabel labelTitle;
	private JButton buttonSearch;
	private JButton buttonClear;
	private JTextArea displayField;
		
	//Create the application.
	public SearchGUI() {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
				frmSearchMenu.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchMenu = new JFrame();
		frmSearchMenu.setTitle("Search Menu");
		frmSearchMenu.setBounds(100, 100, 660, 350);
		frmSearchMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearchMenu.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 626, 393);
		frmSearchMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("find your word");
		textField.setText("Enter your word");
		textField.setColumns(10);
		textField.setBounds(65, 31, 467, 22);
		panel.add(textField);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(textField.getText().equals("Enter your word"))
				{
					textField.setText("");
					textField.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {

				if(textField.getText().equals(""))
				{
					textField.setText("Enter your word");
					textField.setForeground(new Color(128,128,128));
				}
			}
		});
		
		labelTitle = new JLabel("DICTIONARY SEARCH");
		labelTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTitle.setBounds(225, 0, 187, 19);
		panel.add(labelTitle);
		
		displayField = new JTextArea();
		displayField.setEditable(false);
		displayField.setBounds(65, 70, 467, 192);
		panel.add(displayField);
		
		buttonClear = new JButton("Clear");
		buttonClear.setBounds(542, 72, 76, 21);
		panel.add(buttonClear);
		buttonClear.addActionListener(new ButtonListener());
		
		buttonSearch = new JButton("Search");
		buttonSearch.setBounds(542, 35, 76, 21);
		panel.add(buttonSearch);
		buttonSearch.addActionListener(new ButtonListener());
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(0, 270, 70, 21);
		panel.add(buttonBack);
		buttonBack.addActionListener(new ButtonListener());
		
		frmSearchMenu.setVisible(true);
	}


	private class ButtonListener extends actionAbstract implements ActionListener{
		private String word, line = "";
		String [] arrOfStr;
		
		public void actionPerformed(ActionEvent ae) {
			// String comStr = e.getActionCommand();
			
			if(ae.getSource() == buttonSearch)
			{
				word = textField.getText();
				displayField.setText("");
				boolean check_if_found = false;
				
				try
				{
					myReader = new FileReader("output.txt");
					br = new BufferedReader(myReader);
	
					// loop what will only stop once BufferedReader reaches end of text file
					while((line=br.readLine())!=null)  
					{  
						if(getWordOnly(line).matches(".*\\b" + word + "\\b"))
						{
							arrOfStr = line.split(";", 4);		// Splits the matched line with semicolon (";")
							
							// set text area with the word, definition, synonym and example sentence
							// by concatenating each element of arrOfStr to the text area
							displayField.setText(displayField.getText().concat("Word : " + arrOfStr[0] + "\n"));
							displayField.setText(displayField.getText().concat("Definition: " + arrOfStr[1] + "\n"));
							displayField.setText(displayField.getText().concat("Synonym : " + arrOfStr[2] + "\n\n"));
							displayField.setText(displayField.getText().concat("Example Sentence: \n" + arrOfStr[3] + "\n"));
		        			
		        			check_if_found = true;	// check_if_found turns true when word is found, which avoids error prompt in line 163
						}
					}
					
					myReader.close();
					br.close();
					
					if(!check_if_found)
					{
						JOptionPane.showMessageDialog(null, "Word not found");
						displayField.setText("");
					}
	
				}
				catch(Exception e2)
	    		{
	    			JOptionPane.showMessageDialog(null, "An error occured while searching");
	                e2.getStackTrace();
	    		}   
			}
			
			if(ae.getSource() == buttonClear)
			{
				displayField.setText("");    
			}
			
			
			if(ae.getSource() == buttonBack)
			{
				close_frame(frmSearchMenu); // closes current frame
			}
		}
		
		
		public String getWordOnly(String str)
		{
			arrOfStr = str.split(";", 0);
			return arrOfStr[0]; 
		}
		
	}
	}

