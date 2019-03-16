import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class BoxInterface extends JFrame implements ActionListener{
  
  JTextField textBall = new JTextField(10);
  JTextField textSize = new JTextField(10);
  JTextField textDelay = new JTextField(10);
  
  JLabel labelBall = new JLabel(" Number of balls: ");
  JLabel labelSize = new JLabel(" Window size: ");
  JLabel labelDelay = new JLabel(" Delay: ");
  
  JButton start = new JButton("Start");
  JButton quit = new JButton("Quit");
  
  public BoxInterface() {
    super("Ball game");
      
    textBall.addActionListener(this);
    textSize.addActionListener(this);
    textDelay.addActionListener(this);
    start.addActionListener(this);
    quit.addActionListener(this);
   
    JPanel textPart = new JPanel(new GridLayout(4,1));
    textPart.add(textBall);
    textPart.add(textSize);
    textPart.add(textDelay);
    textPart.add(quit);
                                 
    JPanel labelPart = new JPanel(new GridLayout(4,1));
    labelPart.add(labelBall);
    labelPart.add(labelSize);
    labelPart.add(labelDelay);
    labelPart.add(start);
                                   
    this.setLayout(new FlowLayout());
    this.add(labelPart);
    this.add(textPart);

                                   
    textBall.setText("10");
    textSize.setText("500");
    textDelay.setText("30");
    
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent e) {
    
    
    Scanner scBalls = new Scanner(textBall.getText());
    Scanner scSize = new Scanner(textSize.getText());
    Scanner scDelay = new Scanner(textDelay.getText());
    
      int balls = 0;
      int size = 0;
      int delay = 0;
    
    if (scBalls.hasNextInt() && scSize.hasNextInt() && scDelay.hasNextInt()) {
      balls = scBalls.nextInt();
      size = scSize.nextInt();
      delay = scDelay.nextInt();
    }
    
    
    if (e.getSource() == start) {
      BoxFrame bf = new BoxFrame(size, size, delay, balls);
    } else if (e.getSource() == quit) {
      JOptionPane.showMessageDialog(null, "Quitting program"); 
      System.exit(0);
    }
  }
  
  public static void main(String[] arg) {
    BoxInterface bi = new BoxInterface();
  }
}
