package projetoempresadecartaodebeneficios.Etapa03;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 03
 * Trabalho individual.
 * Case Alelo.
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas Silva Ribeiro
 * @version 2.5
 */
public class Main {

  /**
   * Executa o programa principal.
   */
  public static void main(String[] args) {

    EstabelecimentoComercial.inicializaEstabelecimentoComercial();
    PortadorDoCartao.inicializaPortador();
    Utilidades.inicializaCartao();
    Utilidades.inicializaMenu();
  }
}
