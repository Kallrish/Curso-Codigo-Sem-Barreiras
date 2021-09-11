package parte02_06composicaoagregacao.Exercicio02;

//Importa a classe Scanner para receber entrada do usuário

import java.util.Scanner;

/** Classe com a implementação "parte 02" do "exercício04" do material "02classeseobjetos".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class Televisao {

  //Cria e inicializa as variáveis necessárias
  Integer volume = 1, canal = 1;

  boolean ligado = false, escolhaValidaMenu, escolhaValidaSubMenu;

  //Cria getters and setters
  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public Integer getCanal() {
    return canal;
  }

  public void setCanal(Integer canal) {
    this.canal = canal;
  }

  public boolean isLigado() {
    return ligado;
  }

  public void setLigado(boolean ligado) {
    this.ligado = ligado;
  }

  public boolean isEscolhaValidaMenu() {
    return escolhaValidaMenu;
  }

  public void setEscolhaValidaMenu(boolean escolhaValidaMenu) {
    this.escolhaValidaMenu = escolhaValidaMenu;
  }

  public boolean isEscolhaValidaSubMenu() {
    return escolhaValidaSubMenu;
  }

  public void setEscolhaValidaSubMenu(boolean escolhaValidaSubMenu) {
    this.escolhaValidaSubMenu = escolhaValidaSubMenu;
  }

  //Método para iniciar a televisão, mostrar as opções disponíveis e receber entrada do usuário
  //enquanto a televisão estiver ligada.
  public void iniciaTelevisao() {

    //Uso do try para controlar a abertura e fechamento do scanner na memória
    try (Scanner in = new Scanner(System.in)) {

      do {
        var ctrl1 = new ControleRemoto();

        System.out.println("\nControle da televisão");
        System.out.println("Digite uma das opções abaixo:");
        System.out.println("1 - Ligar a TV");
        System.out.println("2 - Aumentar o volume");
        System.out.println("3 - Diminuir o volume");
        System.out.println("4 - Aumentar o canal");
        System.out.println("5 - Diminuir o canal");
        System.out.println("6 - Ir para um canal específico");
        System.out.println("7 - Exibir canal e volume atual");
        System.out.println("8 - Desligar a TV");
        System.out.println("9 - Encerrar sistema do controle remoto");
        int opcao1 = in.nextInt();
        System.out.println();

        switch (opcao1) {
          case 1 -> ctrl1.ligaTelevisao();
          case 2 -> ctrl1.aumentarVolume();
          case 3 -> ctrl1.diminuirVolume();
          case 4 -> ctrl1.aumentarCanal();
          case 5 -> ctrl1.diminuirCanal();
          case 6 -> ctrl1.irParaCanalEspecifico();
          case 7 -> ctrl1.canalEVolumeAtual();
          case 8 -> ctrl1.desligaTelevisao();
          case 9 -> System.exit(0);
          default -> System.out.println("Escolha um número entre 1 a 8!");
        }
      } while (!escolhaValidaMenu);
    }
  }
}
