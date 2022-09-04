package dictionary_test; 

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.border.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



import javax.swing.ScrollPaneConstants;

public class DisplayGUI {
    
    private JFrame frmDisplayMenu;
    private JTextArea output;
    private JScrollPane scroll;
    private JButton back_button;
    
    private FileReader myReader;
    private BufferedReader br;
    
    private String line;
    private String[] arrOfStr = new String[4];
    private int counter = 1;
    
    private JPanel panel;

    public DisplayGUI(){
    	new SortDisplay();
    	EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					frmDisplayMenu.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
        initialize();
    }

    /**
     * Initialize the contents of the frmDisplayMenu.
     */
    private void initialize() {
    	frmDisplayMenu = new JFrame();
    	frmDisplayMenu.setTitle("Word Display");
    	frmDisplayMenu.setBounds(100, 100, 1030,625);
    	frmDisplayMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDisplayMenu.getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setBounds(10, 10, 996, 568);
        frmDisplayMenu.getContentPane().add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panelTop = new JPanel();
        panel.add(panelTop, BorderLayout.NORTH);
        
        JLabel page_title = new JLabel("DISPLAY");
        page_title.setFont(new Font("Tahoma", Font.BOLD, 25));
        panelTop.add(page_title);
        
        JPanel panelBottom = new JPanel();
        panel.add(panelBottom, BorderLayout.SOUTH);
        
        JPanel panelCenter = new JPanel();
        panelCenter.setFont(new Font("Verdana", Font.PLAIN, 58));
        panelCenter.setBorder(new TitledBorder(new EtchedBorder(), "List Of All Words :"));
        panel.add(panelCenter, BorderLayout.CENTER);
        
        scroll = new JScrollPane((Component) null);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelCenter.add(scroll);
        
        back_button = new JButton("Back");
        panelBottom.add(back_button);
        back_button.addActionListener(new ButtonListener());
        
        output = new JTextArea(25, 75);
        output.setEditable(false);
        scroll.setViewportView(output);
        frmDisplayMenu.setVisible(true);
        
        getAll();
        
        frmDisplayMenu.setVisible(true);
    }
    
    
    /*
     * Loops through entire dictionary text file
     * line by line and prints on text area
     */
    public void getAll()
    {
        try
        {
            myReader = new FileReader("output.txt");
            br = new BufferedReader(myReader);
            
            while((line=br.readLine())!=null)  
            {          
                
                print_on_txtarea(line);
            }

        }
        catch(IOException e)
        {
            
        }
    }
    
    public void print_on_txtarea(String str)
    {
        arrOfStr = str.split(";", 4);
        
        output.setText(output.getText().concat("\nEntry : " + counter));
        output.setText(output.getText().concat("\nWord : " + arrOfStr[0]));			// concatenates each of the elements of arrOfStr to text area
        output.setText(output.getText().concat("\nDefinition : " + arrOfStr[1]));
        output.setText(output.getText().concat("\nSynonym : " + arrOfStr[2]));
        output.setText(output.getText().concat("\nExample in a sentence : " + arrOfStr[3]));
        output.setText(output.getText().concat("\n"));
        counter += 1; 		// counter to display number of entries

    }
    
    private class ButtonListener extends actionAbstract implements ActionListener{
    
	    public void actionPerformed(ActionEvent ae){
	        
	        if (ae.getSource() == back_button)
	        {
	            close_frame(frmDisplayMenu);
	        }
	    }
  	}
        
}

