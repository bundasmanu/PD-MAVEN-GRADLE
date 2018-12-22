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
public class Token {
    
    Jogador player=null;
    
    public Token(Jogador j){
        this.player=j;
    }

    public Jogador getPlayer() {
        return player;
    }

    public void setPlayer(Jogador player) {
        this.player = player;
    }
    
}
