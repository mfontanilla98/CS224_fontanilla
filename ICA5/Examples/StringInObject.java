import java.awt.*;
import javax.swing.*;
import javax.swing.*;

public class StringInObject extends JFrame{
	
	StringInObject()
	{
		setTitle("Stop Sign");	
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
	}
	
	public void paint(Graphics g){

		int[] xCoords = {60, 100, 140, 140, 100, 60, 20, 20 };
		int[] yCoords = {20, 20, 60, 100, 140, 140, 100, 60 };
		g.setColor(Color.red);
		// Draw the polygon. 
		g.fillPolygon(xCoords, yCoords, 8);
		// Set the drawing color to white. 
		g.setColor(Color.white);
		// Set the font and draw "STOP".
		g.setFont(new Font("SansSerif", Font.BOLD, 35)); 
		g.drawString("STOP", 35, 95);

		g.fillOval(200, 200, 100, 100);	
			g.setColor(Color.black);
			g.setFont(new Font("SansSerif", Font.BOLD, 25)); 
			g.drawString("STOP", 225, 275);

	}
	
	public static void main(String[] args){
		new StringInObject();
	}	
}




