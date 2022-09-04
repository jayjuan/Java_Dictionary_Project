package dictionary_test;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;

public class MainMenuGUI implements ActionListener{

    private JFrame frmDictionaryMainMenu;
    private JButton createButton, searchButton, editButton, exitButton, displayButton;


    //Launch the application.
    public static void main(String[] args) 
    {
        new MainMenuGUI();
    }

    public MainMenuGUI() 
    {
        initialize();
    }

    //Initialize the contents of the frame.
    private void initialize() {
        frmDictionaryMainMenu = new JFrame();
        frmDictionaryMainMenu.setTitle("Dictionary Menu");
        frmDictionaryMainMenu.setBounds(100, 100, 410, 450);
        frmDictionaryMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        frmDictionaryMainMenu.getContentPane().setLayout(springLayout);
        frmDictionaryMainMenu.setVisible(true);
        
        JPanel panel = new JPanel();
        springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frmDictionaryMainMenu.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frmDictionaryMainMenu.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, panel, 403, SpringLayout.NORTH, frmDictionaryMainMenu.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, panel, 386, SpringLayout.WEST, frmDictionaryMainMenu.getContentPane());
        frmDictionaryMainMenu.getContentPane().add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        
        JLabel label_title = new JLabel("Word Dictionary");
        label_title.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
        panel_1.add(label_title);
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(null);
        
        createButton = new JButton("Add Word");
        createButton.setBounds(125, 42, 126, 26);
        panel_2.add(createButton);
        createButton.addActionListener(this);
        
        searchButton = new JButton("Search Word");
        searchButton.setBounds(125, 105, 127, 26);
        panel_2.add(searchButton);
        searchButton.addActionListener(this);
        
        editButton = new JButton("Edit Word");
        editButton.setBounds(125, 168, 127, 26);
        panel_2.add(editButton);
        editButton.addActionListener(this);
        
        displayButton = new JButton("Display Words");
        displayButton.setBounds(125, 231, 127, 26);
        panel_2.add(displayButton);
        displayButton.addActionListener(this);
        
        exitButton = new JButton("Exit");
        exitButton.setForeground(Color.RED);
        exitButton.setBounds(125, 294, 127, 26);
        panel_2.add(exitButton);
        exitButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
    	if (ae.getSource() == createButton)
		{
    		new CreateWordGUI();
    		frmDictionaryMainMenu.dispose(); // closes the frame
		}
    	
    	if (ae.getSource() == searchButton)
		{
    		new SearchGUI();
    		frmDictionaryMainMenu.dispose();
		}
    	
    	if (ae.getSource() == editButton)
		{
    		new EditGUI();
    		frmDictionaryMainMenu.dispose();
		}

        if (ae.getSource() == displayButton)
        {
        	new DisplayGUI();
            frmDictionaryMainMenu.dispose();
        }
        
        if (ae.getSource() == exitButton)
        {
        	System.exit(0);
        }
    }

}