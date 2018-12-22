
import com.mycompany.galomaven.Galo;
import com.mycompany.galomaven.Inicio;
import com.mycompany.galomaven.Joga;
import static java.lang.System.in;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armando
 */
public class TestInterface {
 
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private Galo galo;
    private Scanner sc =new Scanner(in);
    private boolean sair=false;
    
    	private static final String CHAR_LIST = 
		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	
	/**
	 * This method generates random string
	 * @return
	 */
	public String generateRandomString(){
        
            StringBuffer randStr = new StringBuffer();
            for(int i=0; i<RANDOM_STRING_LENGTH; i++){
        	int number = getRandomNumber();
        	char ch = CHAR_LIST.charAt(number);
        	randStr.append(ch);
            }
        return randStr.toString();
    }
        
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    
    private int generateRandomInt0_2(){
        
        int intervalo=3-0;
        return(int) (Math.random() * intervalo) + 0;
        
    }
    
    public TestInterface(){
        this.galo=new Galo();
    }
    
    /*MENUS DE INTERACCAO COM OS UTILIZADORES DA APLICACAO*/
    public void interaccaoBeginState(){
        
            char c;              
            String option;
            
            for(int i=0;i<2;++i){
                String n=this.generateRandomString();
                this.galo.setPlayersName(n);
            }
            
            this.galo.comecaJogo();
            if(this.galo.getEstado() instanceof Inicio){
                System.out.println("\nO numero de jogadores tem de estar em concordancia com os jogadores");
            }
   
    }
    
    public void interacaoColocaPeca(){
        
        System.out.println("\nIntroduza a linha onde pretende inserir a peca\n");
        int linha=this.generateRandomInt0_2();
        System.out.println("\nIntroduza a coluna onde pretende inserir a peca\n");
        int coluna=this.generateRandomInt0_2();
        this.galo.colocaPeca(linha, coluna);
        System.out.println(this.galo.getJ().listaTabuleiroApenas());
 
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
               //System.out.println(this.galo.mostraTab()); 
               sair=true;
            }
            
        }while(sair==false);
        
    }
 
}
