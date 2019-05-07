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
	private JFrame paintFrame;
	private JPanel toolPanel;
	private JPanel drawPanel;
	private JButton squareButton;
	private JButton paintButton;
	private JButton redButton;
	private JButton blueButton;
	private JButton yellowButton;
	private JComboBox lineTool;
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 500;
	private boolean boxButtonEnabled = false;
	private boolean paintButtonEnabled = false;
	private int currentX = 0;
	private int currentY = 0;
	private int width = 0;
	private int height = 0;

	public PaintProgram()
	{
		paintFrame = new JFrame("Paint Program");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		//Builds panel with icons for paint actions
		buildtoolPanel();
		drawPanel = new JPanel();
		
		//Add Panel
		add(toolPanel, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);


		setVisible(true);

		// Add a mouse listener and a mouse motion listener.
        addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
	}

	

	private void buildtoolPanel()
	{
		buildTools();
		
		toolPanel = new JPanel();
		toolPanel.setLayout(new GridLayout(1, 6));
		toolPanel.add(squareButton);
		toolPanel.add(paintButton);
		toolPanel.add(lineTool);
		toolPanel.add(redButton);
		toolPanel.add(blueButton);
		toolPanel.add(yellowButton);
		toolPanel.add(lineTool);
	}

	private void buildTools()
	{
		//Actions for Square Drawing
		ImageIcon squareTool = new ImageIcon("square.png");
		Image squareImg = squareTool.getImage();
		Image newSquareImg = squareImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		squareTool = new ImageIcon(newSquareImg);
		squareButton = new JButton();
		squareButton.setPreferredSize(new Dimension (10, 10));
		squareButton.setIcon(squareTool);

		squareButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boxButtonEnabled = true;
			}
		});


		//Paint Brush Button
		ImageIcon paintIcon = new ImageIcon("brush.png"); //Set the Icon file
		Image paintImg = paintIcon.getImage(); //Convert Icon file to Image
		Image newPaintImg = paintImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); //Resize Image
		paintIcon = new ImageIcon(newPaintImg); //Convert back to ImageIcon
		paintButton = new JButton();
		paintButton.setPreferredSize(new Dimension(10, 10)); //Resize JButton
		paintButton.setIcon(paintIcon); //Set the Icon 

		paintButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				paintButtonEnabled = true;
			}
		});

		//Red Button
		ImageIcon redIcon = new ImageIcon("red.png");
		Image redImg = redIcon.getImage();
		Image newRedImg = redImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		redIcon = new ImageIcon(newRedImg);
		redButton = new JButton();
		redButton.setPreferredSize(new Dimension (20, 20));
		redButton.setIcon(redIcon);

		//Blue Color Button
		ImageIcon blueIcon = new ImageIcon("blue.png");
		Image blueImg = blueIcon.getImage();
		Image newBlueImg = blueImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		blueIcon = new ImageIcon(newBlueImg);
		blueButton = new JButton();
		blueButton.setPreferredSize(new Dimension (20, 20));
		blueButton.setIcon(blueIcon);

		//Yellow Color Button
		ImageIcon yellowIcon = new ImageIcon("yellow.png");
		Image yellowImg = yellowIcon.getImage();
		Image newYellowImg = yellowImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		yellowIcon = new ImageIcon(newYellowImg);
		yellowButton = new JButton();
		yellowButton.setPreferredSize(new Dimension (20, 20));
		yellowButton.setIcon(yellowIcon);

		//Line Thickness

		//ThinLine
		ImageIcon thinIcon = new ImageIcon("thinline.png");
		Image thinImg = thinIcon.getImage();
		Image newthinImg = thinImg.getScaledInstance(50, 20, java.awt.Image.SCALE_SMOOTH);
		thinIcon = new ImageIcon(newthinImg);

		//Mid thickness
		ImageIcon midIcon = new ImageIcon("midline.png");
		Image midImg = midIcon.getImage();
		Image newmidImg = midImg.getScaledInstance(50, 20, java.awt.Image.SCALE_SMOOTH);
		midIcon = new ImageIcon(newmidImg);

		//Thickest Line
		ImageIcon thiccIcon = new ImageIcon("thiccline.png");
		Image thiccImg = thiccIcon.getImage();
		Image newthiccImg = thiccImg.getScaledInstance(50, 20, java.awt.Image.SCALE_SMOOTH);
		thiccIcon = new ImageIcon(newthiccImg);
		

		Object[] lineThiccness ={thinIcon, midIcon, thiccIcon};
		lineTool = new JComboBox(lineThiccness);
	}


		


	/**
      Mouse listener class
   */

   private class MyMouseListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {

         currentX = e.getX();
         currentY = e.getY();
      }

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
	

	public void paint(Graphics g)
   {

      super.paint(g);
      
      // Draw a rectangle.
      g.drawRect(currentX, currentY, width, height);
   }

	private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
		 if (boxButtonEnabled){
         // Calculate the size of the rectangle.
         width = e.getX() - currentX;
         height = e.getY() - currentY;
         
         // Repaint the window.
         repaint();
		 }
      }
     
      
      public void mouseMoved(MouseEvent e)
      {
      }
   }

	public static void main(String[] args)
	{
        new PaintProgram();
	}
}
