package projetoempresadecartaodebeneficios.Etapa02;

//Importa bibliotecas

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 02
 * Trabalho em grupo - Grupo JavAlelo.
 * Curso Java - Share RH & Alelo".
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas, Ana Paula Rodrigues,
 * @author Antônio Carlos, Natália, Karina, Giovanna, Cristovão, Sérgio.
 * @version 2.5
 */

public class Ferramentas {
  //Verifica se passou 30 segundos desde a última transação do cartão
  //True se passou, false se ainda precisa esperar
  public static boolean verificaTempoSegundos(LocalTime ultimaCompra) {

    long tempoQuePassou = ChronoUnit.SECONDS.between(ultimaCompra, LocalTime.now());

    return tempoQuePassou > 30;
  }

  //Verifica se passou 1 minutos desde a última transação do cartão
  //True se passou, false se ainda precisa esperar
  public static boolean verificaTempoUmMinuto(LocalTime penultimaCompra) {

    long tempoQuePassou = ChronoUnit.MINUTES.between(penultimaCompra, LocalTime.now());

    return tempoQuePassou > 1;
  }

  //Verifica se passou 2 minutos desde a última transação do cartão
  //True se passou, false se ainda precisa esperar
  public static boolean verificaTempoDoisMinutos(LocalTime ultimaCompra) {

    long tempoQuePassou = ChronoUnit.MINUTES.between(ultimaCompra, LocalTime.now());

    return tempoQuePassou > 2;
  }

  //Verifica a data de validade do cartão
  //Retorna TRUE se estiver válido e FALSE se estiver vencido
  public static boolean verificaValidade(LocalDate dataValida) {

//    public LocalDate validadeCartao;
    //Pega a data do cadastro e aumenta dois anos (validade do cartão)
    LocalDate data1 = dataValida.plusYears(2);
    //Pega a data de hoje
    LocalDate data2 = LocalDate.now();

    return data2.isBefore(data1);
  }

  public static Double valorAleatorioEntre200e1000() {

    Random aleatorio = new Random();
    Double valor;
    Integer valor1 = aleatorio.nextInt(1000 - 200) + 200;
    valor = Double.valueOf(valor1);
    return valor;
  }

  public static Boolean verificaIdentificadorEstabelecimento(Integer index4, String identificador1) {

    return Estabelecimento.listaEstabelecimentos.get(index4).identificadorEstabelecimento.equals(identificador1);
  }

  public static Boolean verificaValorVA(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeAlimentacao.listaTransacoesVA.get(index4).valorDaTransacao;
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.equals(valorComparacaoString2);
  }

  public static Boolean verificaValorVR(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeRefeicao.listaTransacoesVR.get(index4).valorDaTransacao;
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.equals(valorComparacaoString2);
  }

  public static Boolean verificaValorVC(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeCombustivel.listaTransacoesVC.get(index4).valorDaTransacao;
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.equals(valorComparacaoString2);
  }

