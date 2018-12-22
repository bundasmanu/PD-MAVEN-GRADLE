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
public class Galo {
    
    private Jogo j;
    private IEstados estado;
    
    public Galo(){
        this.j=new Jogo();
        this.estado=new Inicio(this.j);
    }

    public Jogo getJ() {
        return j;
    }

    public IEstados getEstado() {
        return estado;
    }

    public void setJ(Jogo j) {
        this.j = j;
    }

    public void setEstado(IEstados estado) {
        this.estado = estado;
    }
    
    /*ACCOES DO JOGO*/
    
    public boolean setPlayersName(String name){
        return this.estado.setPlayersName(name);
    }
    
    public void comecaJogo(){
        this.setEstado(this.estado.comecaJogo());
    }
    
    public void colocaPeca(int l, int c){
        this.setEstado(this.estado.colocaPeca(l, c));
    }
    
    public String mostraTab(){
        return this.estado.mostraTabuleiro();
    }
    
    public void sair(){
        this.setEstado(this.estado.sair());
    }

    
}
