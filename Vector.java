public class Vector {
  
  private double x, y;
  
  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public String toString() {
    return "<" + x + ", " + y + ">";
  }
  
  public double getX() {
    return x;
  }
  
  public double getY() {
    return y;
  }
  
  public Vector add(Vector v) {
    return new Vector(x + v.getX(), y + v.getY());
  }
  
  public Vector sub(Vector v) {
    return new Vector(x - v.getX(), y - v.getY());
  }
  
  public double dot (Vector v) {
    return x*v.getX() + y*v.getY();
  }
  
  public Vector scale(double d) {
    return new Vector(d*x, d*y);
  }
  
  public double distance(Vector v) {
    return Math.sqrt(Math.pow(v.getX() - x, 2) + Math.pow(v.getY() - y, 2));
  }
  
  public double length() {
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }
  
  public Vector flipSignX() {
    return new Vector(-x, y);
  }
  
  public Vector flipSignY() {
    return new Vector(x, -y);
  }
  
  public static Vector randomVector(double len) {
//    double xr = Math.random()*len;
//    double yr = Math.sqrt(Math.pow(len, 2) - Math.pow(xr, 2));
    return new Vector(Math.random()*len, Math.random()*len);
  }
  
  public double angle() {
    return Math.atan2(y, x);
  }
  
  public static Vector polar(double length, double angle) {
    return new Vector(length*Math.cos(angle), length*Math.sin(angle));
  }
}