  //Método para gerenciar o submenu 2: cadastro de cartões
  public static void cadastrarCartoesBeneficio() {

    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Cadastrar: Novos cartões de benefício                 =");
    Ferramentas.imprimeLinhaDupla();

    Scanner in = new Scanner(System.in);

    //Declara variáveis necessárias
    String nome, senha;
    LocalDate data1, data2;
    char opcao;

    int i;

    do {
      Ferramentas.imprimeLinhaDupla();
      System.out.println("Menu -> Cadastrar: Vale Alimentação");
      Ferramentas.imprimeLinhaDupla();
      System.out.println("- Insira o nome do(a) beneficiário(a):                          -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      Ferramentas.imprimeEspacador();
      System.out.println("- Digite uma senha para usar o cartão:                          -");
      System.out.print("- Senha: ");
      senha = in.nextLine().trim();
      Ferramentas.imprimeEspacador();

      boolean verificador = false;

      //Laço para percorrer a lista de beneficiários
      for (i = 0; i < Beneficiario.listaBeneficiarios.size(); i++) {

        //Se encontra o beneficiário, armazena dados nas variáveis para passar por
        //parâmetro na criação da lista
        if (Beneficiario.listaBeneficiarios.get(i).nomeBeneficiario.equals(nome)) {
          verificador = true;

          //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
          Integer identificadorCartao = ValeAlimentacao.incrementoIdentificadorVA++;
          Double saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
          data1 = LocalDate.now();
          data2 = LocalDate.now().plusYears(2);

          ValeAlimentacao.listaCartoesVA.add(new ValeAlimentacao(identificadorCartao, nome, senha,
                  saldoCartao, data1, data2));

          Ferramentas.imprimeLinha();
          System.out.println("- Cadastro realizado com sucesso!                               -");
          Ferramentas.imprimeLinha();
          Ferramentas.imprimeEspacador();
          Ferramentas.imprimeLinhaDupla();
          System.out.println("= Menu -> Cadastrar: Vale Refeição                              =");
          Ferramentas.imprimeLinhaDupla();
          System.out.println("- Digite uma senha para usar o cartão:                          -");
          System.out.print("- Senha: ");
          senha = in.nextLine().trim();
          Ferramentas.imprimeEspacador();

          //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
          identificadorCartao = ValeRefeicao.incrementoIdentificadorVR++;
          saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
          data1 = LocalDate.now();
          data2 = LocalDate.now().plusYears(2);

          ValeRefeicao.listaCartoesVR.add(new ValeRefeicao(identificadorCartao, nome, senha,
                  saldoCartao, data1, data2));

          Ferramentas.imprimeLinha();
          System.out.println("- Cadastro realizado com sucesso!                               -");
          Ferramentas.imprimeLinha();
          Ferramentas.imprimeEspacador();
          Ferramentas.imprimeLinhaDupla();
          System.out.println("- Menu -> Cadastrar: Vale Combustível                           -");
          Ferramentas.imprimeLinhaDupla();
          System.out.println("- Digite uma senha para usar o cartão:                          -");
          System.out.print("- Senha: ");
          senha = in.nextLine().trim();
          Ferramentas.imprimeLinha();

          //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
          identificadorCartao = ValeCombustivel.incrementoIdentificadorVC++;
          saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
          data1 = LocalDate.now();
          data2 = LocalDate.now().plusYears(2);

          ValeCombustivel.listaCartoesVC.add(new ValeCombustivel(identificadorCartao, nome, senha,
                  saldoCartao, data1, data2));

          Ferramentas.imprimeLinha();
          System.out.println("- Cadastro realizado com sucesso!                               -");
          Ferramentas.imprimeLinha();

          //Retorna mensagem de erro caso não encontra o beneficiário
        }

      }

      if (!verificador && i == Beneficiario.listaBeneficiarios.size()) {
        Ferramentas.imprimeLinha();
        System.out.println("- Não foi possível realizar o cadastro.                         -");
        System.out.println("- Beneficiário não existe ou cartão já existe!                  -");
        Ferramentas.imprimeEspacador();
      }
      Ferramentas.imprimeLinha();
      System.out.println("- Deseja tentar digitar outro nome?                             -");
      System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
      Ferramentas.imprimeLinha();
      System.out.print("- Opção: ");
      opcao = in.nextLine().trim().toLowerCase().charAt(0);
      Ferramentas.imprimeEspacador();
    } while (opcao == 's');
  }

  //Método que cadastra os cartões na primeira vez que o programa é executado
  public static void cadastrarCartoesBeneficioPrimeiravez() {

    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Cadastrar: Novos cartões de benefício                   =");
    Ferramentas.imprimeLinhaDupla();
    Ferramentas.imprimeEspacador();

    Scanner in = new Scanner(System.in);

    //Declara variáveis necessárias
    String nome, senha;
    LocalDate data1, data2;
    char opcao1 = 's';

    //Solicita entrada de nome e senha ao usuário
    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Cadastrar: Vale Alimentação                            =");
    Ferramentas.imprimeLinhaDupla();
    nome = Beneficiario.listaBeneficiarios.get(0).nomeBeneficiario;
    System.out.println("- Digite uma senha para usar o cartão:                           -");
    System.out.print("- Senha: ");
    senha = in.nextLine().trim();
    Ferramentas.imprimeEspacador();

    Integer identificadorCartao = ValeAlimentacao.incrementoIdentificadorVA++;
    Double saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
    data1 = LocalDate.now();
    data2 = LocalDate.now().plusYears(2);

    ValeAlimentacao.listaCartoesVA.add(new ValeAlimentacao(identificadorCartao, nome, senha,
            saldoCartao, data1, data2));

    Ferramentas.imprimeLinha();
    System.out.println("- Cadastro realizado com sucesso!                                -");
    Ferramentas.imprimeLinha();
    Ferramentas.imprimeEspacador();
    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Cadastrar: Vale Refeição                               =");
    Ferramentas.imprimeLinhaDupla();
    System.out.println("- Digite uma senha para usar o cartão:                           -");
    System.out.print("- Senha: ");
    senha = in.nextLine().trim();
    Ferramentas.imprimeEspacador();

    //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
    identificadorCartao = ValeRefeicao.incrementoIdentificadorVR++;
    saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
    data1 = LocalDate.now();
    data2 = LocalDate.now().plusYears(2);

    ValeRefeicao.listaCartoesVR.add(new ValeRefeicao(identificadorCartao, nome, senha,
            saldoCartao, data1, data2));

    Ferramentas.imprimeLinha();
    System.out.println("- Cadastro realizado com sucesso!                                -");
    Ferramentas.imprimeLinha();

    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Cadastrar: Vale Combustível                            =");
    Ferramentas.imprimeLinhaDupla();
    System.out.println("- Digite uma senha para usar o cartão:                           -");
    System.out.print("- Senha: ");
    senha = in.nextLine().trim();
    Ferramentas.imprimeEspacador();

    //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
    identificadorCartao = ValeCombustivel.incrementoIdentificadorVC++;
    saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
    data1 = LocalDate.now();
    data2 = LocalDate.now().plusYears(2);

    ValeCombustivel.listaCartoesVC.add(new ValeCombustivel(identificadorCartao, nome, senha,
            saldoCartao, data1, data2));

    Ferramentas.imprimeLinha();
    System.out.println("- Cadastro realizado com sucesso!                                -");
    Ferramentas.imprimeLinha();
  }

  //Método para gerenciar o submenu 3: adicionar saldo em benefício
  public static void adicionarSaldoBeneficio() {

    //Cria as variáveis necessárias
    String nome;
    Integer vale;
    Double valorParaAdicionar;
    char opcao = 's';
    boolean verificador = false;

    Scanner in = new Scanner(System.in);

    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Adicionar: Saldo em um cartão de benefício             =");
    Ferramentas.imprimeLinhaDupla();
    System.out.println("- Digite o código do benefício:                                  -");
    System.out.println("- [1] Vale Alimentação                                        -");
    System.out.println("- [2] Vale Refeição                                           -");
    System.out.println("- [3] Vale Combustível                                        -");
    System.out.print("- Opção: ");
    vale = in.nextInt();
    System.out.println("- Digite o nome do beneficiário:                                 -");
    System.out.print("- Nome: ");
    nome = in.nextLine().trim();
    System.out.println("- Digite o valor a ser adicionado:                               -");
    System.out.print("- Valor: ");
    valorParaAdicionar = in.nextDouble();
    Ferramentas.imprimeEspacador();

    switch (vale) {
      case 1 -> {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeAlimentacao.listaCartoesVA.get(i).nomeBeneficiario.equals(nome) && valorParaAdicionar > 0) {
            verificador = true;
            ValeAlimentacao.adicionaSaldoVA(i, valorParaAdicionar);
            Double saldoFinal = ValeAlimentacao.listaCartoesVA.get(i).saldoCartao;
            Ferramentas.imprimeLinha();
            System.out.printf("- Valor de %.2f adicionado com sucesso!%n", valorParaAdicionar);
            System.out.println("- Agora o saldo do Vale Alimentação de                            -");
            System.out.printf("%s é %.2f!%n", nome, saldoFinal);
            Ferramentas.imprimeEspacador();
          }

          if (!verificador) {
            Ferramentas.imprimeLinha();
            System.out.println("- O beneficiário não existe ou o valor é negativo!               -");
            Ferramentas.imprimeEspacador();
          }
        }
        verificador = false;
      }
      case 2 -> {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeRefeicao.listaCartoesVR.size(); i++) {

          if (ValeRefeicao.listaCartoesVR.get(i).nomeBeneficiario.equals(nome) && valorParaAdicionar > 0) {
            verificador = true;
            ValeRefeicao.adicionaSaldoVR(i, valorParaAdicionar);
            Double saldoFinal = ValeRefeicao.listaCartoesVR.get(i).saldoCartao;
            Ferramentas.imprimeLinha();
            System.out.printf("- Valor de %.2f adicionado com sucesso!%n", valorParaAdicionar);
            System.out.println("- Agora o saldo do Vale Refeição de                              -");
            System.out.printf("%s é %.2f!%n", nome, saldoFinal);
            Ferramentas.imprimeEspacador();
          }

          if (!verificador) {
            Ferramentas.imprimeLinha();
            System.out.println("- O beneficiário não existe ou o valor é negativo!               -");
            Ferramentas.imprimeEspacador();
          }
        }
        verificador = false;
      }
      case 3 -> {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeCombustivel.listaCartoesVC.size(); i++) {

          if (ValeCombustivel.listaCartoesVC.get(i).nomeBeneficiario.equals(nome) && valorParaAdicionar > 0) {
            verificador = true;
            ValeCombustivel.adicionaSaldoVC(i, valorParaAdicionar);
            Double saldoFinal = ValeCombustivel.listaCartoesVC.get(i).saldoCartao;
            Ferramentas.imprimeLinha();
            System.out.printf("- Valor de %.2f adicionado com sucesso!%n", valorParaAdicionar);
            System.out.println("- Agora o saldo do Vale Combustível de                           -");
            System.out.printf("%s é %.2f!%n", nome, saldoFinal);
            Ferramentas.imprimeEspacador();
          }

          if (!verificador) {
            Ferramentas.imprimeLinha();
            System.out.println("- O beneficiário não existe ou o valor é negativo!               -");
            Ferramentas.imprimeEspacador();
          }
        }
        verificador = false;
      }
      default -> {
        Ferramentas.imprimeLinha();
        System.out.println("- Opção inválida! Digite uma opção dentre as disponíveis!      -");
      }
    }
  }

  //Método para gerenciar o submenu 4: cadastrar transacoes em um cartão
  public static void cadastrarTransacoesCartao() {

    char opcao = 's';

    Scanner in = new Scanner(System.in);
    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Menu -> Cadastrar: Transações de um Cartão                     =");
    Ferramentas.imprimeLinhaDupla();
    do {
      //Força retorno ao menu principal, quando voltando do método de adicionar transações
      if (ValeAlimentacao.voltaMenuPrincipalVA || ValeRefeicao.voltaMenuPrincipalVR ||
              ValeCombustivel.voltaMenuPrincipalVC) {
        opcao = 'n';
        continue;
      }

      System.out.println("- Em qual cartão você gostaria de adicionar a transação?         -");
      System.out.println("- Digite o número referente ao  benefício:                       -");
      System.out.println("- [1] Vale Alimentação                                         -");
      System.out.println("- [2] Vale Refeição                                            -");
      System.out.println("- [3] Vale Combustível                                         -");
      System.out.print("- Opção: ");
      Integer resposta = in.nextInt();
      Ferramentas.imprimeEspacador();

      switch (resposta) {
        case 1 -> ValeAlimentacao.adicionarTransacaoVA();
        case 2 -> ValeRefeicao.adicionarTransacaoVR();
        case 3 -> ValeCombustivel.adicionarTransacaoVC();
        default -> {
          Ferramentas.imprimeLinha();
          System.out.println("- Opção incorreta!                                               -");
          System.out.println("- Deseja tentar novamente? [s] [n]                               -");
          opcao = in.nextLine().trim().toLowerCase().charAt(0);
          Ferramentas.imprimeEspacador();
        }
      }
    } while (opcao == 's');
  }

  //Método para gerenciar o submenu 5: expirar validade de um cartão
  public static void alterarValidadeCartao() {

    //Cria as variáveis necessárias
    String nome;
    Integer vale;
    char option = 's';
    LocalDate pegaData, pegaDataFinal;

    Scanner in = new Scanner(System.in);

    do {
      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Menu -> Expirar: Validade de um cartão                         =");
      Ferramentas.imprimeLinhaDupla();
      System.out.println("- Digite o código do benefício:                                  -");
      System.out.println("- [1] Vale Alimentação                                        -");
      System.out.println("- [2] Vale Refeição                                           -");
      System.out.println("- [3] Vale Combustível                                        -");
      System.out.print("- Opção: ");
      vale = in.nextInt();
      Ferramentas.imprimeEspacador();
      System.out.println("- Digite o nome do beneficiário:                                 -");
      nome = in.nextLine().trim();
      Ferramentas.imprimeEspacador();

      boolean verificador = false;

      switch (vale) {
        case 1 -> {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeAlimentacao.listaCartoesVA.get(i).nomeBeneficiario.equals(nome)) {
              pegaData = ValeAlimentacao.listaCartoesVA.get(i).dataDoCadastro;
              pegaDataFinal = pegaData.minusDays(1);
              ValeAlimentacao.listaCartoesVA.get(i).validadeCartao = pegaDataFinal;
              Ferramentas.imprimeLinha();
              System.out.println("- A data de validade do cartão foi alterada!                     -");
              System.out.println("- Data de validade expirada com sucesso!                         -");
              Ferramentas.imprimeEspacador();
              verificador = true;
            }
          }
          //Retorna mensagem de erro caso não encontra o beneficiário
          if (!verificador) {
            Ferramentas.imprimeLinha();
            System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
            System.out.println("- Deseja tentar digitar outro nome?                              -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
            System.out.print("- Opção: ");
            option = in.nextLine().trim().toLowerCase().charAt(0);
            Ferramentas.imprimeEspacador();
          }
        }
        case 2 -> {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeRefeicao.listaCartoesVR.size(); i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeRefeicao.listaCartoesVR.get(i).nomeBeneficiario.equals(nome)) {
              pegaData = ValeRefeicao.listaCartoesVR.get(i).dataDoCadastro;
              pegaDataFinal = pegaData.minusDays(1);
              ValeRefeicao.listaCartoesVR.get(i).validadeCartao = pegaDataFinal;
              Ferramentas.imprimeLinha();
              System.out.println("A data de validade do cartão foi alterada!                       -");
              System.out.println("Data de validade expirada com sucesso!                           -");
              Ferramentas.imprimeEspacador();
              verificador = true;
            }
          }
          //Retorna mensagem de erro caso não encontra o beneficiário
          if (!verificador) {
            Ferramentas.imprimeLinha();
            System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
            Ferramentas.imprimeLinha();
            System.out.println("- Deseja tentar digitar outro nome?                              -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
            Ferramentas.imprimeLinha();
            System.out.print("- Opção: ");
            option = in.nextLine().trim().toLowerCase().charAt(0);
            Ferramentas.imprimeEspacador();
          }
        }
        case 3 -> {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeCombustivel.listaCartoesVC.size(); i++) {


            if (ValeCombustivel.listaCartoesVC.get(i).nomeBeneficiario.equals(nome)) {
              pegaData = ValeCombustivel.listaCartoesVC.get(i).dataDoCadastro;
              pegaDataFinal = pegaData.minusDays(1);
              ValeCombustivel.listaCartoesVC.get(i).validadeCartao = pegaDataFinal;
              Ferramentas.imprimeLinha();
              System.out.println("- A data de validade do cartão foi alterada!                    -");
              System.out.println("- Data de validade expirada com sucesso!                        -");
              verificador = true;
            }
          }
          //Retorna mensagem de erro caso não encontra o beneficiário
          if (!verificador) {
            Ferramentas.imprimeLinha();
            System.out.println("- O beneficiário e/ou o cartão não existe!                      -");
            Ferramentas.imprimeLinha();
            System.out.println("- Deseja tentar digitar outro nome?                             -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
            Ferramentas.imprimeLinha();
            System.out.print("- Opção: ");
            option = in.nextLine().trim().toLowerCase().charAt(0);
            Ferramentas.imprimeEspacador();
          }
        }
        default -> {
          Ferramentas.imprimeLinha();
          System.out.println("Opção inválida! Digite uma opção dentre as disponíveis!");
          Ferramentas.imprimeEspacador();
        }
      }
    } while (option == 's');
  }

  //Método para gerenciar o submenu 6: alterar validade de um cartão
  public static void mostrarSaldos() {

    String nome;
    Scanner in = new Scanner(System.in);
    char opcao = 's';

    do {
      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Menu -> Visualizar: Saldo dos cartões de benefício             =");
      Ferramentas.imprimeLinhaDupla();
      System.out.println("- Insira o nome do(a) beneficiário(a):                           -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      Ferramentas.imprimeEspacador();

      boolean verificador = false;

      //Laço para percorrer a lista de beneficiários
      for (int i = 0; i < Beneficiario.listaBeneficiarios.size(); i++) {

        //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
        if (Beneficiario.listaBeneficiarios.get(i).nomeBeneficiario.equals(nome)) {

          Double saldoAtualVA = ValeAlimentacao.listaCartoesVA.get(i).saldoCartao;
          Double saldoAtualVR = ValeRefeicao.listaCartoesVR.get(i).saldoCartao;
          Double saldoAtualVC = ValeCombustivel.listaCartoesVC.get(i).saldoCartao;
          Ferramentas.imprimeLinha();
          System.out.printf("- %s,%n", nome);
          System.out.println("- Aqui estão os saldos atuais dos seus benefícios:               -");
          Ferramentas.imprimeLinha();
          ValeAlimentacao.mostrarSaldo(saldoAtualVA);
          ValeRefeicao.mostrarSaldo(saldoAtualVR);
          ValeCombustivel.mostrarSaldo(saldoAtualVC);
          Ferramentas.imprimeLinha();
          System.out.println("- Deseja verificar outro saldo?                                  -");
          System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
          Ferramentas.imprimeLinha();
          System.out.print("- Opção: ");
          opcao = in.nextLine().trim().toLowerCase().charAt(0);
          Ferramentas.imprimeEspacador();
          verificador = true;
        }
      }
      //Retorna mensagem de erro caso não encontra o beneficiário
      if (!verificador) {
        Ferramentas.imprimeLinha();
        System.out.println("- Não foi possível realizar a consulta.                          -");
        System.out.printf("- Beneficiário %s não encontrado!                                 -", nome);
        System.out.println("- Deseja digitar o nome de outro beneficiário?                   -");
        System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
        Ferramentas.imprimeLinha();
        System.out.print("Opção: ");
        opcao = in.nextLine().trim().toLowerCase().charAt(0);
        Ferramentas.imprimeEspacador();

      }
    } while (opcao == 's');
  }

  //Método para gerenciar o submenu 7: Visualizar extrato de um cartão
  public static void visualizarExtratoCartao() {

    //Cria as variáveis necessárias
    String nome;
    Integer vale;
    char option = 's';

    Scanner in = new Scanner(System.in);

    do {
      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Menu -> Menu -> Emitir: Extrato de transações                  =");
      Ferramentas.imprimeLinhaDupla();
      System.out.println("- Digite o código do benefício:                                  -");
      System.out.println("- [1] Vale Alimentação                                           -");
      System.out.println("- [2] Vale Refeição                                              -");
      System.out.println("- [3] Vale Combustível                                           -");
      System.out.println("- [4] Voltar para o menu principal                               -");
      System.out.print("- Opção: ");
      vale = in.nextInt();
      Ferramentas.imprimeEspacador();
      System.out.println("- Digite o nome do beneficiário:                                 -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      Ferramentas.imprimeEspacador();

      switch (vale) {
        case 1 -> {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {

            //Se encontra o beneficiário, imprime a lista
            if (ValeAlimentacao.listaCartoesVA.get(i).nomeBeneficiario.contains(nome)) {

              Ferramentas.imprimeLinhaDupla();
              System.out.println("Vale Alimentação - Extrato de transações                         =");
              Ferramentas.imprimeLinhaDupla();
              Ferramentas.imprimeEspacador();

              for (int r = 0; r < ValeAlimentacao.listaTransacoesVA.size(); r++) {
                System.out.print("- Número da transação: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).identificadorDaTransacao);
                System.out.print("- Número do cartão: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).identificadorDoCartao);
                System.out.print("- Data e hora da transação: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).dataHoraTransacao);
                System.out.print("- Identificador do estabelecimento: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).identicadorDoEstabelecimento);


                System.out.print("- Tipo do estabelecimento: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).tipoDoEstabelecimento);
                System.out.print("- Localização do estabelecimento: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).localizacaoDoEstabelecimento);
                System.out.print("- Valor da transação: ");
                System.out.println(ValeAlimentacao.listaTransacoesVA.get(r).valorDaTransacao);
                Ferramentas.imprimeEspacador();
              }

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              Ferramentas.imprimeLinha();
              System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
              Ferramentas.imprimeLinha();
              System.out.println("- Deseja tentar digitar outro nome?                              -");
              System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
              Ferramentas.imprimeLinha();
              System.out.print("- Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
              Ferramentas.imprimeEspacador();
            }
          }
        }
        case 2 -> {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeRefeicao.listaCartoesVR.size(); i++) {

            //Se encontra o beneficiário, imprime a lista
            if (ValeRefeicao.listaCartoesVR.get(i).nomeBeneficiario.equals(nome)) {

              Ferramentas.imprimeLinhaDupla();
              System.out.println("= Vale Refeição - Extrato de transações                          =");
              Ferramentas.imprimeLinhaDupla();
              Ferramentas.imprimeEspacador();

              for (int r = 0; r < ValeRefeicao.listaTransacoesVR.size(); r++) {
                System.out.print("- Número da transação: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).identificadorDaTransacao);
                System.out.print("- Número do cartão: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).identificadorDoCartao);
                System.out.print("- Data e hora da transação: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).dataHoraTransacao);
                System.out.print("- Identificador do estabelecimento: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).identicadorDoEstabelecimento);
                System.out.print("- Tipo do estabelecimento: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).tipoDoEstabelecimento);
                System.out.print("- Localização do estabelecimento: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).localizacaoDoEstabelecimento);
                System.out.print("- Valor da transação: ");
                System.out.println(ValeRefeicao.listaTransacoesVR.get(r).valorDaTransacao);
                Ferramentas.imprimeEspacador();
              }
              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              Ferramentas.imprimeLinha();
              System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
              Ferramentas.imprimeLinha();
              System.out.println("- Deseja tentar digitar outro nome?                              -");
              System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
              Ferramentas.imprimeLinha();
              System.out.print("- Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
              Ferramentas.imprimeEspacador();
            }

          }
        }
          case 3 -> {
            //Laço para percorrer a lista de beneficiários
            for (int i = 0; i < ValeCombustivel.listaCartoesVC.size(); i++) {

              //Se encontra o beneficiário, imprime a lista
              if (ValeCombustivel.listaCartoesVC.get(i).nomeBeneficiario.equals(nome)) {

                Ferramentas.imprimeLinhaDupla();
                System.out.println("Vale Combustível - Extrato de transações                         =");
                Ferramentas.imprimeLinhaDupla();
                Ferramentas.imprimeEspacador();

                for (int r = 0; r < ValeCombustivel.listaTransacoesVC.size(); r++) {
                  System.out.print("- Número da transação: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).identificadorDaTransacao);
                  System.out.print("- Número do cartão: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).identificadorDoCartao);
                  System.out.print("- Data e hora: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).dataHoraTransacao);
                  System.out.print("- Identificador do estabelecimento: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).identicadorDoEstabelecimento);
                  System.out.print("- Tipo do estabelecimento: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).tipoDoEstabelecimento);
                  System.out.print("- Localização do estabelecimento: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).localizacaoDoEstabelecimento);
                  System.out.print("- Valor da transação: ");
                  System.out.println(ValeCombustivel.listaTransacoesVC.get(r).valorDaTransacao);
                  Ferramentas.imprimeEspacador();
                }
                //Retorna mensagem de erro caso não encontra o beneficiário
              } else {
                Ferramentas.imprimeLinha();
                System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
                Ferramentas.imprimeLinha();
                System.out.println("- Deseja tentar digitar outro nome?                              -");
                System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
                Ferramentas.imprimeLinha();
                System.out.print("- Opção: ");
                option = in.nextLine().trim().toLowerCase().charAt(0);
                Ferramentas.imprimeEspacador();
              }
            }
          }
        case 4 -> {
          option = 'n';
        }
        default -> {
          Ferramentas.imprimeLinha();
          Ferramentas.imprimeEspacador();
          System.out.println("- Opção inválida! Digite uma opção dentre as disponíveis!        -");
          Ferramentas.imprimeEspacador();
        }
      }
    } while (option == 's');
  }

  //Método para gerenciar o submenu 8: Sair do programa
  public static void sairPrograma() {
    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Obrigado por usar nossos serviços.                             =");
    Ferramentas.imprimeLinhaDupla();
    Ferramentas.imprimeEspacador();
    System.out.println("- A \"JavAlelo\" agradece a sua preferência!                       -");
    System.out.println("- Tenha um ótimo dia!                                            -");
    Ferramentas.imprimeEspacador();
    Ferramentas.imprimeLinha();
    System.exit(0);
  }

  //Método para invocar o menu principal, após o acesso inicial ao programa
  public static void inicializaMenuPrincipal() {

    //Instancia a classe Scanner para receber dados do usuário
    Scanner in = new Scanner(System.in);

    //Cria a variável necessária para manter o laço de repetição logo abaixo
    boolean escolhaValidaMenu;

    //Inicia laço para informar opções possíveis no programa e direcionar o usuário
    //para a função desejada
    do {
      escolhaValidaMenu = false;
      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Menu -> Tela Principal                                         =");
      Ferramentas.imprimeLinhaDupla();
      System.out.println("- Digite uma das opções abaixo:                                  -");
      System.out.println("- 1 Cadastrar beneficiários                                      -");
      System.out.println("- 2 Cadastrar cartões de benefício                               -");
      System.out.println("- 3 Adicionar saldo em um cartão de benefício                    -");
      System.out.println("- 4 Cadastrar transações em um cartão                            -");
      System.out.println("- 5 Alterar data de validade de um cartão                        -");
      System.out.println("- 6 Visualizar saldo dos cartões de benefício                    -");
      System.out.println("- 7 Visualizar extrato de um cartão                              -");
      System.out.println("- 8 -Sair do programa                                            -");
      System.out.print("- Opção: ");
      int opcao1 = in.nextInt();
      Ferramentas.imprimeEspacador();

      //Usa condicional para direcionar o usuário para a função escolhida do programa
      switch (opcao1) {
        case 1 -> Beneficiario.cadastrarBeneficiario();
        case 2 -> Ferramentas.cadastrarCartoesBeneficio();
        case 3 -> Ferramentas.adicionarSaldoBeneficio();
        case 4 -> Ferramentas.cadastrarTransacoesCartao();
        case 5 -> Ferramentas.alterarValidadeCartao();
        case 6 -> Ferramentas.mostrarSaldos();
        case 7 -> Ferramentas.visualizarExtratoCartao();
        case 8 -> Ferramentas.sairPrograma();
        default -> System.out.println("Escolha um número entre 1 a 8!                                   -");
      }
    } while (!escolhaValidaMenu);
  }

  //Método para inicializar o programa na classe Main
  public static void inicializaPrograma() {

    //Invoca o método para inicializar os estabelecimentos com dados pré-preenchidos
    Estabelecimento.inicializaEstabelecimentos();

    //Inicio do programa com retorno ao usuário
    Ferramentas.imprimeEspacador();
    System.out.println("= Olá! Bem-vindo(a) ao gerenciador de benefícios da \"JavAlelo\"   =");
    Ferramentas.imprimeLinhaDupla();
    Ferramentas.imprimeEspacador();
    System.out.println("- Para começar, você precisa cadastrar um beneficiário.          -");
    System.out.println("- Vamos lá!                                                      -");
    Ferramentas.imprimeEspacador();

    //Invoca o método para cadastrar o primeiro beneficiário
    Beneficiario.cadastrarBeneficiarioPrimeiraVez();

    System.out.println("- Perfeito!                                                      -");
    System.out.println("- Agora precisamos cadastrar os 3 cartões desse beneficiário.    -");
    Ferramentas.imprimeLinha();

    //Invoca o método para realizar o cadastro de cartões do primeiro beneficiário
    Ferramentas.cadastrarCartoesBeneficioPrimeiravez();

    System.out.println("- Perfeito!                                                      -");
    System.out.println("- Carregando o módulo principal do gerenciador...                -");
    System.out.println("------------------------------------------------------------------");
    //Invoca o método para iniciar o menu principal do programa
    Ferramentas.inicializaMenuPrincipal();
  }

  //Método que auxilia na estrutura visual do projeto gerando linhas simples
  public static void imprimeLinha() {
    System.out.println("------------------------------------------------------------------");
  }

  //Método que auxilia na estrutura visual do projeto gerando linhas duplas
  public static void imprimeLinhaDupla() {
    System.out.println("==================================================================");
  }

  //Método que auxilia na estrutura visual do projeto gerando linhas espaçadas
  public static void imprimeEspacador() {
    System.out.println("-                                                                -");
  }
}