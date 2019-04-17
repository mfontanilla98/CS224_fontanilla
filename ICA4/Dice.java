/**************************
In Class Assignment #4
Due Date: 2/23/19
Names: Michael Fontanilla
***************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Dice extends JFrame
{
   private JPanel dicePanel; //Holds the images of the die sides
   private JPanel rollPanel; //Panel with roll button
   private JLabel die1;  //die1 image 
   private JLabel die2;	 //die2 image
   private JButton roll; //roll button


   public Dice()
   {
      setTitle("Dice Simulator");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setLayout(new BorderLayout());

	  //Image and button panels
      buildDicePanel();
      buildRollPanel();

      add(dicePanel, BorderLayout.CENTER);
      add(rollPanel, BorderLayout.SOUTH);

      pack();
      setVisible(true);
   }


   //Holds the images of the die sides
   private void buildDicePanel()
   {
      dicePanel = new JPanel();

      die1 = new JLabel();
      die2 = new JLabel();

      dicePanel.add(die1);
      dicePanel.add(die2);
   }

   //Panel with roll button
   private void buildRollPanel()
   {
      rollPanel = new JPanel();

      roll = new JButton("Roll the dice.");

      roll.addActionListener(new rollListener());

      rollPanel.add(roll);
   }

   private class rollListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
		 //die images
         ImageIcon d1 = new ImageIcon("Die1.png");
         ImageIcon d2 = new ImageIcon("Die2.png");
         ImageIcon d3 = new ImageIcon("Die3.png");
         ImageIcon d4 = new ImageIcon("Die4.png");
         ImageIcon d5 = new ImageIcon("Die5.png");
         ImageIcon d6 = new ImageIcon("Die6.png");

         Random rand = new Random();

         int dieRoll_1 = rand.nextInt(6) + 1;
         int dieRoll_2 = rand.nextInt(6) + 1;

		 //Random image for dice1
         if (dieRoll_1 == 1)
         {
           die1.setIcon(d1);
         }
         else if (dieRoll_1 == 2)
         {
           die1.setIcon(d2);
         }
         else if (dieRoll_1 == 3)
         {
           die1.setIcon(d3);
         }
         else if (dieRoll_1 == 4)
         {
           die1.setIcon(d4);
         }
         else if (dieRoll_1 == 5)
         {
           die1.setIcon(d5);
         }
         else if (dieRoll_1 == 6)
         {
           die1.setIcon(d6);
         }

		 //Random image for dice2
         if (dieRoll_2 == 1)
         {
           die2.setIcon(d1);
         }
         else if (dieRoll_2 == 2)
         {
           die2.setIcon(d2);
         }
         else if (dieRoll_2 == 3)
         {
           die2.setIcon(d3);
         }
         else if (dieRoll_2 == 4)
         {
           die2.setIcon(d4);
         }
         else if (dieRoll_2 == 5)
         {
           die2.setIcon(d5);
         }
         else if (dieRoll_2 == 6)
         {
           die2.setIcon(d6);
         }

         pack();
      }

   }

   public static void main(String[] args)
   {
      new Dice();
   }
}