import java.awt.*;
import javax.swing.*;
import javax.swing.*;
public class Circle extends JFrame{
	
	Circle()
	{
		setTitle("JavaTutorial.net");	
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawOval(200, 200, 100, 100);	
		int xValues[] = {25, 145, 25, 145, 25};
	    int yValues[] = {25, 25, 145, 145, 25};
	    int points = 5;	   
	    g.setColor(Color.blue); 
	    g.fillPolygon(xValues, yValues, points);

	}
	
	public static void main(String[] args){
		new Circle();
	}	
}