package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValeRefeicao extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVR = 1;
  public static Integer incrementoIdentificadorTransacoesVR = 1;
  int index = 0;

  //Cria uma lista para armazenar as transações do VR
  public static List<ValeRefeicao> listaCartoesVR = new ArrayList<>();

  public ValeRefeicao() {

  }

  public ValeRefeicao(Integer identificadorCartao, String nomeBeneficiario, String senhaCartao,
                      Double saldoCartao, LocalDate dataDoCadastro, LocalDate validadeCartao) {

    this.identificadorCartao = identificadorCartao;
    this.saldoCartao = saldoCartao;
    this.senhaCartao = senhaCartao;
    this.criaDataDeCadastro();
    this.criaDataDeValidade();
    this.nomeBeneficiario = nomeBeneficiario;
  }


  public void cadastrarVR() {

    Scanner in = new Scanner(System.in);

      String nome, senha;
      char opcao = 's';
      LocalDate data1, data2;

      do {
        System.out.println("==================================================================");
        System.out.println("Menu -> Cadastrar: Vale Refeição");
        System.out.println("==================================================================");
        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nome = in.nextLine().trim();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Digite uma senha para usar o cartão:");
        System.out.print("Senha: ");
        senha = in.nextLine().trim();

        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < Beneficiario.listaBeneficiarios.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().equals(nome)) {

            //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
            this.identificadorCartao = incrementoIdentificadorVR;

            //this.senhaCartao = senhaCartao;
            this.senhaCartao = senha;

            Double valorAleatorioSaldo = Ferramentas.valorAleatorioEntre200e1000();
            this.saldoCartao = valorAleatorioSaldo;
            this.criaDataDeCadastro();
            data1 = this.dataDoCadastro;
            data2 = this.validadeCartao;
            this.criaDataDeValidade();
            listaCartoesVR.add(new ValeRefeicao(incrementoIdentificadorVR++, nome, senha,
                    valorAleatorioSaldo, data1, data2));

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Deseja cadastrar outro beneficiário?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);

            //Retorna mensagem de erro caso não encontra o beneficiário
          } else {
            System.out.println("-----------------------------------------------------------------");
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

    Scanner in = new Scanner(System.in);

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

        for (int i = 0; i < ValeRefeicao.listaCartoesVR.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lista
          if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().equals(nome) &&
                  ValeRefeicao.listaCartoesVR.get(i).getSenhaVR().equals(senha)) {

            identificadorDoCartao = listaCartoesVR.get(i).identificadorCartao;

            System.out.println("\n==================================================================");
            System.out.println("Menu -> Cadastrar: Transação no Vale Refeição");
            System.out.println("==================================================================\n");
            String continua;

            do {

              LocalDate dataCadastroCartao = ValeRefeicao.listaCartoesVR.get(i).dataDoCadastro;
              String identificadorUltimoEstabelecimento = ValeRefeicao.listaTransacoes.get(index).getIdenticadorDoEstabelecimento();
              Double valorUltimaCompra = ValeRefeicao.listaTransacoes.get(index).getValorDaTransacao();

              LocalDateTime dataHoraUltimaCompra = ValeRefeicao.listaTransacoes.get(index).getDataHoraTransacao();
              LocalDateTime dataHoraPenultimaCompra = ValeRefeicao.listaTransacoes.get(index - 1).getDataHoraTransacao();
              LocalTime horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();
              LocalTime horaPenultimaCompra = dataHoraPenultimaCompra.toLocalTime();

              System.out.println("Digite o código do estabelecimento onde foi efetuada a compra: " +
                      "[PO01] - Posto Delta" +
                      "[ME01] - Mercearia São José" +
                      "[SU01] - Supermercado ABC" +
                      "[PA01] - Padaria Sonhos" +
                      "[RE01] - Restaurante La Marmita");
              String codigoEstabelecimento = in.nextLine().trim();

              String identicadorDoEstabelecimento = Estabelecimento.buscaEstabelecimento(codigoEstabelecimento);
              String localizacaoEstabelecimento = Estabelecimento.buscaLocalizacaoEstabelecimento(codigoEstabelecimento);

              System.out.println("Qual o valor da transação?");
              Double valorDaTransacao = in.nextDouble();

              //Verifica se é valor negativo
              if (valorDaTransacao < 0) {
                System.out.println("Digite um valor maior que zero!");

                //Verifica a validade do cartão
              } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
                System.out.println("Cartão vencido! Não é possível realizar essa transação!");

                //Verifica se saldo é suficiente para transação
              } else if (valorDaTransacao > this.saldoCartao) {
                System.out.println("Você não tem saldo suficiente para realizar esta operação!");

                //Verifica se houve duas compras do mesmo valor em menos de 30 segundos
              } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
                      Ferramentas.verificaIdentificadorEstabelecimento(i, identificadorUltimoEstabelecimento) &&
                      Ferramentas.verificaValorVR(i, valorUltimaCompra)) {
                System.out.println("Você só pode realizar uma transação de mesmo valor a cada 30 segundos!");

                //Verifica se houve três compras do mesmo valor em menos de 1 minuto
              } else if (Ferramentas.verificaTempoUmMinuto(horaPenultimaCompra)) {
                System.out.println("Você não pode realizar mais que duas compras em 1 minuto!");

              } else {
                // Armazena os dados da transação no lista de transações
                LocalDateTime dataDoCadastroTransacao = LocalDateTime.now();
                listaTransacoes.add(new Transacao(incrementoIdentificadorTransacoesVR++, nome, identificadorDoCartao,
                        dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                        codigoEstabelecimento, valorDaTransacao));
                this.saldoCartao -= valorDaTransacao;
                this.saldoCartao += valorDaTransacao * 0.03;

                System.out.println("\n---------------------------------------------------------------");
                System.out.printf("Compra efetuada com sucesso!%n");
                System.out.printf("Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.03);
                System.out.printf("Seu saldo atual: R$%.2f.", this.saldoCartao);

              }

              System.out.println("-----------------------------------------------------------------");
              System.out.println("Deseja cadastrar outra transação?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              opcao = in.nextLine().trim().toLowerCase().charAt(0);

            } while (opcao != 'n');
            Ferramentas.inicializaMenuPrincipal();

          } else {
            System.out.println("-----------------------------------------------------------------");
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

  @Override
  public void mostrarSaldo(Double saldoAtual1) {

    System.out.printf("Vale Refeição: R$%.2f.%n", saldoAtual1);
  }

  public Double getSaldoVR() {
    return saldoCartao;
  }

  public LocalDate getDatadoCadastroVR() {
    return dataDoCadastro;
  }

  public String getNomeBeneficiarioVR() {
    return nomeBeneficiario;
  }

  public String getSenhaVR() {
    return senhaCartao;
  }

  public void adicionaSaldoVR(Double valor) {this.saldoCartao += valor;}

  public LocalDate getValidadeCartaoVR() {
    return validadeCartao;
  }

  public void setValidadeCartaoVR(LocalDate validadeCartao) {
    this.validadeCartao = validadeCartao;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof ValeCombustivel))
      return false;

    if (obj == this)
      return true;

    ValeCombustivel p = (ValeCombustivel) obj;

    // Aqui você implementa como deve se feita a comparação.
    // Verifica se os nomes dos produtos são iguais, ids e etc.

    if (p.nomeBeneficiario == this.nomeBeneficiario) {
      return true;
    } else {
      return false;
    }
  }
}