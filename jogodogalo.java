
import java.util.Scanner;


public class HelloWorld {

    public static void main(String[] args) {
        //print(System.out);


            boolean vitoria = false;
            int tamanho_tabuleiro = 3;
            int casa;
            int casaslivres = tamanho_tabuleiro * tamanho_tabuleiro;
            Scanner teclado_user = new Scanner(System.in);

            //matriz bidimensional

            String matriz[][] = new String[tamanho_tabuleiro][tamanho_tabuleiro];

            for (int l = 0; l < matriz.length; l++) {
                for (int c = 0; c < matriz[0].length; c++) {
                    matriz[l][c] = " ";
                }
            }

            System.out.print("Qual é o 1º jogador a jogar(x ou o)?\n");
            String jogador = teclado_user.nextLine();

            while (!vitoria && (casaslivres > 0)) {
                boolean jogada_valida = true;

                System.out.print("Introduza o número da casa que quer jogar\n");
                casa = teclado_user.nextInt();

                casa = casa - 1;

                int linha = casa % tamanho_tabuleiro;
                int coluna = casa / tamanho_tabuleiro;

                //validar jogada
                if (matriz[linha][coluna] == " ") {
                    matriz[linha][coluna] = jogador;
                    casaslivres = casaslivres - 1;
                } else {
                    jogada_valida = false;
                }

                System.out.println(" " + matriz[0][0] + " | " + matriz[1][0] + " | " + matriz[2][0]);
                System.out.println("---+---+---");
                System.out.println(" " + matriz[0][1] + " | " + matriz[1][1] + " | " + matriz[2][1]);
                System.out.println("---+---+---");
                System.out.println(" " + matriz[0][2] + " | " + matriz[1][2] + " | " + matriz[2][2]);

                //trocar de jogador
                if (jogada_valida) {
                    //condições de vitória
                    int d1_t_count = 0, d2_t_count = 0;
                    for (int l = 0; l < tamanho_tabuleiro; l++) {
                        int col_t_count = 0, line_t_count = 0;
                        for (int c = 0; c < tamanho_tabuleiro; c++) {
                            // Horizontais e verticais
                            if (matriz[l][c].equals(jogador)) {
                                col_t_count++;
                            }

                            if (matriz[c][l].equals(jogador)) {
                                line_t_count++;
                            }

                        }
                        if (col_t_count == tamanho_tabuleiro || line_t_count == tamanho_tabuleiro) {
                            vitoria = true;
                            break;
                        }


                        // Diagonais
                        if (matriz[l][l].equals(jogador)) {
                            d1_t_count++;
                        }
                        if (matriz[l][tamanho_tabuleiro - l - 1].equals(jogador)) {
                            d2_t_count++;
                        }
                    }

                    if (d1_t_count == tamanho_tabuleiro || d2_t_count == tamanho_tabuleiro) {
                        vitoria = true;
                    }

                    if (!vitoria) {
                        if (jogador.equals("x")) {
                            jogador = "o";
                        } else {
                            jogador = "x";
                        }
                    }
                }
            }

            if (vitoria) {
                System.out.println("O jogador " + jogador + " ganhou!Parabéns :)");
            } else {
                System.out.println("Empate!");
            }
        }
    }


