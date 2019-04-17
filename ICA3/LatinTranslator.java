/******************************
Michael Fontanilla
ICA3: Latin Translator
2/15/2019
******************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class LatinTranslator extends JFrame
{
   private JPanel panel;             
   private JLabel messageLabel;      
   private JTextField translateTextField; 
   private JButton sinisterButton;       // Word Buttons
   private JButton dexterButton;
   private JButton mediumButton;
   private final int WINDOW_WIDTH = 310;  // Window width
   private final int WINDOW_HEIGHT = 100; // Window height

  

   public LatinTranslator()
   {
 
      setTitle("Latin Translator");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buildPanel();
      add(panel);
      setVisible(true);
   }


	//Create information panel with buttons 
   private void buildPanel()
   {
      messageLabel = new JLabel("Click a button for its translation");
      
      translateTextField = new JTextField(10);
      
      sinisterButton = new JButton("SINISTER");
	  dexterButton = new JButton("DEXTER");
	  mediumButton = new JButton("MEDIUM");

	  //Action Listner
	  sinisterButton.addActionListener(new ButtonListener());
	  dexterButton.addActionListener(new ButtonListener());
	  mediumButton.addActionListener(new ButtonListener());

      
      // panel references JPanel to add buttons to
      panel = new JPanel();
      
      //Add to buttons to panel
      panel.add(messageLabel);
      panel.add(translateTextField);
      panel.add(sinisterButton);
	  panel.add(dexterButton);
	  panel.add(mediumButton);
   }

   private class ButtonListener implements ActionListener
   {
   	   public void actionPerformed(ActionEvent e)
	   {
		   String result;

	   	   if(e.getSource() == sinisterButton)
		   {
				JOptionPane.showMessageDialog(null, "Left");
		   }
		   else if(e.getSource() == dexterButton)
		   {
		   	   JOptionPane.showMessageDialog(null, "Right");
		   }
		   else if(e.getSource() == mediumButton)
		   {
		   	   JOptionPane.showMessageDialog(null, "Center");
		   }
	   }
   }
   
   
   public static void main(String[] args)
   {
      new LatinTranslator();
   }
}