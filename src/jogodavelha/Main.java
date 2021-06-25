/*Jogo da Velha em Java */
package jogodavelha;

import java.util.Scanner;

/**
 * @since 2021.06.24
 * @author irion-silva
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        JV jogo = new JV();
        String posicao;
        int valida = 0;
        int Jogadas = 0;

        while (true) {
            System.out.println(":::::JOGO DA VELHA:::::");
            jogo.mostrar();

            do {
                System.out.print("Jogador 1, informe uma posição: ");
                posicao = teclado.next();
                while (!jogo.Valido(posicao)) {
                    System.out.println("Jogada inválida, tente novamente!");
                    System.out.print("Jogador 1, informe uma posição: ");
                    posicao = teclado.next();
                    valida = 0;
                }
                jogo.Jogada(posicao, "X");
                valida = 1;
            } while (valida == 0);
            
            Jogadas++;
            valida = 0;
            jogo.mostrar();
            if(!jogo.Ganhou(Jogadas).equals("null")){
                break;
            }
            
            do {
                System.out.print("Jogador 2, informe uma posição: ");
                posicao = teclado.next();
                while (!jogo.Valido(posicao)) {
                    System.out.println("Jogada inválida, tente novamente!");
                    System.out.print("Jogador 2, informe uma posição: ");
                    posicao = teclado.next();
                    valida = 0;
                }
                jogo.Jogada(posicao, "O");
                valida = 1;
            } while (valida == 0);
            
            Jogadas++;
            valida = 0;
            jogo.mostrar();
            if(!jogo.Ganhou(Jogadas).equals("null")){
                break;
            }
        }
        //System.out.println("O "+jogo.Ganhou(Jogadas)+" venceu!");
        if (jogo.Ganhou(Jogadas).equals("JOGADOR 1")) {
            System.out.println("O "+jogo.Ganhou(Jogadas)+" venceu!");
        } else if (jogo.Ganhou(Jogadas).equals("JOGADOR 2")) {
            System.out.println("O "+jogo.Ganhou(Jogadas)+" venceu!");
        } else {
            System.out.println("EMPATOU");
        }
    }
}
