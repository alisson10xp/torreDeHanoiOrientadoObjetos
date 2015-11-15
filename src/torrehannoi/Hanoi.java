
package torrehannoi;
import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*; 

class Hanoi implements World {
  
    boolean endGame = false;
    Pino pinoOrigem;
    Pino pinoMeio;
    Pino pinoDestino;
    ArrayList <String> solucao;
    static final int qtdeDiscos = 5;
    
    
  Hanoi(Pino pinoOrigem, Pino pinoMeio, Pino pinoDestino) {
    this.pinoOrigem = pinoOrigem;
    this.pinoMeio = pinoMeio;
    this.pinoDestino = pinoDestino;
    solucao = new ArrayList<String>();
    solucionarTorre(qtdeDiscos, "origem", "destino", "meio");
    
  }
  
  public void draw(Graphics g) { 
      pinoOrigem.draw(g);
      pinoMeio.draw(g);
      pinoDestino.draw(g);   
    
  } 
  
  public void update() { 

      String de;
      String para;
      Iterator it = solucao.iterator();
      if (it.hasNext()){
       de = (String) it.next();
       it.remove();
      }else
          return;
      
      if (it.hasNext()){
        para = (String) it.next();
        it.remove();
      }else
          return;
      
      
      if (de.equals("origem")){
          if (para.equals("meio")){
              Disco d = pinoOrigem.removerDisco();
              pinoMeio.inserirDisco(d);
          }else if (para.equals("destino")){
              Disco d = pinoOrigem.removerDisco();
              pinoDestino.inserirDisco(d);
          }
      }else if (de.equals("meio")){
          if (para.equals("origem")){
              Disco d = pinoMeio.removerDisco();
              pinoOrigem.inserirDisco(d);
          }else if (para.equals("destino")){
              Disco d = pinoMeio.removerDisco();
              pinoDestino.inserirDisco(d);
          }
      }else if(de.equals("destino")){
          if (para.equals("origem")){
              Disco d = pinoDestino.removerDisco();
              pinoOrigem.inserirDisco(d);
          }else if (para.equals("meio")){
              Disco d = pinoDestino.removerDisco();
              pinoMeio.inserirDisco(d);
          }
      }
	  
	  
  }
  
 
  
  
  
  public boolean hasEnded() {
	  if (this.solucao.isEmpty())
		  return true;
	  return false; 
  } 
  
  private void solucionarTorre(int qtdeDiscos, String origem, String destino, String meio) {
    if (qtdeDiscos == 1){
           this.solucao.add(origem);
           this.solucao.add(destino);
         
    }else{
           solucionarTorre (qtdeDiscos - 1, origem, meio, destino);
           this.solucao.add(origem);
           this.solucao.add(destino);
           solucionarTorre(qtdeDiscos -1, meio, destino, origem); 
    }
  } 
 
    
  
  public static void main(String[] args) {
    BigBang gameBigBang = new BigBang(500, new Hanoi(new Pino(qtdeDiscos, 10, 10), new Pino(0, 20, 10), new Pino(0, 30, 10))); 
    JFrame frame = new JFrame("Hanoi"); 
    frame.getContentPane().add( gameBigBang ); 
    frame.setVisible(true); 
    frame.setSize(400, 400); 
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    
    gameBigBang.start(); //start timer
  }

    
    
}