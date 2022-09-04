package dictionary_test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class CreateWordGUI {

	private JFrame frmEditMenu;
	private JTextField tF_word;
	private JTextField tF_synonym;
	private JTextArea tA_definition, tA_example;
	private JButton button_submit, button_back;

	//Create the application.
	public CreateWordGUI() {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditMenu = new JFrame();
		frmEditMenu.setTitle("Add Word");
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
		
		JLabel label_definition = new JLabel("Definition:");
		springLayout.putConstraint(SpringLayout.NORTH, label_definition, 24, SpringLayout.SOUTH, label_word);
		springLayout.putConstraint(SpringLayout.EAST, label_definition, 0, SpringLayout.EAST, label_word);
		frmEditMenu.getContentPane().add(label_definition);
		
		tA_definition = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, tA_definition, 21, SpringLayout.SOUTH, tF_word);
		springLayout.putConstraint(SpringLayout.WEST, tA_definition, 0, SpringLayout.WEST, tF_word);
		springLayout.putConstraint(SpringLayout.SOUTH, tA_definition, -226, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tA_definition, 0, SpringLayout.EAST, tF_word);
		frmEditMenu.getContentPane().add(tA_definition);
		
		JLabel label_synonym = new JLabel("Synonym:");
		springLayout.putConstraint(SpringLayout.SOUTH, label_synonym, -201, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_synonym, 0, SpringLayout.EAST, label_word);
		frmEditMenu.getContentPane().add(label_synonym);
		
		tF_synonym = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tF_synonym, 196, SpringLayout.NORTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tF_synonym, 0, SpringLayout.WEST, tF_word);
		springLayout.putConstraint(SpringLayout.EAST, tF_synonym, 0, SpringLayout.EAST, tF_word);
		frmEditMenu.getContentPane().add(tF_synonym);
		tF_synonym.setColumns(10);
		
		JLabel label_example = new JLabel("Example Sentence:");
		springLayout.putConstraint(SpringLayout.EAST, label_example, 0, SpringLayout.EAST, label_word);
		frmEditMenu.getContentPane().add(label_example);
		
		tA_example = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, tA_example, 223, SpringLayout.NORTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_example, 6, SpringLayout.NORTH, tA_example);
		springLayout.putConstraint(SpringLayout.WEST, tA_example, 0, SpringLayout.WEST, tF_word);
		springLayout.putConstraint(SpringLayout.EAST, tA_example, 0, SpringLayout.EAST, tF_word);
		frmEditMenu.getContentPane().add(tA_example);
		
		button_back = new JButton("Back");
		springLayout.putConstraint(SpringLayout.SOUTH, button_back, -10, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_back, 0, SpringLayout.EAST, label_word);
		frmEditMenu.getContentPane().add(button_back);
		button_back.addActionListener(new ButtonListener());
		
		button_submit = new JButton("Submit");
		springLayout.putConstraint(SpringLayout.SOUTH, tA_example, -22, SpringLayout.NORTH, button_submit);
		springLayout.putConstraint(SpringLayout.SOUTH, button_submit, -10, SpringLayout.SOUTH, frmEditMenu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_submit, 0, SpringLayout.EAST, tF_word);
		frmEditMenu.getContentPane().add(button_submit);
		button_submit.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener extends actionAbstract implements ActionListener
    {
		String word, definition, synonym, example;
		
    	public void actionPerformed(ActionEvent ae)
    	{
    		
    		//Submits edited word
    		if (ae.getSource() == button_submit)
	    	{
	    		try
	    		{
	    			// each text field contents is written to its respective variables
	    			word = tF_word.getText();
	    			definition = tA_definition.getText();
	    			synonym = tF_synonym.getText();
	    			example = tA_example.getText();
	    				
	    			if(!(word.isEmpty() || definition.isEmpty() || synonym.isEmpty() || example.isEmpty()))
	                   {
	                       String write = word + ";" + definition +";"+ synonym + ";" + example;	// assigns write variable with (word);(definition);(synonym);(example) format
	                        
	                       BufferedWriter output = new BufferedWriter(new FileWriter("output.txt",true));
	                       output.write(write);
	                       output.newLine();
	                       output.close();
	                       JOptionPane.showMessageDialog(null, "Word added to dictionary");
	                   }
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null, "Please complete the information");
	    			}
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
    }
}
