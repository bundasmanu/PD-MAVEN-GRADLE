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
public class Joga extends EstadoAdapter{
    
    public Joga(Jogo jj){
        super(jj);
    }
    
    @Override
    public IEstados colocaPeca(int x, int y){
        
        if(x<3 && y<3){
            if(this.getJogo().posicaoVazia(x, y)==true){
                this.getJogo().adicionaTokenPos(x, y);
                this.getJogo().jogadorAtual.removeToken();
                boolean ganhou=this.getJogo().jogadorGanhou(this.getJogo().jogadorAtual);
                if(ganhou==true){
                    System.out.println("\nO jogador: "+this.getJogo().jogadorAtual.getNome()+" ganhou\n");
                    return new Acabou(this.getJogo());
                }
                if(this.getJogo().jogoTerminou()==true){
                    System.out.println("\nNinguem ganhou\n");
                    return new Acabou(this.getJogo());
                }
                if(ganhou==false){
                    this.getJogo().novoTurno();
                    return new Joga(this.getJogo());
                }
            }
        }
        
        return this;
    }
    
    @Override
    public IEstados sair(){
        this.getJogo().resetVarsJogo();
        return new Acabou(this.getJogo());
    }
    
}
