/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.galomaven;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */
public class Jogo {
 
    public Token tabuleiro [][];
    public List<Jogador> jogadores;
    public Jogador jogadorAtual=null;
    int numeroJogadorAtual;
    boolean jogo_a_correr=false;
    boolean alguem_ganhou=false;
    
    public Jogo(){
        this.jogadores=new ArrayList<Jogador>();
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public int getNumeroJogadorAtual() {
        return numeroJogadorAtual;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public void setNumeroJogadorAtual(int numeroJogadorAtual) {
        this.numeroJogadorAtual = numeroJogadorAtual;
    }
    
    public boolean addPlayer(String name){
        return this.jogadores.add(new Jogador(name));
    }
    
    public boolean removePlayer(Jogador j){
        return this.jogadores.remove(j);
    }

    public boolean inicializaJogo(){
        
        /*Inicialização da matriz do jogo*/
        try{
            if(this.jogadores.size()==2){
        
            this.jogo_a_correr=true;
          
            this.tabuleiro=new Token [3][3];
        
            /*DISTRIBUIR AS PECAS INICIAIS PELOS JOGADORES*/
            this.distribuiPecasJogadores();
       
            /*DEFINE DE FORMA ALEATORIA QUAL O PRIMEIRO JOGADOR A JOGAR*/
            int intervalo=2-0;/*INTERVALO DE 0 A (NUMERO JOGADORES -1), PORQUE A PERCORRER O ARRAY COMECAMOS EM 0*/
            this.numeroJogadorAtual= (int) (Math.random() * intervalo) + 0;
        
            this.jogadorAtual=this.jogadores.get(this.numeroJogadorAtual);
        
        }
    }
    catch(Exception e){
        return false;
    }
    
    return true;
    }    
    
    /*INVOCADO QUANDO SE CLICA EM COMECAR O JOGO*/
    public void distribuiPecasJogadores(){
        
        for(Jogador x : this.jogadores){
            x.addToken();
        }
        
    }
    
    
    public void novoTurno(){ 
        /*PASSA A VEZ AO PROXIMO JOGADOR*/
        if(this.numeroJogadorAtual==0){
            this.numeroJogadorAtual=1;
            this.jogadorAtual=this.jogadores.get(this.numeroJogadorAtual);
        }
        else{
            this.numeroJogadorAtual=0;
            this.jogadorAtual=this.jogadores.get(this.numeroJogadorAtual);
        }
    }
    
    public boolean posicaoVazia(int x, int y){
        
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(i==x && j==y){
                    if(this.tabuleiro[i][j]==null){
                        return true;
                    }
                }
            }
        }    
        return false;
    }
    
    public boolean adicionaTokenPos(int x, int y){
        
        if(this.posicaoVazia(x, y)==true){
            this.tabuleiro[x][y]=new Token(this.getJogadorAtual());
            return true;
        }
        
        return false;
    }
    
    public boolean verificaLinhas(Jogador x){
                int conta=0;
        
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(this.tabuleiro[i][j]!=null){
                    if(this.tabuleiro[i][j].getPlayer()==x){
                        conta++;
                    }
                    else{
                        conta=0;
                    }
                    if(conta==3){
                        return true;
                    }
                }
            }    
            conta=0;
        }
        
        return false;
    }
    
    public boolean verificaColunas(Jogador x){
        
        int conta=0;
        
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(this.tabuleiro[j][i]!=null){
                    if(this.tabuleiro[j][i].getPlayer()==x){
                        conta++;
                    }
                    else{
                        conta=0;
                    }
                    if(conta==3){
                        return true;
                    }
                }
            }    
            conta=0;
        }
        
        return false;
    }
    
    public boolean verificaDiagonais(Jogador x){
        
        int conta=0;
        
        /*DIAGONAL PRINCIPAL*/
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(i==j){
                    if(this.tabuleiro[i][j]!=null){
                        if(this.tabuleiro[i][j].getPlayer()==x){
                            conta++;
                        }
                        else{
                            return false;
                        }
                    }   
                }
            }
        }    
        
        if(conta==3){
            return true;
        }
        
        
        conta=0;
        /*DIAGONAL PRINCIPAL INVERTIDA*/
        for(int i=0;i<3;++i){
            for(int j=2;j>0;--j){
                if(i+j==2){
                    if(this.tabuleiro[i][j]!=null){
                        if(this.tabuleiro[i][j].getPlayer()==x){
                            conta++;
                        }
                        else{
                            conta=0;
                        }
                    }
                }
            }
        }
        if(conta==3){
            return true;
        }
        
        return false;
    }
    
    public boolean jogadorGanhou(Jogador x){
        
        /*VERIFICA DE ENTRE AS VARIAS HIPOTESES, SE O JOGADOR GANHOU*/
        if(this.verificaLinhas(x)==true || this.verificaColunas(x)==true || this.verificaDiagonais(x)==true){
            this.jogo_a_correr=false;
            this.alguem_ganhou=true;
            return true;
        }
        
        return false;
    }
    
    public boolean jogoTerminou(){
        
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(this.tabuleiro[i][j]==null){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    public boolean resetVarsJogo(){
       
      try{
        this.jogadorAtual=null;
        this.alguem_ganhou=false;
        this.jogo_a_correr=false;
        this.jogadores.removeAll(jogadores);
        this.tabuleiro=null;
      }
      catch(Exception e){
          return false;
      }
      
      return true;
    }
    
    public String listaTabuleiroApenas(){
        
        String onfo_jogada=" ";
        
        for(int i=0;i<3;++i){
                onfo_jogada+="\n";
            for(int j=0;j<3;++j){
                if(this.tabuleiro[i][j]!=null){
                    if(this.tabuleiro[i][j].getPlayer()==null){
                        onfo_jogada+="vazio";
                    }
                }
                if(this.tabuleiro[i][j]!=null){
                    if(this.tabuleiro[i][j].getPlayer()!=null){
                        onfo_jogada+=this.tabuleiro[i][j].getPlayer().getNome();
                    }
                }
                if(this.tabuleiro[i][j]==null){
                    onfo_jogada+="vazio";
                }
                
                if(j!=2){
                    onfo_jogada+=" | ";
                }
            }
        }
        
        return onfo_jogada;
        
    }
    
    @Override
    public String toString(){
        
        String onfo_jogada=" ";
        
        onfo_jogada+="Jogador a jogar: "+this.getJogadorAtual().getNome()+"\n";
        
        for(int i=0;i<3;++i){
                onfo_jogada+="\n";
            for(int j=0;j<3;++j){
                if(this.tabuleiro[i][j]!=null){
                    if(this.tabuleiro[i][j].getPlayer()==null){
                        onfo_jogada+="vazio";
                    }
                }
                if(this.tabuleiro[i][j]!=null){
                    if(this.tabuleiro[i][j].getPlayer()!=null){
                        onfo_jogada+=this.tabuleiro[i][j].getPlayer().getNome();
                    }
                }
                if(this.tabuleiro[i][j]==null){
                    onfo_jogada+="vazio";
                }
                
                if(j!=2){
                    onfo_jogada+=" | ";
                }
            }
        }
        
        return onfo_jogada;
    }
    
}  
       
