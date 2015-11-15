package torrehannoi;

import java.awt.*; 

class Disco extends Forma{
  int size; 
  private final static int altura = 15;
  
  Disco(int size, int x, int y, Color c) {
   super(x, y, c); 
   this.size = size;
  }
  
  void draw(Graphics g) {
    int xp = this.getX() , yp = this.getY();
    g.setColor(this.getColor());     
    g.fillRect(xp, yp, size, altura); 
    g.setColor(Color.BLACK); 
    g.drawRect(xp, yp, size, altura); 
  }
  
  void mover(int x, int y) {
    this.setX(x); 
    this.setY(y); 
  }
  public static int getAltura(){
      return altura;
  }
  public int getSize(){
      return size;
  }
}