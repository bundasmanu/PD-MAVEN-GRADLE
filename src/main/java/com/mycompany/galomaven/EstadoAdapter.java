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
public abstract class EstadoAdapter implements IEstados{
    
    private Jogo j;
    
    public EstadoAdapter(Jogo jj){
        this.j=jj;
    }
    
    public Jogo getJogo(){
        return this.j;
    }
    
    public void setJogo(Jogo jj){
        this.j=jj;
    }
    
    @Override
    public boolean setPlayersName(String name){
        return false;
    }
    
    @Override
    public IEstados comecaJogo(){
        return this;
    }
    
    @Override
    public IEstados colocaPeca(int x, int y){
        return this;
    }
    
    @Override
    public String mostraTabuleiro(){
       return this.getJogo().toString();
    }
    
    @Override
    public IEstados sair(){
        return this;
    }
    
}
