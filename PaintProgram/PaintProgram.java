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
	private JPanel buttonPanel;
	private JButton squareButton;
	private JButton paintButton;
	private JButton red;
	private JButton blue;
	private JButton yellow;
	private Container setPad;
	final PadDraw sketchPad = new PadDraw();
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 500;

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
		buildButtonPanel();

		
		//Add Panel
		add(buttonPanel, BorderLayout.WEST);

		//Add Container with sketchPad
		setPad = paintFrame.getContentPane();
		setPad.add(sketchPad, BorderLayout.CENTER);


		setVisible(true);

	
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
		ImageIcon paintIcon = new ImageIcon("brush.png"); //Set the Icon file
		Image paintImg = paintIcon.getImage(); //Convert Icon file to Image
		Image newPaintImg = paintImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); //Resize Image
		paintIcon = new ImageIcon(newPaintImg); //Convert back to ImageIcon
		paintButton = new JButton();
		paintButton.setPreferredSize(new Dimension(10, 10)); //Resize JButton
		paintButton.setIcon(paintIcon); //Set the Icon 

		//Red Button
		ImageIcon redIcon = new ImageIcon("red.png");
		Image redImg = redIcon.getImage();
		Image newRedImg = redImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		redIcon = new ImageIcon(newRedImg);
		red = new JButton();
		red.setPreferredSize(new Dimension (20, 20));
		red.setIcon(redIcon);

		//Blue Color Button
		ImageIcon blueIcon = new ImageIcon("blue.png");
		Image blueImg = blueIcon.getImage();
		Image newBlueImg = blueImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		blueIcon = new ImageIcon(newBlueImg);
		blue = new JButton();
		blue.setPreferredSize(new Dimension (20, 20));
		blue.setIcon(blueIcon);

		//Yellow Color Button
		ImageIcon yellowIcon = new ImageIcon("yellow.png");
		Image yellowImg = yellowIcon.getImage();
		Image newYellowImg = yellowImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		yellowIcon = new ImageIcon(newYellowImg);
		yellow = new JButton();
		yellow.setPreferredSize(new Dimension (20, 20));
		yellow.setIcon(yellowIcon);

		//ActionListeners
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sketchPad.redPaint();
			}
		});

		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sketchPad.bluePaint();
			}
		});

		yellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sketchPad.yellowPaint();
			}
		});

	}

	

class PadDraw extends JComponent{
	Image pad;
	Graphics2D graphicsPad; //Make up the white sketchpad
	
	int currentX, currentY, startX, startY;
	//these are gonna hold our mouse coordinates

	//Now for the constructors
	public PadDraw(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				startX = e.getX();
				startY = e.getY();
			}
		});
		//if the mouse is pressed it sets the oldX & oldY
		//coordinates as the mouses x & y coordinates
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				currentX = e.getX();
				currentY = e.getY();
				if(graphicsPad != null)
				graphicsPad.drawLine(startX, startY, currentX, currentY);
				repaint();
				startX = currentX;
				startY = currentY;
			}

		});
		//while the mouse is dragged it sets currentX & currentY as the mouses x and y
		//then it draws a line at the coordinates
		//it repaints it and sets oldX and oldY as currentX and currentY
	}

	public void paintComponent(Graphics g){
		if(pad == null){
			pad = createImage(getSize().width, getSize().height);
			graphicsPad = (Graphics2D)pad.getGraphics();
			graphicsPad.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		}
		g.drawImage(pad, 0, 0, null);
	}
	//this is the painting bit
	//if it has nothing on it then
	//it creates an image the size of the window
	//sets the value of Graphics as the image
	//sets the rendering
	//runs the clear() method
	//then it draws the image



	public void redPaint(){
		graphicsPad.setPaint(Color.red);
		repaint();
	}
	
	public void bluePaint(){
		graphicsPad.setPaint(Color.blue);
		repaint();
	}
	
	public void yellowPaint(){
		graphicsPad.setPaint(Color.yellow);
		repaint();
	}
	

}

	 
	
	public static void main(String[] args)
	{
        new PaintProgram();
	}
}
