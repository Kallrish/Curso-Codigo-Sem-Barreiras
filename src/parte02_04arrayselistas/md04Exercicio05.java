package parte02_04arrayselistas;

//Importa o pacote necessário para receber entrada pelo usuário

import java.util.Random;
import java.util.Scanner;

/**
 * Classe com a implementação da "parte 02" do "exercício05" do material "03arrayselistas".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 */
public class md04Exercicio05 {
  /**
   * Gerencia todas as configurações e métodos necessários para rodar o jogo Forca.
   */
  public static class ConfigForca {

    //Cria a lista com as opções disponíveis de palavras
    String[] opcoes = {"elefante", "noite", "passarinho", "rato", "meia"
            , "asterisco", "esquerdo", "fugaz", "pororoca"
            , "tenue", "manjericao", "pneumonia", "rotatoria"
            , "trilogia", "galaxia"};

    //Instancia o objeto da classe Random para gerar a palavra randômica
    Random quantidade = new Random();

    //Cria as variáveis necessáirias
    String palavraEscolhida;
    int tamanhoDaPalavra;
    String palavraTentativa = "";
    int quantidadeLetrasAcertadas;
    boolean palavraCorreta;
    String letraJaEscolhida;
    int tentativas;
    char letra;
    char continua;

    public void novoJogo() {

      palavraTentativa = "";
      letraJaEscolhida = "";

      //Cria um número aleatório e para escolhar qual será a palavra na lista
      //Recebe a palavra escolhida para a sessão do jogo
      palavraEscolhida = opcoes[quantidade.nextInt(opcoes.length)];

      //Recebe o tamanho da palavra escolhida
      tamanhoDaPalavra = palavraEscolhida.length();

      //Preenche a string com "X" para equivaler as letras não reveladas
      for (int i = 0; i < tamanhoDaPalavra; i++) {
        palavraTentativa += "_";
        letraJaEscolhida += "_";
      }

      //Informa o número de acertos até o momento
      quantidadeLetrasAcertadas = 0;

      //Mantém o laço ativo até receber verdadeiro
      palavraCorreta = false;

      //Contabiliza a quantidade de tentativas disponíveis
      tentativas = 10;

      //Solicita ao usuário a quantidade de números que ele quer na lista
      System.out.println("|-------------------------------------------|");
      System.out.println("|                                           |");
      System.out.println("|             JOGO DA FORCA!                |");
      System.out.println("|                                           |");
      System.out.println("|===========================================|");
      System.out.printf("|  > A palavra selecionada %2d tem letras! < |\n", tamanhoDaPalavra);
      System.out.println("|===========================================|");
      System.out.println();
    }

