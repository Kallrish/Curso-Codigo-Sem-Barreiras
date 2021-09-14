package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ValeCombustivel extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVC = 1;
  int index = 0;

  //Instancia classes necessárias
  Beneficiario beneficiario = new Beneficiario();

  //Cria uma lista para armazenar as transações do VA
  public static List<ValeCombustivel> listaCartoesVC = new ArrayList<>();

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

    //Regra específica 1 do VC: Verifica se é posto de combustível
    if (!tipoEstabelecimento.equals("Posto_combustível")) {
      System.out.println("Não é possível usar este benefício neste estabelecimento!");

      //Verifica se é valor negativo
    } else if (valor < 0) {
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
      System.out.println("Você só pode realizar uma transação de mesmo valor a cada 30 segundos!");

    } else if () {
      System.out.println("Você não pode realizar mais que duas compras em 1 minuto!");

      ////Regra específica 2 do VC: Uma compra a cada 2 minutos
    } else if (!Ferramentas.verificaTempoDoisMinutos(pega registro datahora da ultima compra)) {
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
  }

  @Override
  public void mostrarSaldo (Double saldoAtual2){

    System.out.printf("Vale Combustível: R$%.2f.%n", saldoAtual2);
  }

  public Double getSaldoVC() {
    return saldoCartao;
  }
}