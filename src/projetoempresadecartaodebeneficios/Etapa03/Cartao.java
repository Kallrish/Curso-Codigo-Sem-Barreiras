package projetoempresadecartaodebeneficios.Etapa03;

//Importa bibliotecas/classes necessárias para o programa

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 03
 * Trabalho individual.
 * Case Alelo.
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas Silva Ribeiro
 * @version 1.0
 */
public abstract class Cartao {

  //Atributos obrigatórios da entidade
  public Integer idCartao;
  public String numeroDoCartao;
  public String cpfDoPortador;
  public String dataDeValidade;
  public String codigoDeSeguranca;
  public String tipoDeCartao;
  public String senha;
  public Double saldo;

  public static ArrayList<TransacaoAleloAlimentacao> listaTransacaoAleloAlimentacao = new ArrayList<>();

  //Retira os espaços da String, caso não sejam digitados só números
  public static String removeCaracteresEspeciaisNumeroCartao(String documento) {

    documento = documento.trim();
    if (documento.contains(" "))
      documento = documento.replace(" ", "");

    return documento;
  }

  //Gera um número aleatório de cartão com 16 dígitos
  public static String geraNumeroAleatorioParaCartao() {

    //Variáveis necessárias
    Random aleatorio = new Random();
    Integer numeroTemporario, numeroTemporario2;
    String parte1, parte2, parteFinal;

    numeroTemporario = aleatorio.nextInt(99999999);
    numeroTemporario2 = aleatorio.nextInt(99999999);
    parte1 = Integer.toString(numeroTemporario);
    parte2 = Integer.toString(numeroTemporario2);
    parteFinal = parte1 + parte2;

    return parteFinal;
  }

  //Gera um número aleatório de CVV com 3 dígitos
  public static String geraCVVAleatorioParaCartao() {

    //Variáveis necessárias
    Random aleatorio = new Random();
    Integer numeroTemporario;
    String parteFinal;

    numeroTemporario = aleatorio.nextInt(999);
    parteFinal = Integer.toString(numeroTemporario);

    return parteFinal;
  }

}
