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

  //Cria uma lista para armazenar as transações do VA
  public static List<ValeAlimentacao> listaCartoesVA = new ArrayList<>();

  public ValeAlimentacao() {

  }

  public ValeAlimentacao(Integer identificadorCartao, String nomeBeneficiario, String senhaCartao,
                         Double saldoCartao, LocalDate dataDoCadastro, LocalDate validadeCartao) {

    this.identificadorCartao = identificadorCartao;
    this.saldoCartao = saldoCartao;
    this.senhaCartao = senhaCartao;
    this.criaDataDeCadastro();
    this.criaDataDeValidade();
    this.nomeBeneficiario = nomeBeneficiario;
  }

  public void cadastrarVA() {

    try (Scanner in = new Scanner(System.in)) {

      String nome, senha;
      char opcao = 's';
      LocalDate data1, data2;

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Cadastrar: Vale Alimentação");
        System.out.println("==================================================================\n");
        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nome = in.nextLine().trim();
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("Digite uma senha para usar o cartão:");
        System.out.print("Senha: ");
        senha = in.nextLine().trim();

        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < Beneficiario.listaBeneficiarios.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().equals(nome)) {

            //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
            this.identificadorCartao = incrementoIdentificadorVA;

            //this.senhaCartao = senhaCartao;
            this.senhaCartao = senha;

            Double valorAleatorioSaldo = Ferramentas.valorAleatorioEntre200e100();
            this.saldoCartao = valorAleatorioSaldo;
            this.criaDataDeCadastro();
            data1 = this.dataDoCadastro;
            data2 = this.validadeCartao;
            this.criaDataDeValidade();
            listaCartoesVA.add(new ValeAlimentacao(incrementoIdentificadorVA++, nome, senha,
                    valorAleatorioSaldo, data1, data2));

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("Deseja cadastrar outro beneficiário?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);

            //Retorna mensagem de erro caso não encontra o benefiário
          } else {
            System.out.println("\n-----------------------------------------------------------------\n");
            System.out.printf("Não foi possível realizar o cadastro.%nBeneficiário %s não encontrado!%n", nome);
            System.out.println("Deseja cadastrar outro beneficiário?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
          }

        }
      } while (opcao == 's');
      Ferramentas.inicializaMenuPrincipal();
    }
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
  public void adicionarTransacao() {
    Integer identificadorDoCartao = 0;

    try (Scanner in = new Scanner(System.in)) {

      String nome, senha;
      char opcao = 's';
      LocalDate data1, data2;
      index = listaTransacoes.size() - 1;

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Cadastrar: Transação -> Login");
        System.out.println("==================================================================\n");
        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nome = in.nextLine().trim();
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Digite uma senha para usar o cartão:");
        System.out.print("Senha: ");
        senha = in.nextLine().trim();

        for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().contains(nome) &&
                  ValeAlimentacao.listaCartoesVA.get(i).getSenhaVA().contains(senha)) {

            identificadorDoCartao = listaCartoesVA.get(i).identificadorCartao;

            System.out.println("\n==================================================================");
            System.out.println("Menu -> Cadastrar: Transação no Vale Alimentação");
            System.out.println("==================================================================\n");
            String continua;

            do {

              LocalDate dataCadastroCartao = ValeAlimentacao.listaCartoesVA.get(i).dataDoCadastro;
              String identificadorUltimoEstabelecimento = ValeAlimentacao.listaTransacoes.get(index).getIdenticadorDoEstabelecimento();
              Double valorUltimaCompra = ValeAlimentacao.listaTransacoes.get(index).getValorDaTransacao();

              LocalDateTime dataHoraUltimaCompra = ValeAlimentacao.listaTransacoes.get(index).getDataHoraTransacao();
              LocalDateTime dataHoraPenultimaCompra = ValeAlimentacao.listaTransacoes.get(index - 1).getDataHoraTransacao();
              LocalTime horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();
              LocalTime horaPenultimaCompra = dataHoraPenultimaCompra.toLocalTime();

              //TODO verificar a entrada abaixo - switch-case
              System.out.println("Digite o código do estabelecimento onde foi efetuada a compra: " +
                      "[PO01] - Posto Delta" +
                      "[ME01] - Mercearia São José" +
                      "[SU01] - Supermercado ABC" +
                      "[PA01] - Padaria Sonhos" +
                      "[RE01] - Restaurante La Marmita\n");
              System.out.print("Código: ");
              String codigoEstabelecimento = in.nextLine().trim();

              String identicadorDoEstabelecimento = Estabelecimento.buscaEstabelecimento(codigoEstabelecimento);
              String localizacaoEstabelecimento = Estabelecimento.buscaLocalizacaoEstabelecimento(codigoEstabelecimento);

              System.out.println("Qual o valor da transação?");
              Double valorDaTransacao = in.nextDouble();

              //Regra específica 1 do VA: Verifica se é posto de combustível
              if (identicadorDoEstabelecimento.contains("Posto Delta")) {
                System.out.println("Não é possível usar este benefício neste estabelecimento!\n");

                //Verifica se é valor negativo
              } else if (valorDaTransacao < 0) {
                System.out.println("Digite um valor maior que zero!\n");

                //Verifica a validade do cartão
              } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
                System.out.println("Cartão vencido! Não é possível realizar essa transação!\n");

                //Verifica se saldo é suficiente para transação
              } else if (valorDaTransacao > this.saldoCartao) {
                System.out.println("Você não tem saldo suficiente para realizar esta operação!\n");

                //Verifica se houve duas compras do mesmo valor em menos de 30 segundos
              } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
                      Ferramentas.verificaIdentificadorEstabelecimento(i, identificadorUltimoEstabelecimento) &&
                      Ferramentas.verificaValorVA(i, valorUltimaCompra)) {
                System.out.println("Você só pode realizar uma transação de mesmo valor a cada 30 segundos!\n");

                //Verifica se houve três compras do mesmo valor em menos de 1 minuto
              } else if (Ferramentas.verificaTempoUmMinuto(horaPenultimaCompra)) {
                System.out.println("Você não pode realizar mais que duas compras em 1 minuto!\n");

              } else {
                // Armazena os dados da transação no lista de transações
                LocalDateTime dataDoCadastroTransacao = LocalDateTime.now();
                listaTransacoes.add(new Transacao(incrementoIdentificadorTransacoesVA++, nome, identificadorDoCartao,
                        dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                        codigoEstabelecimento, valorDaTransacao));

                this.saldoCartao -= valorDaTransacao;
                this.saldoCartao += valorDaTransacao * 0.015;

                System.out.println("\n---------------------------------------------------------------\n");
                System.out.printf("Compra efetuada com sucesso!%n");
                System.out.printf("Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
                System.out.printf("Seu saldo atual: R$%.2f.", this.saldoCartao);
              }

              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.println("Deseja cadastrar outra transação?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              opcao = in.nextLine().trim().toLowerCase().charAt(0);
            } while (opcao != 'n');
            Ferramentas.inicializaMenuPrincipal();

          } else {
            System.out.println("\n-----------------------------------------------------------------\n");
            System.out.println("Nome e/ou senha estão incorretos!%n");
            System.out.println("Deseja tentar digitar usuário e senha outra vez?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
          }
        }
      } while (opcao == 's');
      Ferramentas.inicializaMenuPrincipal();
    }
  }

  @Override
  public void mostrarSaldo(Double saldoAtual1) {

    System.out.printf("Vale Alimentação: R$%.2f.%n", saldoAtual1);
  }

  public Double getSaldoVA() {
    return saldoCartao;
  }

  public LocalDate getDatadoCadastroVA() {
    return dataDoCadastro;
  }

  public LocalDate getValidadeCartaoVA() {
    return validadeCartao;
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

  public void adicionaSaldoVA(Double valor) {this.saldoCartao += valor;}
}