package dictionary_test;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;

abstract class actionAbstract {
	FileReader myReader;
	FileWriter myWriter;
    BufferedReader br;
    
    ActionEvent ae;
    
    abstract void actionPerformed(ActionEvent ae);
  
    protected void close_frame(JFrame frame)
    {
    	frame.dispose();	// Closes the current frame
		new MainMenuGUI();	// and opens MainMenuGUI frame
    }
}