    public void comecaForca() {

      //Instancia o objeto in para receber as entradas do usuário
      try (Scanner in = new Scanner(System.in)) {

        //Laço para verificar as tentativas de inserir a letra certa
        while (tentativas > 0 && !palavraCorreta) {

          //Valida o caso de haver acerto de alguma letra na palavra
          boolean houveAcerto = false;
          boolean letraRepetida = false;

          System.out.println("|-------------------------------------------|");
          System.out.println("| Digite uma letra:                         |");
          System.out.println("|-------------------------------------------|");
          System.out.print(">");
          letra = in.next().trim().toLowerCase().charAt(0);

          for (int j = 0; j < tamanhoDaPalavra; j++) {

            if (letra == letraJaEscolhida.charAt(j)) {
              letraRepetida = true;
              System.out.println("|===========================================|");
              System.out.printf("|                 %10s                |\n", palavraTentativa);
              System.out.println("|===========================================|");
              System.out.println("|                                           |");
              System.out.println("|        VOCÊ JÁ DIGITOU ESSA LETRA!        |");
              System.out.println("|               TENTE OUTRA!                |");
              System.out.println("|                                           |");
              break;

            } else if (palavraEscolhida.charAt(j) == letra) {

//          Usa a função StringBuilder para alterar o char com X para a letra acertada
              StringBuilder revelaLetra = new StringBuilder(palavraTentativa);
              revelaLetra.setCharAt(j, palavraEscolhida.charAt(j));
              palavraTentativa = revelaLetra.toString();
              letraJaEscolhida = revelaLetra.toString();

//            Com o uso de string
//              palavraTentativa[i] = String.valueOf(palavraEscolhida.charAt(i));

              //Houve acerto recebe true para não reduzir tentativas e aumenta o contador
              //de letras acertadas
              houveAcerto = true;
              quantidadeLetrasAcertadas++;
            }
          }

          //Se não houve acertos, reduz a quantidade de tentativas
          if (!houveAcerto && letraRepetida == false) {
            tentativas--;
          }

          //Se a qtd de letras certas equivale ao tamanho da palavra, recebe true para encerrar o laço
          if (quantidadeLetrasAcertadas == tamanhoDaPalavra) {
            palavraCorreta = true;
          }

          if (palavraCorreta) {

            //Informa ao jogador que ele acertou a palavra e dá parabéns
            System.out.println("|===========================================|");
            System.out.println("|              P.A.R.A.B.É.N.S!             |");
            System.out.println("|===========================================|");
            System.out.println("|                                           |");
            System.out.println("|     Você acertou a palavra! Muito bem!    |");
            System.out.println("|                                           |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|                                           |");
            System.out.println("|             Deseja continuar?             |");
            System.out.println("|    Digite \"s\" para SIM e \"n\" para não.    |");
            System.out.print(">");
            continua = in.next().trim().toLowerCase().charAt(0);

            if (continua == 's') {
              //Reinicia o jogo com uma nova palavra
              novoJogo();
            } else {
              //Agradece ao jogador, finaliza o jogo
              System.out.println("|===========================================|");
              System.out.println("|            Obrigado por jogar!            |");
              System.out.println("|===========================================|");
            }

          } else if (tentativas == 0) {

            //Informa ao jogador que ele acertou a palavra e dá parabéns
            System.out.println("|===========================================|");
            System.out.println("|           QUE PENA, VOCÊ PERDEU!          |");
            System.out.println("|===========================================|");
            System.out.println("|                                           |");
            System.out.println("|               A palavra era:              |");
            System.out.printf("|                 %10s                |\n", palavraTentativa);
            System.out.println("|                                           |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|                                           |");
            System.out.println("|             Deseja continuar?             |");
            System.out.println("|      Digite \"s\" para SIM ou outra       |");
            System.out.println("|     ou qualquer outra letra pra sair.     |");
            System.out.print(">");
            continua = in.next().trim().toLowerCase().charAt(0);

            if (continua == 's') {
              //Reinicia o jogo com uma nova palavra
              novoJogo();
            } else {
              //Agradece ao jogador, finaliza o jogo
              System.out.println("|===========================================|");
              System.out.println("|            Obrigado por jogar!            |");
              System.out.println("|===========================================|");
            }

          } else if (!letraRepetida) {
            //Retorna ao usuário a palavra escondida com os caracteres que foram acertados
            //e informa quantas tentativas restam
            System.out.println("|-------------------------------------------|");
            System.out.printf("|                 %10s                |\n", palavraTentativa);
            System.out.println("|===========================================|");
            System.out.printf("|  Até o momento você acertou %2d letra(s)!  |\n", quantidadeLetrasAcertadas);
            System.out.printf("|         Você possui %2d restantes.         |\n", tentativas);
            System.out.println("|===========================================|");
            System.out.println("|                                           |");

          }
        }
      }
    }
  }

  /**
   * Roda o programa principal
   */
  public static void main(String[] args) {
    //Instancia o objeto forca para receber herdar as configurações
    //e invoca os métodos para iniciar o jogo.
    ConfigForca forca = new ConfigForca();
    forca.novoJogo();
    forca.comecaForca();
  }
}