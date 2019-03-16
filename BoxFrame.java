 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;

 public class BoxFrame extends JFrame implements ActionListener {
   private Box theBox;
   private Timer timer;

   public BoxFrame(int width, int height, int delay, int nBalls) {
      theBox = new Box(height, width, nBalls);
      timer = new Timer(delay, this);
      add(theBox);
      pack();
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      timer.start();
   }

   public void actionPerformed(ActionEvent e) {
      theBox.step();
   }

   public static void main(String[] args) { 
      BoxFrame bf = new BoxFrame(1000, 600, 30, 2);  
   }
 }