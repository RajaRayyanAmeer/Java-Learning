import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RestaurantSlip
{
 public static void main(String [] args)
 {
  JFrame frame = new JFrame("Restaurant Slip");
  frame.setSize(400, 400);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLayout(new GridLayout(6, 3, 10, 10));

  String [] restaurants = {"Burger", "Pizza", "Fries", "Soda"};
  int [] prices = {50, 200, 150, 120};

  JLabel [] restaurantLabels = new JLabel [restaurants.length];
  JTextField [] quantityFields = new JTextField [restaurants.length];
  JLabel [] priceLabels = new JLabel [restaurants.length];

  for (int i = 0; i < restaurants.length; i++)
  {
   restaurantLabels [i] = new JLabel (restaurants [i] + " (Rate: " + prices [i] + ")");
   quantityFields [i] = new JTextField();
   priceLabels [i] = new JLabel();
   frame.add (restaurantLabels [i]);
   frame.add(quantityFields [i]);
   frame.add(priceLabels [i]);
  }

  JButton totalButton = new JButton("Total");
  JLabel totalLabel = new JLabel("Your Total: ");
  frame.add(new JLabel());
  frame.add(totalButton);
  frame.add(totalLabel);

  totalButton.addActionListener(new ActionListener()
  {
   @Override
   public void actionPerformed(ActionEvent e)
   {
    int total = 0;
    for (int i = 0; i < restaurants.length; i++)
    {
     try
     {
      int quantity = Integer.parseInt(quantityFields[i].getText());
      int cost = quantity * prices[i];
      priceLabels[i].setText("Cost: " + cost);
      total += cost;
     }
     catch (NumberFormatException ex)
     {
      priceLabels[i].setText("Invalid Input");
     }
    }
    totalLabel.setText("Your Total: " + total);
    }
   });

   frame.setVisible(true);
 }
}