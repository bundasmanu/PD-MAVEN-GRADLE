/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.galomaven;

/**
 *
 * @author Armando
 */
public class Inicio extends EstadoAdapter{
    
    public Inicio(Jogo jj){
        super(jj);
    }
    
    @Override
    public boolean setPlayersName(String name){
            
      return this.getJogo().addPlayer(name);
        
    }
    
    @Override
    public IEstados comecaJogo(){
       
        boolean correu_bem=this.getJogo().inicializaJogo();
        if(correu_bem==true){
            return new Joga(this.getJogo());
        }
        
        return this;
    }
    
}
