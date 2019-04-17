<<<<<<< HEAD
/***********************************
Assignment 4
March 25, 2019
Ryan Hays, Michael Fontanilla
***********************************/


=======
/***************
Homework #4
Due Date: 3/25/19
Names: Michael Fontanilla, Ryan Hays
********************/
>>>>>>> 74b2641a5fea86bcf5b6fdcf38385c2345c4896e

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MotionParallax extends JFrame implements ActionListener
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
   Color sun = new Color(255,255,128);
   Color foregroundMountain = new Color(191, 128, 64);
   Color backgroundMountain = new Color(204, 153, 102);
   Color snow = new Color(242,242,242);
   Color cloud = new Color(204,204,204);
   private int sunDivider = 100;
   private int backMountDivider = 50;
   private int frontMountDivider = 25;
   private int sandDivider = 12;
   private int waterDivider = 6;
   private double clicks = 0;
   private int delay = 10;
   protected Timer timer;

   public MotionParallax()
   {
     InitialElements();

     addMouseListener(new MyMouseListener());
     addMouseMotionListener(new MyMouseMotionListener());

     timer = new Timer(delay, this);
     timer.start();		// start the timer
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

   public void actionPerformed(ActionEvent e)
   // will run when the timer fires
   {
	    //repaint();
      cloud = new Color(102, 153, 255);
   }

   public void paint(Graphics g)
   {
     //background
     g.drawRect((0 + currentX/sandDivider),(0 + currentY/sandDivider),600,600);
     g.setColor(sand);
     g.fillRect((0 + currentX/sandDivider),(0 + currentY/sandDivider),600,600);


     //muddy sand between water and sand
     g.drawOval((-1000 + currentX/sandDivider),(375 + currentY/sandDivider), 2000, 400);
     g.setColor(ground);
     g.fillOval((-1000 + currentX/sandDivider), (375 + currentY/sandDivider), 2000, 400);

     //water
     g.drawOval((-1000 + currentX/waterDivider),(400 + currentY/waterDivider),2000,400);
     g.setColor(water);
     g.fillOval((-1000 + currentX/waterDivider), (400 + currentY/waterDivider), 2000, 400);

     //sky color
	 //sky does not need parallax
     g.drawRect(0,0,500,200);
     g.setColor(sky);
     g.fillRect(0,0,500,200);

     //sun
     g.setColor(sun);
     g.fillOval((125 + currentX/sunDivider),(50 + currentY/sunDivider),50,50);

     g.setColor(cloud);
     g.fillOval((375 + currentX/sunDivider), (50 + currentY/sunDivider),100,50);

     //right background mountain
     int xValuesRBM[] = {(345 + currentX/backMountDivider), (450 + currentX/backMountDivider), (250 + currentX/backMountDivider)};
     int yValuesRBM[] = {(100 + currentY/backMountDivider), (325 + currentY/backMountDivider), (325 + currentY/backMountDivider)};
     int pointsRBM = 3;
     g.setColor(backgroundMountain);
     g.fillPolygon(xValuesRBM, yValuesRBM, pointsRBM);

     //left background mountain
     int xValuesLBM[] = {(165 + currentX/backMountDivider), (270 + currentX/backMountDivider), (70 + currentX/backMountDivider)};
     int yValuesLBM[] = {(100 + currentY/backMountDivider), (325 + currentY/backMountDivider), (325 + currentY/backMountDivider)};
     int pointsLBM = 3;
     g.setColor(backgroundMountain);
     g.fillPolygon(xValuesLBM, yValuesLBM, pointsLBM);

     //middle foreground mountain
     int xValuesMFM[] = {(265 + currentX/frontMountDivider), (275 + currentX/frontMountDivider), (285 + currentX/frontMountDivider), (375 + currentX/frontMountDivider), (150 + currentX/frontMountDivider)};
     int yValuesMFM[] = {(50 + currentY/frontMountDivider), (75 + currentY/frontMountDivider), (50 + currentY/frontMountDivider), (325 + currentY/frontMountDivider), (325 + currentY/frontMountDivider)};
     int pointsMFM = 5;
     g.setColor(foregroundMountain);
     g.fillPolygon(xValuesMFM, yValuesMFM, pointsMFM);

     //middle mountain snow
     int xValuesMMS[] = {(265 + currentX/frontMountDivider), (275 + currentX/frontMountDivider), (285 + currentX/frontMountDivider), (310 + currentX/frontMountDivider), (233 + currentX/frontMountDivider)};
     int yValuesMMS[] = {(50 + currentY/frontMountDivider), (75 + currentY/frontMountDivider), (50 + currentY/frontMountDivider), (125 + currentY/frontMountDivider), (125 + currentY/frontMountDivider)};
     int pointsMMS = 5;
     g.setColor(snow);
     g.fillPolygon(xValuesMMS, yValuesMMS, pointsMMS);

     //left foreground mountain
     int xValuesLFM[] = {(65 + currentX/frontMountDivider), (75 + currentX/frontMountDivider), (85 + currentX/frontMountDivider), (175 + currentX/frontMountDivider), (-50 + currentX/frontMountDivider)};
     int yValuesLFM[] = {(50 + currentY/frontMountDivider), (75 + currentY/frontMountDivider), (50 + currentY/frontMountDivider), (325 + currentY/frontMountDivider), (325 + currentY/frontMountDivider)};
     int pointsLFM = 5;
     g.setColor(foregroundMountain);
     g.fillPolygon(xValuesLFM, yValuesLFM, pointsLFM);

     //left mountain snow
     int xValuesLMS[] = {(65 + currentX/frontMountDivider), (75 + currentX/frontMountDivider), (85 + currentX/frontMountDivider), (110 + currentX/frontMountDivider), (35 + currentX/frontMountDivider)};
     int yValuesLMS[] = {(50 + currentY/frontMountDivider), (75 + currentY/frontMountDivider), (50 + currentY/frontMountDivider), (125 + currentY/frontMountDivider), (125 + currentY/frontMountDivider)};
     int pointsLMS = 5;
     g.setColor(snow);
     g.fillPolygon(xValuesLMS, yValuesLMS, pointsLMS);

     //right foreground mountain
     int xValuesRFM[] = {(445 + currentX/frontMountDivider), (455 + currentX/frontMountDivider), (465 + currentX/frontMountDivider), (550 + currentX/frontMountDivider), (350 + currentX/frontMountDivider)};
     int yValuesRFM[] = {(50 + currentY/frontMountDivider), (75 + currentY/frontMountDivider), (50 + currentY/frontMountDivider), (325 + currentY/frontMountDivider), (325 + currentY/frontMountDivider)};
     int pointsRFM = 5;
     g.setColor(foregroundMountain);
     g.fillPolygon(xValuesRFM, yValuesRFM, pointsRFM);

     //right mountain snow
     int xValuesRMS[] = {(445 + currentX/frontMountDivider), (455 + currentX/frontMountDivider), (465 + currentX/frontMountDivider), (488 + currentX/frontMountDivider), (419 + currentX/frontMountDivider)};
     int yValuesRMS[] = {(50 + currentY/frontMountDivider), (75 + currentY/frontMountDivider), (50 + currentY/frontMountDivider), (125 + currentY/frontMountDivider), (125 + currentY/frontMountDivider)};
     int pointsRMS = 5;
     g.setColor(snow);
     g.fillPolygon(xValuesRMS, yValuesRMS, pointsRMS);

     //sand blending with moutains
     g.setColor(sand);
     g.fillOval((-75 + currentX/sandDivider),(315 + currentY/sandDivider),570,50);
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

		//make night
		clicks++;
		if ((clicks % 2) == 0)
		{
			sun = new Color (255,255,128);
			sand = new Color(255,212,128);
		  water = new Color(102,0,255);
			ground = new Color(191,128,64);
		  sky = new Color(102,153,255);
		  foregroundMountain = new Color(191, 128, 64);
		  backgroundMountain = new Color(204, 153, 102);
			snow = new Color(242,242,242);
		}
		else
		{
			sun = new Color(140,140,140);
			sand = new Color(153,102,0);
		  water = new Color(0,51,128);
			ground = new Color(77,38,0);
		  sky = new Color(10,0,0);
		  foregroundMountain = new Color(102, 68, 0);
		  backgroundMountain = new Color(128, 85, 0);
			snow = new Color(179,179,179);
		}
		repaint();
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
		      repaint();
      }
   }

   public static void main(String[] args)
   {
     new MotionParallax();
   }
}
