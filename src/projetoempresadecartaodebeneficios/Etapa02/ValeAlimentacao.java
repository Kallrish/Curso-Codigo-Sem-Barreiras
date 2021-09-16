package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValeAlimentacao extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVA = 1;
  public static Integer incrementoIdentificadorTransacoesVA = 1;
  int index = 0;
  LocalDate data1, data2;

  //Cria uma lista para armazenar as transações do VA
  public static List<ValeAlimentacao> listaCartoesVA = new ArrayList<>();

  public ValeAlimentacao() {

  }

  public ValeAlimentacao(Integer identificadorCartao, String nomeBeneficiario, String senhaCartao,
                         Double saldoCartao, LocalDate dataDoCadastro, LocalDate validadeCartao) {

    this.identificadorCartao = identificadorCartao;
    this.saldoCartao = saldoCartao;
    this.senhaCartao = senhaCartao;
    this.dataDoCadastro = data1;
    this.validadeCartao = data2;
    this.nomeBeneficiario = nomeBeneficiario;
  }

  @Override
  public void adicionarTransacao() {
    Integer identificadorDoCartao = 0;
    LocalTime horaUltimaCompra = null;
    Double valorUltimaCompra = 0.00;
    LocalTime horaPenultimaCompra = null;

    Scanner in = new Scanner(System.in);

    String nome, senha;
    char opcao = 's';
    char opcao1 = 's';
    LocalDate data1, data2;
    index = listaTransacoes.size() - 1;
    int i = 0;
    String identificadorUltimoEstabelecimento = "";
    String continua;
    int iCerto = 0;

    do {
      System.out.println("=================================================================");
      System.out.println("= Menu -> Cadastrar: Transação -> Login                         =");
      System.out.println("=================================================================");
      System.out.println("- Insira o nome do(a) beneficiário(a):                          -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      System.out.println("-                                                               -");
      System.out.println("- Digite uma senha para usar o cartão:                          -");
      System.out.print("- Senha: ");
      senha = in.nextLine().trim();
      System.out.println("-                                                               -");

      boolean verificador = false;

      for (i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {

        //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
        if (listaCartoesVA.get(i).getNomeBeneficiarioVA().equals(nome) &&
                listaCartoesVA.get(i).getSenhaVA().equals(senha)) {
          iCerto = i;
          verificador = true;
        }
      }

      identificadorDoCartao = listaCartoesVA.get(iCerto).identificadorCartao;

      System.out.println("==================================================================");
      System.out.println("= Menu -> Cadastrar: Transação no Vale Alimentação               =");
      System.out.println("==================================================================");
      System.out.println("-                                                                -");
      if (verificador) {
        LocalDate dataCadastroCartao = listaCartoesVA.get(iCerto).dataDoCadastro;
        if (listaCartoesVA.size() > 1) {
          identificadorUltimoEstabelecimento = listaTransacoes.get(index).getIdenticadorDoEstabelecimento();
          valorUltimaCompra = listaTransacoes.get(index).getValorDaTransacao();
          LocalDateTime dataHoraUltimaCompra = listaTransacoes.get(index).getDataHoraTransacao();
          horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();
          if (listaCartoesVA.size() > 2) {
            LocalDateTime dataHoraPenultimaCompra = listaTransacoes.get(index - 1).getDataHoraTransacao();

            horaPenultimaCompra = dataHoraPenultimaCompra.toLocalTime();
          }
        }

        System.out.println("-                                                                -");
        System.out.println("- Digite o código do estabelecimento onde foi efetuada a compra: -");
        System.out.println("- [PO01] - Posto Delta                                           -");
        System.out.println("- [ME01] - Mercearia São José                                    -");
        System.out.println("- [SU01] - Supermercado ABC                                      -");
        System.out.println("- [PA01] - Padaria Sonhos                                        -");
        System.out.println("- [RE01] - Restaurante La Marmita                                -");
        System.out.print("- Código: ");
        String codigoEstabelecimento = in.nextLine().trim();
        System.out.println("-                                                                -");

        String identicadorDoEstabelecimento = Estabelecimento.buscaEstabelecimento(codigoEstabelecimento);
        String localizacaoEstabelecimento = Estabelecimento.buscaLocalizacaoEstabelecimento(codigoEstabelecimento);

        System.out.println("-                                                                -");
        System.out.println("- Qual o valor da transação?                                     -");
        System.out.println("-                                                                -");
        Double valorDaTransacao = in.nextDouble();

        //Regra específica 1 do VA: Verifica se é posto de combustível
        if (identicadorDoEstabelecimento.equals("Posto Delta")) {
          System.out.println("-                                                                -");
          System.out.println("- Não é possível usar este benefício neste estabelecimento!      -");
          System.out.println("-                                                                -");

          //Verifica se é valor negativo
        } else if (valorDaTransacao < 0) {
          System.out.println("-                                                                -");
          System.out.println("- Digite um valor maior que zero!                                -");
          System.out.println("-                                                                -");

          //Verifica a validade do cartão
        } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
          System.out.println("-                                                                -");
          System.out.println("- Cartão vencido! Não é possível realizar essa transação!        -");
          System.out.println("-                                                                -");

          //Verifica se saldo é suficiente para transação
        } else if (valorDaTransacao > this.saldoCartao) {
          System.out.println("-                                                                -");
          System.out.println("- Você não tem saldo suficiente para realizar esta operação!     -");
          System.out.println("-                                                                -");

          //Verifica se houve duas compras do mesmo valor em menos de 30 segundos
        } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
                Ferramentas.verificaIdentificadorEstabelecimento(iCerto, identificadorUltimoEstabelecimento) &&
                Ferramentas.verificaValorVA(iCerto, valorUltimaCompra)) {
          System.out.println("-                                                                -");
          System.out.println("- Você só pode realizar uma transação de mesmo valor.            -");
          System.out.println("- a cada 30 segundos!                                            -");
          System.out.println("-                                                                -");

          //Verifica se houve três compras do mesmo valor em menos de 1 minuto
        } else if (Ferramentas.verificaTempoUmMinuto(horaPenultimaCompra)) {
          System.out.println("-                                                                -");
          System.out.println("- Você não pode realizar mais que duas compras em 1 minuto!      -");
          System.out.println("-                                                                -");

        } else {
          // Armazena os dados da transação no lista de transações
          LocalDateTime dataDoCadastroTransacao = LocalDateTime.now();
          listaTransacoes.add(new Transacao(incrementoIdentificadorTransacoesVA++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  codigoEstabelecimento, valorDaTransacao));

          this.saldoCartao -= valorDaTransacao;
          this.saldoCartao += valorDaTransacao * 0.015;

          System.out.println("------------------------------------------------------------------");
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
          System.out.printf("- Seu saldo atual: R$%.2f.", this.saldoCartao);
          System.out.println("-                                                                -");
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("- Deseja cadastrar outra transação?                              -");
        System.out.println("-                                                                -");
        System.out.print("- Opção: ");
        opcao = in.nextLine().trim().toLowerCase().charAt(0);
        System.out.println("-                                                                -");

        verificador = false;

      }
      while (opcao != 'n') ;

      if (!verificador) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("- Nome e/ou senha estão incorretos!                             -");
      }
      System.out.println("------------------------------------------------------------------");
      System.out.println("- Deseja tentar digitar usuário e senha outra vez?               -");
      System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
      System.out.println("------------------------------------------------------------------");
      System.out.print("- Opção: ");
      opcao = in.nextLine().trim().toLowerCase().charAt(0);
      System.out.println("-                                                                -");
    } while (opcao1 == 's');

  }


  public static void mostrarSaldo(Double saldoAtual1) {
    System.out.println("-                                                                -");
    System.out.printf("- Vale Alimentação: R$%.2f.%n", saldoAtual1);
    System.out.println("-                                                                -");
  }


  public LocalDate getDatadoCadastroVA() {
    return dataDoCadastro;
  }

  public void setValidadeCartaoVA(LocalDate validadeCartao) {
    this.validadeCartao = validadeCartao;
  }

  public String getNomeBeneficiarioVA() {
    return nomeBeneficiario;
  }

  public String getSenhaVA() {
    return senhaCartao;
  }

  public static void adicionaSaldoVA(Integer index, Double valor) {
    Double pegaValorAtual = ValeAlimentacao.listaCartoesVA.get(index).saldoCartao;
    ValeAlimentacao.listaCartoesVA.get(index).saldoCartao = pegaValorAtual + valor;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof ValeAlimentacao))
      return false;

    if (obj == this)
      return true;

    ValeAlimentacao p = (ValeAlimentacao) obj;

    // Aqui você implementa como deve se feita a comparação.
    // Verifica se os nomes dos produtos são iguais, ids e etc.

    if (p.nomeBeneficiario == this.nomeBeneficiario) {
      return true;
    } else {
      return false;
    }
  }
}