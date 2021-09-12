package projetoempresadecartaodebeneficios.Etapa02;

public class ValeCombustivel extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

  @Override
  public void adicionarTransacao(Double valor, Integer identificadorEstabelecimento, String tipoEstabelecimento) {

    //Regra específica 1 do VC: Verifica se é posto de combustível
    if (!tipoEstabelecimento.equals("Posto_combustível")) {
      System.out.println("Não é possível usar este benefício neste estabelecimento!");

      //Verifica se é valor negativo
    } else if (valor < 0) {
      System.out.println("Digite um valor maior que zero!");

      //Verifica a validade do cartão
    } else if (!verificaValidade(pega data do cadastro do cartao)) {
      System.out.println("Cartão vencido! Não é possível realizar essa transação!");

      //Verifica se saldo é suficiente para transação
    } else if (valor > this.saldoCartao) {
      System.out.println("Você não tem saldo suficiente para realizar esta operação!");

    } else if (!verificaTempoSegundos(pega registro datahora da ultima compra) &&
            verificaEstabalecimento(pega registro ultimo estabelecimento) &&
            verificaValor (pega registro valor ultima compra)) {
      System.out.println("Você só pode realizar uma transação de mesmo valor a cada 30 segundos!");

    } else if () {
      System.out.println("Você não pode realizar mais que duas compras em 1 minuto!");

    ////Regra específica 2 do VC: Uma compra a cada 2 minutos
    } else if (!verificaTempoDoisMinutos(pega registro datahora da ultima compra)) {
      System.out.println("Você só pode realizar uma transação a cada 2 minutos!");

    } else {
    this.saldoCartao -= valor;
    //Regra específica 3 do VC: Desconta R$1 de taxa do saldo.
    this.saldoCartao -= 1.00;

    //TODO adiciona essa transação no arraylist de transações do usuário

    System.out.println("Compra efetuada com sucesso!");
    System.out.println("Você pagou uma taxa de R$1,00 pelo abastecimento.");
    System.out.printf("Seu saldo atual: R$%.2f.", this.saldoCartao);
  }

  @Override
  public void mostrarSaldo() {

    System.out.printf("Seu saldo atual é: R$%.2f.", this.saldoCartao);
  }
}
