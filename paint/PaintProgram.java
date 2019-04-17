/*********************
Project
Due Date:
Names: Michael Fontanilla, Ryan Hays
*********************/

import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.*;
import javax.imageio.*;

public class PaintProgram extends JFrame
{
	private JPanel buttonPanel;
	private JPanel drawPanel;
	private JButton squareButton;
	private JButton paintButton;
	private JButton red;
	private JButton blue;
	private JButton yellow;
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 500;

	private int currentX = 0;
	private int currentY = 0;
	private int width = 0;
	private int height = 0;

	public PaintProgram()
	{
		setTitle("Paint Program");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//Builds panel with icons for paint actions
		buildButtonPanel();

		//Primary Draw panel
		drawPanel = new JPanel();
		
		//Add Panels 
		add(buttonPanel, BorderLayout.WEST);
		add(drawPanel, BorderLayout.CENTER);

		setVisible(true);

		// Add a mouse listener and a mouse motion listener.
		addMouseListener(new squareMouseListener());
		addMouseMotionListener(new squareMouseMotionListener());
	}

	

	private void buildButtonPanel()
	{
		buildButtons();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1));
		buttonPanel.add(squareButton);
		buttonPanel.add(paintButton);
		buttonPanel.add(red);
		buttonPanel.add(blue);
		buttonPanel.add(yellow);
	}

	private void buildButtons()
	{
		//Actions for Square Drawing
		ImageIcon squareTool = new ImageIcon("square.png");
		Image squareImg = squareTool.getImage();
		Image newSquareImg = squareImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		squareTool = new ImageIcon(newSquareImg);
		squareButton = new JButton();
		squareButton.setPreferredSize(new Dimension (10, 10));
		squareButton.setIcon(squareTool);

		//Paint Brush Button
		ImageIcon paintBrush = new ImageIcon("brush.png"); //Set the Icon file
		Image paintImg = paintBrush.getImage(); //Convert Icon file to Image
		Image newPaintImg = paintImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); //Resize Image
		paintBrush = new ImageIcon(newPaintImg); //Convert back to ImageIcon
		paintButton = new JButton();
		paintButton.setPreferredSize(new Dimension(10, 10)); //Resize JButton
		paintButton.setIcon(paintBrush); //Set the Icon 

		//Red Button
		ImageIcon redColor = new ImageIcon("red.png");
		Image redImg = redColor.getImage();
		Image newRedImg = redImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		redColor = new ImageIcon(newRedImg);
		red = new JButton();
		red.setPreferredSize(new Dimension (20, 20));
		red.setIcon(redColor);

		//Blue Color Button
		ImageIcon blueColor = new ImageIcon("blue.png");
		Image blueImg = blueColor.getImage();
		Image newBlueImg = blueImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		blueColor = new ImageIcon(newBlueImg);
		blue = new JButton();
		blue.setPreferredSize(new Dimension (20, 20));
		blue.setIcon(blueColor);

		//Yellow Color Button
		ImageIcon yellowColor = new ImageIcon("yellow.png");
		Image yellowImg = yellowColor.getImage();
		Image newYellowImg = yellowImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		yellowColor = new ImageIcon(newYellowImg);
		yellow = new JButton();
		yellow.setPreferredSize(new Dimension (20, 20));
		yellow.setIcon(yellowColor);


	}


	
		/**
		  paint method
		  @param g The applet's Graphics object.
	   */
   
	   public void paint(Graphics g)
	   {
		  // Call the superclass's paint method.
		  super.paint(g);
      
		  // Draw a rectangle.
		  g.drawRect(currentX, currentY, width, height);
	   }

	  
	   /**
		  Mouse listener class
	   */

	   private class squareMouseListener implements MouseListener
	   {
		  public void mousePressed(MouseEvent e)
		  {
			 // Get the mouse cursor coordinates.
			 currentX = e.getX();
			 currentY = e.getY();
		  }

		  //
		  // The following methods are unused, but still
		  // required by the MouseListener interface.
		  //

		  public void mouseClicked(MouseEvent e)
		  {
			repaint();
		  }

		  public void mouseReleased(MouseEvent e)
		  {
		  }

		  public void mouseEntered(MouseEvent e)
		  {
		  }

		  public void mouseExited(MouseEvent e)
		  {
		  }
	   }

	   private class squareMouseMotionListener implements MouseMotionListener
	   {
		  public void mouseDragged(MouseEvent e)
		  {
			 // Calculate the size of the rectangle.
			 width = e.getX() - currentX;
			 height = e.getY() - currentY;
         
			 // Repaint the window.
			 repaint();
		  }
      
		  /**
			 The mouseMoved method is unused, but still
			 required by the MouseMotionListener interface.
		  */
      
		  public void mouseMoved(MouseEvent e)
		  {
		  }
	   }
	

	   
   
 
	public static void main(String[] args)
	{
        new PaintProgram();
	}
  
}