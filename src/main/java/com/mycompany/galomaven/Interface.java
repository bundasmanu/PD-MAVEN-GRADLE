/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.galomaven;

import java.util.Scanner;

/**
 *
 * @author Armando
 */
public class Interface {
    
    private Galo galo;
    private Scanner sc =new Scanner(System.in);
    private boolean sair=false;
    
    public Interface(){
        this.galo=new Galo();
    }
    
    /*MENUS DE INTERACCAO COM OS UTILIZADORES DA APLICACAO*/
    public void interaccaoBeginState(){
        
            char c;              
            String option;
            
            System.out.print("(Q)uit , (N)ome Jogadores, (C)omeca Jogo\n");
            option = sc.next().toUpperCase();

            if(option.length() >= 1){
                c = option.charAt(0);
            }else{
                c = ' ';
            }
        
            switch(c){
                case 'N':
                    for(int i=0;i<2;++i){
                        System.out.println("\nIntroduza o nome do Jogador\n");
                        String name;
                        name=sc.next();
                        this.galo.setPlayersName(name);
                    }
                    break;
                case 'C': 
                    this.galo.comecaJogo();
                    if(this.galo.getEstado() instanceof Inicio){
                        System.out.println("\nO numero de jogadores tem de estar em concordancia com os jogadores");
                    }
                    break;
                case 'Q':
                    this.sair=true;
                    break;
                default: 
                    break;
            }   
            
        
    }
    
    public void interacaoColocaPeca(){
        
            char c;              
            String option;
            
            System.out.print("(Q)uit , (C)oloca Nova Peca Tabuleiro , (I)nfo\n");
            option = sc.next().toUpperCase();

            if(option.length() >= 1){
                c = option.charAt(0);
            }else{
                c = ' ';
            }
        
            switch(c){
                case 'C': 
                    try{
                        System.out.println("\nIntroduza a linha onde pretende inserir a peca\n");
                        int linha=sc.nextInt();
                        System.out.println("\nIntroduza a coluna onde pretende inserir a peca\n");
                        int coluna=sc.nextInt();
                        this.galo.colocaPeca(linha, coluna);
                    }
                    catch(Exception e){
                        break;
                    }
                    break;
                case 'I':    
                    System.out.println(this.galo.mostraTab());
                    break;
                case 'Q':
                    this.sair=true;
                    break;
                default: 
                    break;
            }  
        
    }
    
    /*METODO QUE APLICA TODA A LOGICA DO JOGO, RECORRENDO Ã€ INTERACCAO COM OS UTILIZADORES*/
    public void run(){
        
        do{
            
            if(this.galo.getEstado() instanceof Inicio){
                this.interaccaoBeginState();
            }
            
            else if(this.galo.getEstado() instanceof Joga){
                this.interacaoColocaPeca();
            }
            
            else{
               sair=true;
            }
            
        }while(sair==false);
        
    }

    
}
