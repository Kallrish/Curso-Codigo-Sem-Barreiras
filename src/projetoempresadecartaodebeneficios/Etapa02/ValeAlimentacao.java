package projetoempresadecartaodebeneficios.Etapa02;

//Importa bibliotecas
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 02
 * Trabalho em grupo - Grupo JavAlelo.
 * Curso Java - Share RH & Alelo".
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas, Ana Paula Rodrigues,
 * @author Antônio Carlos, Natália, Karina, Giovanna, Cristovão, Sérgio.
 *
 * @version 2.5
 */

public class ValeAlimentacao extends CartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVA = 1;
  public static Integer incrementoIdentificadorTransacoesVA = 1;
  public static Boolean voltaMenuPrincipalVA = false;
  public static List<Transacao> listaTransacoesVA = new ArrayList<>();

  //Cria uma lista para armazenar as transações do VA
  public static List<ValeAlimentacao> listaCartoesVA = new ArrayList<>();

  //Construtor padrão
  public ValeAlimentacao() {
  }

  //Construtor com passagem de parâmetros para construir a lista
  public ValeAlimentacao(Integer identificadorCartao, String nomeBeneficiario, String senhaCartao,
                         Double saldoCartao, LocalDate dataDoCadastro, LocalDate validadeCartao) {

    this.identificadorCartao = identificadorCartao;
    this.saldoCartao = saldoCartao;
    this.senhaCartao = senhaCartao;
    this.dataDoCadastro = dataDoCadastro;
    this.validadeCartao = validadeCartao;
    this.nomeBeneficiario = nomeBeneficiario;
  }

  //Método para adicionar/vincular transação ao Vale Alimentação
  public static void adicionarTransacaoVA() {

    //Instancia a classe Scanner para receber entrada de dados do usuário
    Scanner in = new Scanner(System.in);

    //Cria as variáveis necessárias
    Integer identificadorDoCartao = 0;
    LocalDateTime dataDoCadastroTransacao;
    Double valorDaTransacao;
    LocalTime horaUltimaCompra;
    Double valorUltimaCompra;
    LocalTime horaPenultimaCompra;
    LocalDateTime dataHoraUltimaCompra;
    LocalDateTime dataHoraPenultimaCompra;
    Double saldoAtual = 0.00;
    String identicadorDoEstabelecimento;
    String localizacaoEstabelecimento;
    String tipoEstabelecimento;
    Integer escolhaEstabelecimento;
    String nome, senha;
    String codigoEstabelecimento = "";
    Character opcao = 's';
    Character opcao1 = 's';
    Integer opcao2;
    Integer index = ValeAlimentacao.listaTransacoesVA.size() - 1;
    Integer i;
    Integer verificaSituacaolistaTransacoes;
    String identificadorUltimoEstabelecimento;
    Integer iCerto = 0;
    Boolean verificador = false;
    LocalDate dataCadastroCartao;

    //Laço para verificar a lista de cartões
    do {
      ValeAlimentacao.voltaMenuPrincipalVA = false;
      ValeRefeicao.voltaMenuPrincipalVR = false;
      ValeCombustivel.voltaMenuPrincipalVC = false;
      //Solicita o nome e a senha para entrar no cadastro
      do {
        nome = null;
        senha = null;
        Ferramentas.imprimeLinhaDupla();
        System.out.println("= Menu -> Cadastrar: Transação -> Login                         =");
        Ferramentas.imprimeLinhaDupla();
        System.out.println("- Insira o nome do(a) beneficiário(a):                          -");
        System.out.print("- Nome: ");
        nome = in.nextLine().trim();
        Ferramentas.imprimeEspacador();
        System.out.println("- Digite uma senha para usar o cartão:                          -");
        System.out.print("- Senha: ");
        senha = in.nextLine().trim();
        Ferramentas.imprimeEspacador();

        //Verifica se já existem os dados de login informados
        for (i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {
          if (ValeAlimentacao.listaCartoesVA.get(i).nomeBeneficiario.equals(nome) &&
                  ValeAlimentacao.listaCartoesVA.get(i).senhaCartao.equals(senha)) {
            saldoAtual = ValeAlimentacao.listaCartoesVA.get(i).saldoCartao;
            iCerto = i;
            verificador = true;
            identificadorDoCartao = ValeAlimentacao.listaCartoesVA.get(iCerto).identificadorCartao;
            opcao = 'n';
          }
        }
        //Se os dados de login estão errados, pergunta se quer tentar novamente
        //ou se prefere retornar ao menu principal
        if (!verificador) {
          Ferramentas.imprimeLinha();
          System.out.println("- Nome e/ou senha estão incorretos!                             -");
          Ferramentas.imprimeLinha();
          System.out.println("- Deseja tentar digitar usuário e senha outra vez?              -");
          System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
          Ferramentas.imprimeLinha();
          System.out.print("- Opção: ");
          opcao = in.nextLine().trim().toLowerCase().charAt(0);
          Ferramentas.imprimeEspacador();
        }
      } while (opcao != 'n');


      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Menu -> Cadastrar: Transação no Vale Alimentação               =");
      Ferramentas.imprimeLinhaDupla();
      Ferramentas.imprimeEspacador();
      System.out.println("- Digite o código do estabelecimento onde foi efetuada a compra: -");
      System.out.println("- [1] - Posto Delta                                              -");
      System.out.println("- [2] - Mercearia São José                                       -");
      System.out.println("- [3] - Supermercado ABC                                         -");
      System.out.println("- [4] - Padaria Sonhos                                           -");
      System.out.println("- [5] - Restaurante La Marmita                                   -");
      System.out.print("- Código: ");
      escolhaEstabelecimento = in.nextInt();


      switch (escolhaEstabelecimento) {
        case 1 -> {
          codigoEstabelecimento = Estabelecimento.listaEstabelecimentos.get(0).identificadorEstabelecimento;
        }
        case 2 -> {
          codigoEstabelecimento = Estabelecimento.listaEstabelecimentos.get(1).identificadorEstabelecimento;
        }
        case 3 -> {
          codigoEstabelecimento = Estabelecimento.listaEstabelecimentos.get(2).identificadorEstabelecimento;
        }
        case 4 -> {
          codigoEstabelecimento = Estabelecimento.listaEstabelecimentos.get(3).identificadorEstabelecimento;
        }
        case 5 -> {
          codigoEstabelecimento = Estabelecimento.listaEstabelecimentos.get(4).identificadorEstabelecimento;
        }
        default -> {System.out.println("- Código não existe!                                             -");}
      }

      Ferramentas.imprimeEspacador();

      //Atribui dados da lista estabelecimento para cadastrar a transação na lista
      identicadorDoEstabelecimento = Estabelecimento.buscaEstabelecimento(codigoEstabelecimento);
      localizacaoEstabelecimento = Estabelecimento.buscaLocalizacaoEstabelecimento(codigoEstabelecimento);
      tipoEstabelecimento = Estabelecimento.buscaTipoEstabelecimento(codigoEstabelecimento);

      Ferramentas.imprimeEspacador();
      System.out.println("- Qual o valor da transação?                                    -");
      valorDaTransacao = in.nextDouble();
      Ferramentas.imprimeEspacador();

      //Variável pega o tamanho do array de transações para realizar verificação
      verificaSituacaolistaTransacoes = ValeAlimentacao.listaTransacoesVA.size();

      //Se o array de transações for nulo ou 1, realiza os processos necessários para o cadastro
      if (verificaSituacaolistaTransacoes <= 1) {
        dataCadastroCartao = ValeAlimentacao.listaCartoesVA.get(iCerto).dataDoCadastro;

        //Realiza verificações nos dados informados e roda o sistema anti-fraude

        //Regra específica 1 do VA: Verifica se é posto de combustível
        if (identicadorDoEstabelecimento.equals("Posto Delta")) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Não é possível usar este benefício neste estabelecimento!      -");
          Ferramentas.imprimeEspacador();

          //Verifica se é valor negativo
        } else if (valorDaTransacao < 0) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Digite um valor maior que zero!                                -");
          Ferramentas.imprimeEspacador();

          //Verifica a validade do cartão
        } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Cartão vencido! Não é possível realizar essa transação!        -");
          Ferramentas.imprimeEspacador();

          //Verifica se saldo é suficiente para transação
        } else if (valorDaTransacao > saldoAtual) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você não tem saldo suficiente para realizar esta operação!     -");
          Ferramentas.imprimeEspacador();

          //Se tudo está correto, finaliza o cadastro
        } else {
          dataDoCadastroTransacao = LocalDateTime.now();
          listaTransacoesVA.add(new Transacao(incrementoIdentificadorTransacoesVA++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  tipoEstabelecimento, valorDaTransacao));

          ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao -= valorDaTransacao;
          ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao += valorDaTransacao * 0.015;
          Double exibeSaldo = ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao;

          Ferramentas.imprimeLinha();
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
          System.out.printf("- Seu saldo atual: R$%.2f.", exibeSaldo);
          Ferramentas.imprimeEspacador();
        }

        //Se o array de transações for igual a 2, realiza os processos necessários para o cadastro
      } else if (verificaSituacaolistaTransacoes == 2) {
        dataCadastroCartao = ValeAlimentacao.listaCartoesVA.get(iCerto).dataDoCadastro;
        identificadorUltimoEstabelecimento = ValeAlimentacao.listaTransacoesVA.get(index).identicadorDoEstabelecimento;
        valorUltimaCompra = ValeAlimentacao.listaTransacoesVA.get(index).valorDaTransacao;
        dataHoraUltimaCompra = ValeAlimentacao.listaTransacoesVA.get(index).dataHoraTransacao;
        horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();

        //Regra específica 1 do VA: Verifica se é posto de combustível
        if (identicadorDoEstabelecimento.equals("Posto Delta")) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Não é possível usar este benefício neste estabelecimento!      -");
          Ferramentas.imprimeEspacador();

          //Verifica se é valor negativo
        } else if (valorDaTransacao < 0) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Digite um valor maior que zero!                                -");
          Ferramentas.imprimeEspacador();

          //Verifica a validade do cartão
        } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Cartão vencido! Não é possível realizar essa transação!        -");
          Ferramentas.imprimeEspacador();

          //Verifica se saldo é suficiente para transação
        } else if (valorDaTransacao > saldoAtual) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você não tem saldo suficiente para realizar esta operação!     -");
          Ferramentas.imprimeEspacador();

          //Verifica se houve duas compras do mesmo valor em menos de 30 segundos
        } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
                Ferramentas.verificaIdentificadorEstabelecimento(iCerto, identificadorUltimoEstabelecimento) &&
                Ferramentas.verificaValorVA(iCerto, valorUltimaCompra)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você só pode realizar uma transação de mesmo valor.            -");
          System.out.println("- a cada 30 segundos!                                            -");
          Ferramentas.imprimeEspacador();

          //Se tudo está correto, finaliza o cadastro
        } else {
          dataDoCadastroTransacao = LocalDateTime.now();
          listaTransacoesVA.add(new Transacao(incrementoIdentificadorTransacoesVA++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  tipoEstabelecimento, valorDaTransacao));

          ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao -= valorDaTransacao;
          ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao += valorDaTransacao * 0.015;
          Double exibeSaldo = ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao;

          Ferramentas.imprimeLinha();
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
          System.out.printf("- Seu saldo atual: R$%.2f.", exibeSaldo);
          Ferramentas.imprimeEspacador();
        }

        //Se o array de transações for maior que 2, realiza os processos necessários para o cadastro
      } else {

        dataCadastroCartao = ValeAlimentacao.listaCartoesVA.get(iCerto).dataDoCadastro;
        identificadorUltimoEstabelecimento = ValeAlimentacao.listaTransacoesVA.get(index).identicadorDoEstabelecimento;
        valorUltimaCompra = ValeAlimentacao.listaTransacoesVA.get(index).valorDaTransacao;
        dataHoraUltimaCompra = ValeAlimentacao.listaTransacoesVA.get(index).dataHoraTransacao;
        horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();
        dataHoraPenultimaCompra = ValeAlimentacao.listaTransacoesVA.get(index - 1).dataHoraTransacao;
        horaPenultimaCompra = dataHoraPenultimaCompra.toLocalTime();

        //Regra específica 1 do VA: Verifica se é posto de combustível
        if (identicadorDoEstabelecimento.equals("Posto Delta")) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Não é possível usar este benefício neste estabelecimento!      -");
          Ferramentas.imprimeEspacador();

          //Verifica se é valor negativo
        } else if (valorDaTransacao < 0) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Digite um valor maior que zero!                                -");
          Ferramentas.imprimeEspacador();

          //Verifica a validade do cartão
        } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Cartão vencido! Não é possível realizar essa transação!        -");
          Ferramentas.imprimeEspacador();

          //Verifica se saldo é suficiente para transação
        } else if (valorDaTransacao > saldoAtual) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você não tem saldo suficiente para realizar esta operação!     -");
          Ferramentas.imprimeEspacador();

          //Verifica se houve duas compras do mesmo valor em menos de 30 segundos
        } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
                Ferramentas.verificaIdentificadorEstabelecimento(iCerto, identificadorUltimoEstabelecimento) &&
                Ferramentas.verificaValorVA(iCerto, valorUltimaCompra)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você só pode realizar uma transação de mesmo valor.            -");
          System.out.println("- a cada 30 segundos!                                            -");
          Ferramentas.imprimeEspacador();

          //Verifica se houve três compras do mesmo valor em menos de 1 minuto
        } else if (Ferramentas.verificaTempoUmMinuto(horaPenultimaCompra)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você não pode realizar mais que duas compras em 1 minuto!      -");
          Ferramentas.imprimeEspacador();

          //Se tudo está correto, finaliza o cadastro
        } else {
          // Armazena os dados da transação no lista de transações
          dataDoCadastroTransacao = LocalDateTime.now();
          listaTransacoesVA.add(new Transacao(incrementoIdentificadorTransacoesVA++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  codigoEstabelecimento, valorDaTransacao));

          ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao -= valorDaTransacao;
          ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao += valorDaTransacao * 0.015;
          Double exibeSaldo = ValeAlimentacao.listaCartoesVA.get(iCerto).saldoCartao;

          Ferramentas.imprimeLinha();
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
          System.out.printf("- Seu saldo atual: R$%.2f.", exibeSaldo);
          Ferramentas.imprimeEspacador();
        }

      }

      //Laço que verifica se o cliente quer cadastr novamente usando o mesmo usuário e vale, ou
      //se ele quer trocar de usuário para cadastrar mais em um vale ou se retorna para o menu principal.
      do {
        Ferramentas.imprimeLinha();
        System.out.println("- Escolha uma opção:                                             -");
        System.out.println("- [1] Inserir nova transação                                     -");
        System.out.println("- [2] Retorna ao menu principal                                  -");
        Ferramentas.imprimeEspacador();
        System.out.print("- Opção: ");
        opcao2 = in.nextInt();

        switch (opcao2) {
          case 1 -> opcao1 = 'n';
          case 2 -> {
            opcao1 = 'n';
            ValeAlimentacao.voltaMenuPrincipalVA = true;
            ValeRefeicao.voltaMenuPrincipalVR = true;
            ValeCombustivel.voltaMenuPrincipalVC = true;
          }
          default -> System.out.println("Escolha uma opção válida!                           -");
        }
        Ferramentas.imprimeEspacador();
      } while (opcao2 < 1 || opcao2 > 3);

    } while (opcao1 != 'n');

    Ferramentas.imprimeEspacador();
  }

  //Método para mostrar o saldo de forma formatada ao usuário
  public static void mostrarSaldo(Double saldoAtual1) {
    Ferramentas.imprimeEspacador();
    System.out.printf("- Vale Alimentação: R$%.2f.%n", saldoAtual1);
    Ferramentas.imprimeEspacador();
  }

  public static void adicionaSaldoVA(Integer index, Double valor) {
    Double pegaValorAtual = ValeAlimentacao.listaCartoesVA.get(index).saldoCartao;
    ValeAlimentacao.listaCartoesVA.get(index).saldoCartao = pegaValorAtual + valor;
  }
}