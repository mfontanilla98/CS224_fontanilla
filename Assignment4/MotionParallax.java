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
   Color desertDunes = new Color(128,170,255);
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
     g.drawRect(0,0,500,500);
     g.setColor(desertSky);
     g.fillRect(0,0,500,500);



     g.drawOval(-1000,375, 2000, 400);
     g.setColor(ground);
     g.fillOval(-1000, 375, 2000, 400);

     g.drawOval(-1000,400,2000,400);
     g.setColor(desertDunes);
     g.fillOval(-1000, 400, 2000, 400);

     //g.drawRect(0,0,250,500);
     //g.setColor(sky);
     //g.fillRect(0,0,250,500);

     int xValues[] = {25, 145, 25, 145, 25};
     int yValues[] = {25, 25, 145, 145, 25};
     int points = 5;
     g.setColor(Color.blue);
     g.fillPolygon(xValues, yValues, points);
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
