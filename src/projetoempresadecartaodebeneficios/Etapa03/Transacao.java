package projetoempresadecartaodebeneficios.Etapa03;

//Importa bibliotecas/classes necessárias para o programa

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 03
 * Trabalho individual.
 * Case Alelo.
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas Silva Ribeiro
 * @version 1.0
 */
public abstract class Transacao {

  //Atributos obrigatórios da entidade
  public String numeroDaTransacao;
  public LocalDateTime dataHoraTransacao;
  public String numeroDoCartao;
  public String cnpjDoEstabelecimentoComercial;
  public String produto;
  public Double valorDaTransacao;
  public Double valorDeCashback;

  //Método para contar segundos entre transações
  public static Integer contaSegundosEntreTransacoes(LocalDateTime horaDaCompra) {
    LocalDateTime horaAtual = LocalDateTime.now();
    return (int) ChronoUnit.SECONDS.between(horaDaCompra, horaAtual);
  }

}