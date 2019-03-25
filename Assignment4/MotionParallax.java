import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class MotionParallax extends JFrame
{
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private int width = 0;    // The rectangle's width
   private int height = 0;   // The rectangle's height
   private JPanel panel;
   private final int WINDOW_WIDTH = 500;
   private final int WINDOW_HEIGHT = 500;
   Color sand = new Color(255,212,128);
   Color water = new Color(102,0,255);
   Color ground = new Color(191,128,64);
   Color sky = new Color(102,153,255);
   Color foregroundMountain = new Color(191, 128, 64);
   Color backgroundMountain = new Color(204, 153, 102);
   private int sunDivider = 100;

   public MotionParallax()
   {
     InitialElements();

     addMouseListener(new MyMouseListener());
     addMouseMotionListener(new MyMouseMotionListener());

     //panel = new JPanel();
     //add(panel);
   }
   private void InitialElements()
   {
     setTitle("Motion Parallax");
     setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
   }

   /**
      paint method
      @param g The applet's Graphics object.
   */

   public void paint(Graphics g)
   {
     //background
     g.drawRect(0,0,500,500);
     g.setColor(sand);
     g.fillRect(0,0,500,500);


     //muddy sand between water and sand
     g.drawOval(-1000,375, 2000, 400);
     g.setColor(ground);
     g.fillOval(-1000, 375, 2000, 400);

     //water
     g.drawOval(-1000,400,2000,400);
     g.setColor(water);
     g.fillOval(-1000, 400, 2000, 400);

     //sky color
     g.drawRect(0,0,500,200);
     g.setColor(sky);
     g.fillRect(0,0,500,200);

     //sun
     g.setColor(Color.YELLOW);
     g.fillOval((125 + currentX/sunDivider),(50 + currentY/sunDivider),50,50);

     //right background mountain
     int xValuesRBM[] = {345, 450, 250};
     int yValuesRBM[] = {100, 325, 325};
     int pointsRBM = 3;
     g.setColor(backgroundMountain);
     g.fillPolygon(xValuesRBM, yValuesRBM, pointsRBM);

     //left background mountain
     int xValuesLBM[] = {165, 270, 70};
     int yValuesLBM[] = {100, 325, 325};
     int pointsLBM = 3;
     g.setColor(backgroundMountain);
     g.fillPolygon(xValuesLBM, yValuesLBM, pointsLBM);

     //middle foreground mountain
     int xValuesMFM[] = {265, 275, 285, 375, 150};
     int yValuesMFM[] = {50, 75, 50, 325, 325};
     int pointsMFM = 5;
     g.setColor(foregroundMountain);
     g.fillPolygon(xValuesMFM, yValuesMFM, pointsMFM);

     //middle mountain snow
     int xValuesMMS[] = {265, 275, 285, 310, 233};
     int yValuesMMS[] = {50, 75, 50, 125, 125};
     int pointsMMS = 5;
     g.setColor(Color.WHITE);
     g.fillPolygon(xValuesMMS, yValuesMMS, pointsMMS);

     //left foreground mountain
     int xValuesLFM[] = {65, 75, 85, 175, -50};
     int yValuesLFM[] = {50, 75, 50, 325, 325};
     int pointsLFM = 5;
     g.setColor(foregroundMountain);
     g.fillPolygon(xValuesLFM, yValuesLFM, pointsLFM);

     //left mountain snow
     int xValuesLMS[] = {65, 75, 85, 110, 35};
     int yValuesLMS[] = {50, 75, 50, 125, 125};
     int pointsLMS = 5;
     g.setColor(Color.WHITE);
     g.fillPolygon(xValuesLMS, yValuesLMS, pointsLMS);

     //right foreground mountain
     int xValuesRFM[] = {445, 455, 465, 550, 350};
     int yValuesRFM[] = {50, 75, 50, 325, 325};
     int pointsRFM = 5;
     g.setColor(foregroundMountain);
     g.fillPolygon(xValuesRFM, yValuesRFM, pointsRFM);

     //right mountain snow
     int xValuesRMS[] = {445, 455, 465, 488, 419};
     int yValuesRMS[] = {50, 75, 50, 125, 125};
     int pointsRMS = 5;
     g.setColor(Color.WHITE);
     g.fillPolygon(xValuesRMS, yValuesRMS, pointsRMS);

     //sand blending with moutains
     g.setColor(sand);
     g.fillOval(-75,315,570,50);
   }

   /**
      Mouse listener class
   */

   private class MyMouseListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
		System.out.println("Mouse pressed");
		System.out.println("Holding...");
      }

      public void mouseClicked(MouseEvent e)
      {
		System.out.println("Mouse Clicked");
      }

      public void mouseReleased(MouseEvent e)
      {
		System.out.println("Mouse Released");
      }

      public void mouseEntered(MouseEvent e)
      {
		System.out.println("Mouse has entered");
      }

      public void mouseExited(MouseEvent e)
      {
		System.out.println("Mouse has exited");
      }
   }

   /**
      Mouse Motion listener class
   */

   private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
		currentX = e.getX();
		currentY = e.getY();
		repaint();
      }

      public void mouseMoved(MouseEvent e)
      {
		currentX = e.getX();
		currentY = e.getY();
		System.out.println(currentX);
		repaint();
      }
   }

   public static void main(String[] args)
   {
     new MotionParallax();
   }
}
