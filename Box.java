import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class Box extends JPanel {
  
  private ArrayList<Ball> balls = new ArrayList<Ball>();
  private int height, width;
  
  public Box (int height, int width, int nBalls) {
    for (int i=0; i < nBalls; i++) {
      this.balls.add(new Ball(Vector.randomVector(height), Vector.randomVector(10),
                              new Color((float)Math.random(), (float)Math.random(), (float)Math.random()),
                              5 + (int)(Math.random()*20), this, 5));
    }
    this.height = height;
    this.width = width;
    this.setPreferredSize(new Dimension(width, height));  
    this.setBackground(Color.white);
    this.setBorder(new LineBorder(Color.black, 2));
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Ball e: balls) {
      e.paint(g);
    }
  }
  
  public int getWidth() {
    return width;
  }
  
  public int getHeight() {
    return height;
  }
  
  public void step() {
    ArrayList<Ball> collisions = new ArrayList<Ball>();
    for (int i = 0; i < balls.size(); i++) {
      if (balls.get(i).getLives() == 0) {
        balls.remove(balls.get(i));
      }
    }
    for (Ball e: balls) {
      e.move();
      collisions.add(e);
    }
    for (int i = 0; i < balls.size()-1; i++) {
      Ball check = collisions.remove(0);
      for (int k = 0; k < collisions.size(); k++) {
        check.collide(collisions.get(k));
      }
    }
    repaint();
  }
}