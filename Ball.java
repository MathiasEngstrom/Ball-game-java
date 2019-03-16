import java.awt.*;

public class Ball {

private Vector pos, v;
private Color c;
private int r;
private Box box;
private int lives;


public Ball(Vector pos, Vector v, Color c, int r, Box box, int lives) {
this.pos = pos;
this.v = v;
this.c = c;
this.r = r;
this.box = box;
this.lives = lives;
}

public int getLives() {
return lives;
}
  
public Vector getPos() {
return pos;
}
  
public Vector getV() {
return v;
}
  
public int getR() {
return r;
}

public void setLives(int lives) {
this.lives = lives;
}
  
public void setPos(Vector pos) {
this.pos = pos;
}

public void setV(Vector v) {
this.v = v;
}

public void collide(Ball b) {
  if (this.pos.distance(b.pos) < this.getR() + b.getR()) {
    Vector v1 = this.getV();
    Vector v2 = b.getV();
    Vector pos1 = this.getPos();
    Vector pos2 = b.getPos();
    
    double scalar = ((v2.sub(v1)).dot(pos2.sub(pos1))) / Math.pow(pos2.distance(pos1), 2);
    Vector vector = (pos2.sub(pos1)).scale(scalar);
    this.setV(v1.add(vector));
    b.setV(v2.add(vector));
    this.lives--;
    b.lives--;
  }
}


public void move() {
pos = pos.add(v);

//Collision with right and left
if (pos.getX() > box.getWidth() - r && v.getX() > 0 || pos.getX() < r && v.getX() < 0) {
v = v.flipSignX();
}
//Collision with up and down
if (pos.getY() > box.getHeight() - r && v.getY() > 0 || pos.getY() < r && v.getY() < 0) {
v = v.flipSignY();
}
}

    public void paint(Graphics g) {
       g.setColor(c);
       g.fillOval((int)pos.getX() - r, (int)pos.getY() - r, 2*r, 2*r);
    }
 }