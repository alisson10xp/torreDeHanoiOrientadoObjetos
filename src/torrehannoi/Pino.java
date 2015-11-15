/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torrehannoi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author daniel
 */
public class Pino extends Forma{
    final static int SIZE = 10; // pixels 
    int altura_pino;
    ArrayList <Disco> discos;
    int qtdeDiscos;
    
    public Pino(int qtdeDiscos, int x, int y) {
        super(x*SIZE, y* SIZE+50, Color.blue);
        this.altura_pino = SIZE*10;
        this.discos = new ArrayList<Disco>();
        this.qtdeDiscos = qtdeDiscos;
        addDiscos(qtdeDiscos);
    }
    
    
    void draw(Graphics g) {
        int xp = this.getX(), yp = this.getY();
        g.setColor(this.getColor());     
        g.fillRect(xp, yp, SIZE, altura_pino); //parameter(x,y, width, height)
        g.setColor(Color.BLACK); 
        g.drawRect(xp, yp, SIZE, altura_pino); 
        
        //desenha discos
        for (Disco d: this.discos){
            d.draw(g);
        }
  }

    private void addDiscos(int qtdeDiscos) {
        int diferenca_tamanho_disco = Disco.getAltura();
        int altura_disco = Disco.getAltura();
        
        int coordenada_y_inicial = this.getY()+altura_pino - altura_disco;
        
        //int coordenada_y_inicial = (( this.y + ( this.altura_pino / 2)) -  ( altura_disco / 2));
        int tamanho_inicial = (qtdeDiscos*diferenca_tamanho_disco) + diferenca_tamanho_disco;
        Color cor = Color.RED;
        for (int i = 0; i < qtdeDiscos; i++){
            discos.add(new Disco(tamanho_inicial, this.getX() - (tamanho_inicial / 2) + (SIZE/2), coordenada_y_inicial, cor));
            tamanho_inicial -= diferenca_tamanho_disco; 
            coordenada_y_inicial -= altura_disco;
        }
        
    }

    Disco removerDisco() {
        
        Disco d = this.discos.remove(this.discos.size()-1);
        
        return d;
        
    }

    void inserirDisco(Disco d) {
        Disco ultimoDisco;
        
        int tamanho_disco = d.getSize();
        int coordenada_x = this.getX() - (tamanho_disco / 2) + (SIZE/2);
        Iterator  it = discos.iterator();
        if (it.hasNext() ){
            
            ultimoDisco = this.discos.get(this.discos.size()-1);
            d.mover(coordenada_x, ultimoDisco.getY()- Disco.getAltura());
            
        }else{//pino vazio
            int altura_disco = Disco.getAltura();
            int coordenada_y = this.getY()+ altura_pino - altura_disco;
            
            d.setX(coordenada_x);
            d.setY(coordenada_y);
            
        }
        
        this.discos.add(d);
    }
    
}
