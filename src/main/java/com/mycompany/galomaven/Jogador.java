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
public class Jogador {
 
    String nome;
    List<Token> tokens;
    
    public Jogador(String name){
        this.nome=name;
        this.tokens=new ArrayList<Token>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Token> getTokens(){
        return this.tokens;
    }
    
    public boolean addToken(){
        return this.tokens.add(new Token(this));
    }
    
    public boolean removeToken(){
        try{
            this.tokens.remove(0);
        }
        catch(Exception e){
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString(){
        
        String info_player="";
        
        info_player+=this.getNome()+"\n";
        
        return info_player;
    }
    
}
