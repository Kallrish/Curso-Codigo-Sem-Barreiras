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

public class ValeRefeicao extends CartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVR = 1;
  public static Integer incrementoIdentificadorTransacoesVR = 1;
  public static Boolean voltaMenuPrincipalVR = false;

  //Cria uma lista para armazenar as transações do VR
  public static List<ValeRefeicao> listaCartoesVR = new ArrayList<>();
  public static List<Transacao> listaTransacoesVR = new ArrayList<>();

  //Construtor padrão
  public ValeRefeicao() {}

  //Construtor com passagem de parâmetros para construir a lista
  public ValeRefeicao(Integer identificadorCartao, String nomeBeneficiario, String senhaCartao,
                         Double saldoCartao, LocalDate dataDoCadastro, LocalDate validadeCartao) {

    this.identificadorCartao = identificadorCartao;
    this.saldoCartao = saldoCartao;
    this.senhaCartao = senhaCartao;
    this.dataDoCadastro = dataDoCadastro;
    this.validadeCartao = validadeCartao;
    this.nomeBeneficiario = nomeBeneficiario;
  }

  //Método para adicionar/vincular transação ao Vale Alimentação
  public static void adicionarTransacaoVR() {

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
    String codigoEstabelecimento = "";
    String nome = "", senha;
    Character opcao = 's';
    Character opcao1 = 's';
    Integer opcao2;
    Boolean senhaOK = false;
    Integer index = ValeRefeicao.listaTransacoesVR.size() - 1;
    Integer i;
    Integer verificaSituacaoListaTransacoes;
    String identificadorUltimoEstabelecimento;
    Integer iCerto = 0;
    Boolean verificador = false;
    LocalDate dataCadastroCartao;

    //Laço para verificar a lista de cartões
    do {
      ValeAlimentacao.voltaMenuPrincipalVA = false;
      ValeRefeicao.voltaMenuPrincipalVR = false;
      ValeCombustivel.voltaMenuPrincipalVC = false;
      //Se a senha não está correta, retorna para solicitar novamente
      //Se a senha está OK, pula direto para cadastrar transações a partir da segunda vez no laço
      if (!senhaOK) {

        //Solicita o nome e a senha para entrar no cadastro
        do {
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
          for (i = 0; i < ValeRefeicao.listaCartoesVR.size(); i++) {
            if (ValeRefeicao.listaCartoesVR.get(i).nomeBeneficiario.equals(nome) &&
                    ValeRefeicao.listaCartoesVR.get(i).senhaCartao.equals(senha)) {
              saldoAtual = ValeRefeicao.listaCartoesVR.get(i).saldoCartao;
              iCerto = i;
              verificador = true;
              identificadorDoCartao = ValeRefeicao.listaCartoesVR.get(iCerto).identificadorCartao;
              senhaOK = true;
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
      }

      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Menu -> Cadastrar: Transação no Refeição                   =");
      Ferramentas.imprimeLinhaDupla();
      Ferramentas.imprimeEspacador();
      System.out.println("- Digite o código do estabelecimento onde foi efetuada a compra: -");
      System.out.println("- [1] Posto Delta                                              -");
      System.out.println("- [2] Mercearia São José                                       -");
      System.out.println("- [3] Supermercado ABC                                         -");
      System.out.println("- [4] Padaria Sonhos                                           -");
      System.out.println("- [5] Restaurante La Marmita                                   -");
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

      //Atribui dados da lista estabelecimento para cadastrar a transação na lista
      identicadorDoEstabelecimento = Estabelecimento.buscaEstabelecimento(codigoEstabelecimento);
      localizacaoEstabelecimento = Estabelecimento.buscaLocalizacaoEstabelecimento(codigoEstabelecimento);
      tipoEstabelecimento = Estabelecimento.buscaTipoEstabelecimento(codigoEstabelecimento);

      Ferramentas.imprimeEspacador();
      System.out.println("- Qual o valor da transação?                                    -");
      valorDaTransacao = in.nextDouble();
      Ferramentas.imprimeEspacador();

      //Variável pega o tamanho do array de transações para realizar verificação
      verificaSituacaoListaTransacoes = ValeRefeicao.listaTransacoesVR.size();

      //Se o array de transações for nulo ou 1, realiza os processos necessários para o cadastro
      if (verificaSituacaoListaTransacoes <= 1) {
        dataCadastroCartao = ValeRefeicao.listaCartoesVR.get(iCerto).dataDoCadastro;

        //Realiza verificações nos dados informados e roda o sistema anti-fraude

        //Regra específica 1 do VR: Verifica se é posto de combustível
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
          listaTransacoesVR.add(new Transacao(incrementoIdentificadorTransacoesVR++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  tipoEstabelecimento, valorDaTransacao));

          ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao -= valorDaTransacao;
          ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao += valorDaTransacao * 0.015;
          Double exibeSaldo = ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao;

          Ferramentas.imprimeLinha();
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
          System.out.printf("- Seu saldo atual: R$%.2f.", exibeSaldo);
          Ferramentas.imprimeEspacador();
        }

        //Se o array de transações for igual a 2, realiza os processos necessários para o cadastro
      } else if (verificaSituacaoListaTransacoes == 2) {
        dataCadastroCartao = ValeRefeicao.listaCartoesVR.get(iCerto).dataDoCadastro;
        identificadorUltimoEstabelecimento = ValeRefeicao.listaTransacoesVR.get(index).identicadorDoEstabelecimento;
        valorUltimaCompra = ValeRefeicao.listaTransacoesVR.get(index).valorDaTransacao;
        dataHoraUltimaCompra = ValeRefeicao.listaTransacoesVR.get(index).dataHoraTransacao;
        horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();

        //Regra específica 1 do VR: Verifica se é posto de combustível
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
                Ferramentas.verificaValorVR(iCerto, valorUltimaCompra)) {
          Ferramentas.imprimeEspacador();
          System.out.println("- Você só pode realizar uma transação de mesmo valor.            -");
          System.out.println("- a cada 30 segundos!                                            -");
          Ferramentas.imprimeEspacador();

          //Se tudo está correto, finaliza o cadastro
        } else {
          dataDoCadastroTransacao = LocalDateTime.now();
          listaTransacoesVR.add(new Transacao(incrementoIdentificadorTransacoesVR++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  codigoEstabelecimento, valorDaTransacao));

          ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao -= valorDaTransacao;
          ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao += valorDaTransacao * 0.015;
          Double exibeSaldo = ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao;

          Ferramentas.imprimeLinha();
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.", valorDaTransacao * 0.015);
          System.out.printf("- Seu saldo atual: R$%.2f.", exibeSaldo);
          Ferramentas.imprimeEspacador();
        }

        //Se o array de transações for maior que 2, realiza os processos necessários para o cadastro
      } else {

        dataCadastroCartao = ValeRefeicao.listaCartoesVR.get(iCerto).dataDoCadastro;
        identificadorUltimoEstabelecimento = ValeRefeicao.listaTransacoesVR.get(index).identicadorDoEstabelecimento;
        valorUltimaCompra = ValeRefeicao.listaTransacoesVR.get(index).valorDaTransacao;
        dataHoraUltimaCompra = ValeRefeicao.listaTransacoesVR.get(index).dataHoraTransacao;
        horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();
        dataHoraPenultimaCompra = ValeRefeicao.listaTransacoesVR.get(index - 1).dataHoraTransacao;
        horaPenultimaCompra = dataHoraPenultimaCompra.toLocalTime();

        //Verifica valor negativo
        if (valorDaTransacao < 0) {
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
                Ferramentas.verificaValorVR(iCerto, valorUltimaCompra)) {
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
          listaTransacoesVR.add(new Transacao(incrementoIdentificadorTransacoesVR++, nome, identificadorDoCartao,
                  dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                  tipoEstabelecimento, valorDaTransacao));

          ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao -= valorDaTransacao;
          ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao += valorDaTransacao * 0.03;
          Double exibeSaldo = ValeRefeicao.listaCartoesVR.get(iCerto).saldoCartao;

          Ferramentas.imprimeLinha();
          System.out.println("- Compra efetuada com sucesso!                                   -");
          System.out.printf("- Você recebeu R$%.2f de cashback.%n", valorDaTransacao * 0.03);
          System.out.printf("- Seu saldo atual: R$%.2f.%n", exibeSaldo);
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
    System.out.printf("- Vale Refeição: R$%.2f.%n", saldoAtual1);
    Ferramentas.imprimeEspacador();
  }

  public static void adicionaSaldoVR(Integer index, Double valor) {
    Double pegaValorAtual = ValeRefeicao.listaCartoesVR.get(index).saldoCartao;
    ValeRefeicao.listaCartoesVR.get(index).saldoCartao = pegaValorAtual + valor;
  }
}