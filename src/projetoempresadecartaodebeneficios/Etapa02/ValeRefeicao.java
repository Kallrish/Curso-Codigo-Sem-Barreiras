package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;

public class ValeRefeicao extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

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
  public void adicionarTransacao(Double valor, Integer identificadorEstabelecimento, String tipoEstabelecimento) {

      //Verifica se é valor negativo
      if (valor < 0) {
      System.out.println("Digite um valor maior que zero!");

      //Verifica a validade do cartão
    } else if (!Ferramentas.verificaValidade(pega data do cadastro do cartao)) {
      System.out.println("Cartão vencido! Não é possível realizar essa transação!");

      //Verifica se saldo é suficiente para transação
    } else if (valor > this.saldoCartao) {
      System.out.println("Você não tem saldo suficiente para realizar esta operação!");

    } else if (!Ferramentas.verificaTempoSegundos(pega registro datahora da ultima compra) &&
            Ferramentas.verificaEstabalecimento(pega registro ultimo estabelecimento) &&
            Ferramentas.verificaValor (pega registro valor ultima compra)) {

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

  @Override
  public void mostrarSaldo() {

    System.out.printf("Seu saldo atual é: R$%.2f.", this.saldoCartao);
  }
}
