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
   Color desertSky = new Color(255,212,128);
   Color water = new Color(128,170,255);
   Color ground = new Color(191,128,64);
   Color sky = new Color(102,153,255);
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
     g.setColor(desertSky);
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

     int xValues2[] = {265, 275, 285, 375, 150};
     int yValues2[] = {50, 75, 50, 325, 325};
     int points2 = 5;
     g.setColor(Color.yellow);
     g.fillPolygon(xValues2, yValues2, points2);

     int xValues[] = {65, 75, 85, 175, -50};
     int yValues[] = {50, 75, 50, 325, 325};
     int points = 5;
     g.setColor(Color.blue);
     g.fillPolygon(xValues, yValues, points);

     int xValues3[] = {445, 455, 465, 550, 350};
     int yValues3[] = {50, 75, 50, 325, 325};
     int points3 = 5;
     g.setColor(Color.green);
     g.fillPolygon(xValues3, yValues3, points3);

     //getContentPane().setBackground(desertSky);
   }

   /**
      Mouse listener class
   */

   private class MyMouseListener
                       implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
      }

      //
      // The following methods are unused, but still
      // required by the MouseListener interface.
      //

      public void mouseClicked(MouseEvent e)
      {
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

   /**
      Mouse Motion listener class
   */

   private class MyMouseMotionListener
                   implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
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
     new MotionParallax();
   }
}
