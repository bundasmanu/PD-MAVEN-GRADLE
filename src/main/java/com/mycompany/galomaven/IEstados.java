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
public interface IEstados {
    
    boolean setPlayersName(String name);
    IEstados comecaJogo();
    IEstados colocaPeca(int x, int y);
    String mostraTabuleiro();
    IEstados sair();
    
}
