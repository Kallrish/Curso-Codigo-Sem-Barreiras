package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ValeRefeicao extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVR = 1;
  int index = 0;

  //Instancia classes necessárias
  Beneficiario beneficiario = new Beneficiario();

  //Cria uma lista para armazenar as transações do VA
  public static List<ValeRefeicao> listaCartoesVR = new ArrayList<>();

  public ValeRefeicao() {

  }

  @Override
  public void criaDataDeCadastro() {

    //Cria a data de cadastro pegando a data atual do momento do cadastro
    this.dataDoCadastro = LocalDate.now();

  }

  @Override
  public void criaDataDeValidade() {

    //Cria a validade do cartão, definindo 2 anos como padrão.
    this.validadeCartao = this.dataDoCadastro.plusYears(2);

  }

  @Override
  public void adicionarTransacao(String nomeBeneficiario, Double valor, Integer identificadorEstabelecimento, String tipoEstabelecimento) {

    //Verifica se é valor negativo
    if (valor < 0) {
      System.out.println("Digite um valor maior que zero!");

      //Verifica a validade do cartão
    } else if (!Ferramentas.verificaValidade(pega data do cadastro do cartao)){
      System.out.println("Cartão vencido! Não é possível realizar essa transação!");

      //Verifica se saldo é suficiente para transação
    } else if (valor > this.saldoCartao) {
      System.out.println("Você não tem saldo suficiente para realizar esta operação!");

    } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
            Ferramentas.verificaIdentificadorEstabelecimento(i, identificadorUltimoEstabelecimento) &&
            Ferramentas.verificaValorVA(i, valorUltimaCompra)) {

    } else if () {
      System.out.println("Você não pode realizar mais que duas compras em 1 minuto!");

    } else {
      this.saldoCartao -= valor;
      this.saldoCartao += valor * 0.03;

      //TODO adiciona essa transação no arraylist de transações do usuário

      System.out.printf("Compra efetuada com sucesso!%n");
      System.out.printf("Você recebeu R$%.2f de cashback.", valor * 0.03);
      System.out.printf("Seu saldo atual: R$%.2f.", this.saldoCartao);
    }
  }

  @Override
  public void mostrarSaldo(Double saldoAtual3) {

    System.out.printf("Vale Refeição: R$%.2f.%n", saldoAtual3);
  }

  public Double getSaldoVR() {
    return saldoCartao;
  }
}
