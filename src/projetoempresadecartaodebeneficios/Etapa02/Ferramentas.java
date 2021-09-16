package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;


public class Ferramentas {

  //Formata a data para exibição padrão "dd/MM/yyyy"
  public static void formatarDataPadrao(LocalDate data1) {

    LocalDate dt1 = LocalDate.parse(data1.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println(dt1.format(formatter));
  }

  //Formata a data e hora para exibição padrão "dd/MM/yyyy HH:mm:ss"
  public static void formatarDataHoraPadrao(LocalDateTime evt1) {

    LocalDate evento1 = LocalDate.parse(evt1.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    System.out.println(evento1.format(formatter));
  }

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

    return Estabelecimento.listaEstabelecimentos.get(index4).getIdentificadorEstabelecimento().equals(identificador1);
  }

  public static Boolean verificaValorVA(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeAlimentacao.listaTransacoes.get(index4).getValorDaTransacao();
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.equals(valorComparacaoString2);
  }

  public static Boolean verificaValorVR(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeRefeicao.listaTransacoes.get(index4).getValorDaTransacao();
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.equals(valorComparacaoString2);
  }

  public static Boolean verificaValorVC(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeCombustivel.listaTransacoes.get(index4).getValorDaTransacao();
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.equals(valorComparacaoString2);
  }

  //Método para gerenciar o submenu 2: cadastro de cartões
  public static void cadastrarCartoesBeneficio() {

    System.out.println("=================================================================");
    System.out.println("= Menu -> Cadastrar: Novos cartões de benefício                 =");
    System.out.println("=================================================================");

    Scanner in = new Scanner(System.in);

    //Declara variáveis necessárias
    String nome, senha;
    LocalDate data1, data2;
    char opcao = 's';

    int i = 0;

    do {
      System.out.println("=================================================================");
      System.out.println("Menu -> Cadastrar: Vale Alimentação");
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

      //Laço para percorrer a lista de beneficiários
      for (i = 0; i < Beneficiario.listaBeneficiarios.size(); i++) {

        //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
        if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().equals(nome)) {
          verificador = true;

          //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
          Integer identificadorCartao = ValeAlimentacao.incrementoIdentificadorVA++;
          Double saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
          data1 = LocalDate.now();
          data2 = LocalDate.now().plusYears(2);

          ValeAlimentacao.listaCartoesVA.add(new ValeAlimentacao(identificadorCartao, nome, senha,
                  saldoCartao, data1, data2));

          System.out.println("-----------------------------------------------------------------");
          System.out.println("- Cadastro realizado com sucesso!                               -");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("-                                                               -");
          System.out.println("=================================================================");
          System.out.println("= Menu -> Cadastrar: Vale Refeição                              =");
          System.out.println("=================================================================");
          System.out.println("- Digite uma senha para usar o cartão:                          -");
          System.out.print("- Senha: ");
          senha = in.nextLine().trim();
          System.out.println("-                                                               -");

          //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
          identificadorCartao = ValeRefeicao.incrementoIdentificadorVR++;
          saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
          data1 = LocalDate.now();
          data2 = LocalDate.now().plusYears(2);

          ValeRefeicao.listaCartoesVR.add(new ValeRefeicao(identificadorCartao, nome, senha,
                  saldoCartao, data1, data2));

          System.out.println("-----------------------------------------------------------------");
          System.out.println("- Cadastro realizado com sucesso!                               -");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("-                                                               -");
          System.out.println("=================================================================");
          System.out.println("- Menu -> Cadastrar: Vale Combustível                           -");
          System.out.println("=================================================================");
          System.out.println("- Digite uma senha para usar o cartão:                          -");
          System.out.print("- Senha: ");
          senha = in.nextLine().trim();
          System.out.println("-----------------------------------------------------------------");

          //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
          identificadorCartao = ValeCombustivel.incrementoIdentificadorVC++;
          saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
          data1 = LocalDate.now();
          data2 = LocalDate.now().plusYears(2);

          ValeCombustivel.listaCartoesVC.add(new ValeCombustivel(identificadorCartao, nome, senha,
                  saldoCartao, data1, data2));

          System.out.println("-----------------------------------------------------------------");
          System.out.println("- Cadastro realizado com sucesso!                               -");
          System.out.println("-----------------------------------------------------------------");

          //Retorna mensagem de erro caso não encontra o beneficiário
        }

      }

      if (!verificador && i == Beneficiario.listaBeneficiarios.size()) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("- Não foi possível realizar o cadastro.                         -");
        System.out.println("- Beneficiário não existe ou cartão já existe!                  -");
        System.out.println("-                                                               -");
      }
      System.out.println("-----------------------------------------------------------------");
      System.out.println("- Deseja tentar digitar outro nome?                             -");
      System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
      System.out.println("-----------------------------------------------------------------");
      System.out.print("- Opção: ");
      opcao = in.nextLine().trim().toLowerCase().charAt(0);
      System.out.println("-                                                               -");
      verificador = false;


    } while (opcao == 's');
  }

  //Método que cadastra os cartões na primeira vez que o programa é executado
  public static void cadastrarCartoesBeneficioPrimeiravez() {

    System.out.println("=================================================================");
    System.out.println("= Menu -> Cadastrar: Novos cartões de benefício                 =");
    System.out.println("=================================================================");
    System.out.println("-                                                               -");

    Scanner in = new Scanner(System.in);

    //Declara variáveis necessárias
    String nome, senha;
    LocalDate data1, data2;
    char opcao1 = 's';

    //Solicita entrada de nome e senha ao usuário
    System.out.println("=================================================================");
    System.out.println("= Menu -> Cadastrar: Vale Alimentação                           =");
    System.out.println("=================================================================");
    nome = Beneficiario.listaBeneficiarios.get(0).getNomeBeneficiario();
    System.out.println("- Digite uma senha para usar o cartão:                          -");
    System.out.print("- Senha: ");
    senha = in.nextLine().trim();
    System.out.println("-                                                               -");

    Integer identificadorCartao = ValeAlimentacao.incrementoIdentificadorVA++;
    Double saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
    data1 = LocalDate.now();
    data2 = LocalDate.now().plusYears(2);

    ValeAlimentacao.listaCartoesVA.add(new ValeAlimentacao(identificadorCartao, nome, senha,
            saldoCartao, data1, data2));

    System.out.println("-----------------------------------------------------------------");
    System.out.println("- Cadastro realizado com sucesso!                               -");
    System.out.println("-----------------------------------------------------------------");
    System.out.println("-                                                               -");
    System.out.println("=================================================================");
    System.out.println("= Menu -> Cadastrar: Vale Refeição                              =");
    System.out.println("=================================================================");
    System.out.println("- Digite uma senha para usar o cartão:                          -");
    System.out.print("- Senha: ");
    senha = in.nextLine().trim();
    System.out.println("-                                                               -");

    //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
    identificadorCartao = ValeRefeicao.incrementoIdentificadorVR++;
    saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
    data1 = LocalDate.now();
    data2 = LocalDate.now().plusYears(2);

    ValeRefeicao.listaCartoesVR.add(new ValeRefeicao(identificadorCartao, nome, senha,
            saldoCartao, data1, data2));

    System.out.println("-----------------------------------------------------------------");
    System.out.println("- Cadastro realizado com sucesso!                               -");
    System.out.println("-----------------------------------------------------------------");

    System.out.println("=================================================================");
    System.out.println("= Menu -> Cadastrar: Vale Combustível                           =");
    System.out.println("=================================================================");
    System.out.println("- Digite uma senha para usar o cartão:                          -");
    System.out.print("- Senha: ");
    senha = in.nextLine().trim();
    System.out.println("-                                                               -");

    //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
    identificadorCartao = ValeCombustivel.incrementoIdentificadorVC++;
    saldoCartao = Ferramentas.valorAleatorioEntre200e1000();
    data1 = LocalDate.now();
    data2 = LocalDate.now().plusYears(2);

    ValeCombustivel.listaCartoesVC.add(new ValeCombustivel(identificadorCartao, nome, senha,
            saldoCartao, data1, data2));

    System.out.println("-----------------------------------------------------------------");
    System.out.println("- Cadastro realizado com sucesso!                               -");
    System.out.println("-----------------------------------------------------------------");
  }

  //Método para gerenciar o submenu 3: adicionar saldo em benefício
  public static void adicionarSaldoBeneficio() {

    //Cria as variáveis necessárias
    String vale, nome;
    Double valorParaAdicionar;
    char opcao = 's';
    boolean verificador = false;

    Scanner in = new Scanner(System.in);

    do {
      System.out.println("==================================================================");
      System.out.println("= Menu -> Adicionar: Saldo em um cartão de benefício             =");
      System.out.println("==================================================================");
      System.out.println("- Digite o código do benefício:                                  -");
      System.out.println("- [va] - Vale Alimentação                                        -");
      System.out.println("- [vr] - Vale Refeição                                           -");
      System.out.println("- [vc] - Vale Combustível                                        -");
      System.out.print("- Opção: ");
      vale = in.nextLine().trim();
      System.out.println("- Digite o nome do beneficiário:                                 -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      System.out.println("- Digite o valor a ser adicionado:                               -");
      System.out.print("- Valor: ");
      valorParaAdicionar = in.nextDouble();
      System.out.println("-                                                                -");

      if (vale.equals("va")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().equals(nome) && valorParaAdicionar > 0) {
            verificador = true;
            ValeAlimentacao.adicionaSaldoVA(i, valorParaAdicionar);
            Double saldoFinal = ValeAlimentacao.listaCartoesVA.get(i).saldoCartao;
            System.out.println("------------------------------------------------------------------");
            System.out.printf("- Valor de %.2f adicionado com sucesso!%n", valorParaAdicionar);
            System.out.println("- Agora o saldo do Vale Combustível de                           -");
            System.out.printf("%s é %.2f!%n",nome, saldoFinal);
            System.out.println("-                                                                -");
          }

          if (!verificador){
            System.out.println("------------------------------------------------------------------");
            System.out.println("- O beneficiário não existe ou o valor é negativo!               -");
            System.out.println("-                                                                -");

          }
        }
        verificador = false;
      } else if (vale.equals("vr")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeRefeicao.listaCartoesVR.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().equals(nome) && valorParaAdicionar > 0) {
            verificador = true;
            ValeRefeicao.adicionaSaldoVR(i, valorParaAdicionar);
            Double saldoFinal = ValeRefeicao.listaCartoesVR.get(i).saldoCartao;
            System.out.println("------------------------------------------------------------------");
            System.out.printf("- Valor de %.2f adicionado com sucesso!%n", valorParaAdicionar);
            System.out.println("- Agora o saldo do Vale Combustível de                           -");
            System.out.printf("%s é %.2f!%n",nome, saldoFinal);
            System.out.println("-                                                                -");

          }
          //Retorna mensagem de erro caso não encontra o beneficiário
          if(!verificador) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("- O beneficiário não existe ou o valor é negativo!              -");
            System.out.println("- Deseja tentar digitar outro nome?                             -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
            System.out.print("- Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                               -");
          }
        }

        verificador = false;
      } else if (vale.equals("vc")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeCombustivel.listaCartoesVC.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().equals(nome) && valorParaAdicionar > 0) {
            verificador = true;
            ValeCombustivel.adicionaSaldoVC(i, valorParaAdicionar);
            Double saldoFinal = ValeCombustivel.listaCartoesVC.get(i).saldoCartao;
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("- Valor de %.2f adicionado com sucesso!%n", valorParaAdicionar);
            System.out.println("- Agora o saldo do Vale Combustível de                           -");
            System.out.printf("%s é %.2f!%n",nome, saldoFinal);
            System.out.println("-                                                                -");

            //Retorna mensagem de erro caso não encontra o beneficiário
          }

          if (!verificador){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("- O beneficiário não existe ou o valor é negativo!              -");
            System.out.println("- Deseja tentar digitar outro nome?                             -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
            System.out.print("- Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                               -");
          }
        }
        verificador = false;
      } else {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("- Opção inválida! Digite uma opção dentre as disponíveis!      -");
      }
      System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
      System.out.println("-                                                                -");
      System.out.print("- Opção: ");
      opcao = in.nextLine().trim().toLowerCase().charAt(0);
      System.out.println("-                                                                -");

    } while (opcao == 's');
  }

  //Método para gerenciar o submenu 4: cadastrar transacoes em um cartão
  public static void cadastrarTransacoesCartao() {
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();
    char opcao = 's';

    Scanner in = new Scanner(System.in);
    System.out.println("==================================================================");
    System.out.println("= Menu -> Cadastrar: Transações de um Cartão                     =");
    System.out.println("==================================================================");
    do {
      System.out.println("- Em qual cartão você gostaria de adicionar a transação?         -");
      System.out.println("- Digite o código do benefício:                                  -");
      System.out.println("- [va] - Vale Alimentação                                        -");
      System.out.println("- [vr] - Vale Refeição                                           -");
      System.out.println("- [vc] - Vale Combustível                                        -");
      String resposta = in.nextLine().trim();
      System.out.println("-                                                                -");

      if (resposta.equals("va")) {
        va.adicionarTransacao();
      } else if (resposta.equals("vr")) {
        vr.adicionarTransacao();
      } else if (resposta.equals("vc")) {
        vc.adicionarTransacao();
      } else {
        System.out.println("------------------------------------------------------------------");
        System.out.println("- Opção incorreta!                                               -");
        System.out.println("- Deseja tentar novamente? [s] [n]                               -");
        opcao = in.nextLine().trim().toLowerCase().charAt(0);
        System.out.println("-                                                                -");
      }
    } while (opcao == 's');
  }

  //Método para gerenciar o submenu 5: expirar validade de um cartão
  public static void alterarValidadeCartao() {

    //Cria as variáveis necessárias
    String vale, nome;
    char option = 's';
    LocalDate pegaData, pegaDataFinal;

    Scanner in = new Scanner(System.in);

    do {
      System.out.println("==================================================================");
      System.out.println("= Menu -> Expirar: Validade de um cartão                         =");
      System.out.println("==================================================================");
      System.out.println("- Digite o código do benefício:                                  -");
      System.out.println("- [va] - Vale Alimentação                                        -");
      System.out.println("- [vr] - Vale Refeição                                           -");
      System.out.println("- [vc] - Vale Combustível                                        -");
      System.out.print("- Opção: ");
      vale = in.nextLine().trim();
      System.out.println("-                                                                -");
      System.out.println("- Digite o nome do beneficiário:                                 -");
      nome = in.nextLine().trim();
      System.out.println("-                                                                -");

      boolean verificador = false;

      if (vale.equals("va")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().equals(nome)) {
            pegaData = ValeAlimentacao.listaCartoesVA.get(i).getDatadoCadastroVA();
            pegaDataFinal = pegaData.minusDays(1);
            ValeAlimentacao.listaCartoesVA.get(i).setValidadeCartaoVA(pegaDataFinal);
            System.out.println("------------------------------------------------------------------");
            System.out.println("- A data de validade do cartão foi alterada!                     -");
            System.out.println("- Data de validade expirada com sucesso!                         -");
            System.out.println("-                                                                -");
            verificador = true;
          }
        }

        //Retorna mensagem de erro caso não encontra o beneficiário
        if (!verificador) {
          System.out.println("------------------------------------------------------------------");
          System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
          System.out.println("- Deseja tentar digitar outro nome?                              -");
          System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
          System.out.print("- Opção: ");
          option = in.nextLine().trim().toLowerCase().charAt(0);
          System.out.println("-                                                                -");
        }
      } else if (vale.equals("vr")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeRefeicao.listaCartoesVR.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().equals(nome)) {
            pegaData = ValeRefeicao.listaCartoesVR.get(i).getDatadoCadastroVR();
            pegaDataFinal = pegaData.minusDays(1);
            ValeRefeicao.listaCartoesVR.get(i).setValidadeCartaoVR(pegaDataFinal);
            System.out.println("------------------------------------------------------------------");
            System.out.println("A data de validade do cartão foi alterada!                       -");
            System.out.println("Data de validade expirada com sucesso!                           -");
            System.out.println("-                                                                -");
            verificador = true;
          }
        }
        //Retorna mensagem de erro caso não encontra o beneficiário
        if (!verificador) {
          System.out.println("------------------------------------------------------------------");
          System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
          System.out.println("------------------------------------------------------------------");
          System.out.println("- Deseja tentar digitar outro nome?                              -");
          System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
          System.out.println("------------------------------------------------------------------");
          System.out.print("- Opção: ");
          option = in.nextLine().trim().toLowerCase().charAt(0);
          System.out.println("-                                                                -");
        }
      } else if (vale.equals("vc")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeCombustivel.listaCartoesVC.size(); i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().equals(nome)) {
            pegaData = ValeCombustivel.listaCartoesVC.get(i).getDatadoCadastroVC();
            pegaDataFinal = pegaData.minusDays(1);
            ValeCombustivel.listaCartoesVC.get(i).setValidadeCartaoVC(pegaDataFinal);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("- A data de validade do cartão foi alterada!                    -");
            System.out.println("- Data de validade expirada com sucesso!                        -");
            verificador = true;
          }
        }
        //Retorna mensagem de erro caso não encontra o beneficiário
        if (!verificador) {
          System.out.println("-----------------------------------------------------------------");
          System.out.println("- O beneficiário e/ou o cartão não existe!                      -");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("- Deseja tentar digitar outro nome?                             -");
          System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
          System.out.println("-----------------------------------------------------------------");
          System.out.print("- Opção: ");
          option = in.nextLine().trim().toLowerCase().charAt(0);
          System.out.println("-                                                               -");
        }
      } else {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Opção inválida! Digite uma opção dentre as disponíveis!");
        System.out.println("-                                                                -");
      }
    } while (option == 's');
  }


  //Método para gerenciar o submenu 6: alterar validade de um cartão
  public static void mostrarSaldos() {

    String nome;

    Scanner in = new Scanner(System.in);

    char opcao = 's';

    do {
      System.out.println("==================================================================");
      System.out.println("= Menu -> Visualizar: Saldo dos cartões de benefício             =");
      System.out.println("==================================================================");
      System.out.println("- Insira o nome do(a) beneficiário(a):                           -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      System.out.println("-                                                                -");

      boolean verificador = false;

      //Laço para percorrer a lista de beneficiários
      for (int i = 0; i < Beneficiario.listaBeneficiarios.size(); i++) {

        //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
        if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().equals(nome)) {

          Double saldoAtualVA = ValeAlimentacao.listaCartoesVA.get(i).saldoCartao;
          Double saldoAtualVR = ValeRefeicao.listaCartoesVR.get(i).saldoCartao;
          Double saldoAtualVC = ValeCombustivel.listaCartoesVC.get(i).saldoCartao;
          System.out.println("------------------------------------------------------------------");
          System.out.printf("- %s,%n", nome);
          System.out.println("- Aqui estão os saldos atuais dos seus benefícios:               -");
          ValeAlimentacao.mostrarSaldo(saldoAtualVA);
          ValeRefeicao.mostrarSaldo(saldoAtualVR);
          ValeCombustivel.mostrarSaldo(saldoAtualVC);
          System.out.println("------------------------------------------------------------------");
          System.out.println("- Deseja cadastrar outro beneficiário?                           -");
          System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
          System.out.println("------------------------------------------------------------------");
          System.out.print("- Opção: ");
          opcao = in.nextLine().trim().toLowerCase().charAt(0);
          System.out.println("-                                                                -");
          verificador = true;
        }
      }
      //Retorna mensagem de erro caso não encontra o beneficiário
      if (!verificador) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("- Não foi possível realizar a consulta.                          -");
        System.out.printf("- Beneficiário %s não encontrado!                                 -", nome);
        System.out.println("- Deseja digitar o nome de outro beneficiário?                   -");
        System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
        System.out.println("------------------------------------------------------------------");
        System.out.print("Opção: ");
        opcao = in.nextLine().trim().toLowerCase().charAt(0);
        System.out.println("-                                                                -");

      }
    } while (opcao == 's');
  }

  //Método para gerenciar o submenu 7: Visualizar extrato de um cartão
  public static void visualizarExtratoCartao() {

    //Cria as variáveis necessárias
    String vale, nome;
    char option = 's';

    Scanner in = new Scanner(System.in);

    do {
      System.out.println("==================================================================");
      System.out.println("= Menu -> Menu -> Emitir: Extrato de transações                  =");
      System.out.println("==================================================================");
      System.out.println("- Digite o código do benefício:                                  -");
      System.out.println("- [va] - Vale Alimentação                                        -");
      System.out.println("- [vr] - Vale Refeição                                           -");
      System.out.println("- [vc] - Vale Combustível                                        -");
      System.out.print("- Opção: ");
      vale = in.nextLine().trim();
      System.out.println("-                                                                -");
      System.out.println("- Digite o nome do beneficiário:                                 -");
      System.out.print("- Nome: ");
      nome = in.nextLine().trim();
      System.out.println("-                                                                -");

      if (vale.equals("va")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size() - 1; i++) {

          //Se encontra o beneficiário, imprime a lista
          if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().equals(nome)) {

            System.out.println("==================================================================");
            System.out.println("Vale Alimentação - Extrato de transações                         =");
            System.out.println("==================================================================");
            System.out.println("-                                                                -");
            System.out.print("- Número da transação: ");
            System.out.println(ValeAlimentacao.listaTransacoes.get(i).getIdentificadorDaTransacao());
            System.out.print("- Número do cartão: ");
            System.out.println(ValeAlimentacao.listaTransacoes.get(i).getIdentificadorDoCartao());
            System.out.print("- Data e hora da transação: ");
            LocalDateTime dataEHora = ValeAlimentacao.listaTransacoes.get(i).getDataHoraTransacao();
            formatarDataHoraPadrao(dataEHora);
            System.out.print("- Identificador do estabelecimento: ");
            System.out.println(ValeAlimentacao.listaTransacoes.get(i).getIdenticadorDoEstabelecimento());
            System.out.print("- Tipo do estabelecimento: ");
            System.out.println(ValeAlimentacao.listaTransacoes.get(i).getTipoDoEstabelecimento());
            System.out.print("- Localização do estabelecimento: ");
            System.out.println(ValeAlimentacao.listaTransacoes.get(i).getLocalizacaoDoEstabelecimento());
            System.out.print("- Valor da transação: ");
            System.out.println(ValeAlimentacao.listaTransacoes.get(i).getValorDaTransacao());
            System.out.println("-                                                                -");

            //Retorna mensagem de erro caso não encontra o beneficiário
          } else {
            System.out.println("------------------------------------------------------------------");
            System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
            System.out.println("- Deseja tentar digitar outro nome?                              -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
            System.out.println("------------------------------------------------------------------");
            System.out.print("- Opção: ");
            option = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                                -");
          }
        }
      } else if (vale.equals("vr")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeRefeicao.listaCartoesVR.size() - 1; i++) {

          //Se encontra o beneficiário, imprime a lista
          if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().equals(nome)) {

            System.out.println("==================================================================");
            System.out.println("= Vale Refeição - Extrato de transações                          =");
            System.out.println("==================================================================");
            System.out.println("-                                                                -");
            System.out.print("Número da transação: ");
            System.out.println(ValeRefeicao.listaTransacoes.get(i).getIdentificadorDaTransacao());
            System.out.print("Número do cartão: ");
            System.out.println(ValeRefeicao.listaTransacoes.get(i).getIdentificadorDoCartao());
            System.out.print("Data e hora da transação: ");
            LocalDateTime dataEHora = ValeRefeicao.listaTransacoes.get(i).getDataHoraTransacao();
            formatarDataHoraPadrao(dataEHora);
            System.out.print("Identificador do estabelecimento: ");
            System.out.println(ValeRefeicao.listaTransacoes.get(i).getIdenticadorDoEstabelecimento());
            System.out.print("Tipo do estabelecimento: ");
            System.out.println(ValeRefeicao.listaTransacoes.get(i).getTipoDoEstabelecimento());
            System.out.print("Localização do estabelecimento: ");
            System.out.println(ValeRefeicao.listaTransacoes.get(i).getLocalizacaoDoEstabelecimento());
            System.out.print("Valor da transação: ");
            System.out.println(ValeRefeicao.listaTransacoes.get(i).getValorDaTransacao());
            System.out.println("-                                                                -");

            //Retorna mensagem de erro caso não encontra o beneficiário
          } else {
            System.out.println("------------------------------------------------------------------");
            System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
            System.out.println("- Deseja tentar digitar outro nome?                              -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
            System.out.println("------------------------------------------------------------------");
            System.out.print("- Opção: ");
            option = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                                -");
          }
        }
      } else if (vale.equals("vc")) {
        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < ValeCombustivel.listaCartoesVC.size() - 1; i++) {

          //Se encontra o beneficiário, imprime a lista
          if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().equals(nome)) {

            System.out.println("==================================================================");
            System.out.println("Vale Combustível - Extrato de transações                         =");
            System.out.println("==================================================================");
            System.out.println("-                                                                -");
            System.out.print("- Número da transação: ");
            System.out.println(ValeCombustivel.listaTransacoes.get(i).getIdentificadorDaTransacao());
            System.out.print("- Número do cartão: ");
            System.out.println(ValeCombustivel.listaTransacoes.get(i).getIdentificadorDoCartao());
            System.out.print("- Data e hora da transação: ");
            LocalDateTime dataEHora = ValeCombustivel.listaTransacoes.get(i).getDataHoraTransacao();
            formatarDataHoraPadrao(dataEHora);
            System.out.print("- Identificador do estabelecimento: ");
            System.out.println(ValeCombustivel.listaTransacoes.get(i).getIdenticadorDoEstabelecimento());
            System.out.print("- Tipo do estabelecimento: ");
            System.out.println(ValeCombustivel.listaTransacoes.get(i).getTipoDoEstabelecimento());
            System.out.print("- Localização do estabelecimento: ");
            System.out.println(ValeCombustivel.listaTransacoes.get(i).getLocalizacaoDoEstabelecimento());
            System.out.print("- Valor da transação: ");
            System.out.println(ValeCombustivel.listaTransacoes.get(i).getValorDaTransacao());
            System.out.println("-                                                                -");

            //Retorna mensagem de erro caso não encontra o beneficiário
          } else {
            System.out.println("------------------------------------------------------------------");
            System.out.println("- O beneficiário e/ou o cartão não existe!                       -");
            System.out.println("- Deseja tentar digitar outro nome?                              -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
            System.out.println("------------------------------------------------------------------");
            System.out.print("- Opção: ");
            option = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                                -");
          }
        }
      } else {
        System.out.println("------------------------------------------------------------------");
        System.out.println("-                                                                -");
        System.out.println("- Opção inválida! Digite uma opção dentre as disponíveis!        -");
      }
    } while (option == 's');
  }

  //Método para gerenciar o submenu 8: Sair do programa
  public static void sairPrograma() {
    System.out.println("==================================================================");
    System.out.println("= Obrigado por usar nossos serviços.                             =");
    System.out.println("==================================================================");
    System.out.println("-                                                                -");
    System.out.println("- A \"JavAlelo\" agradece a sua preferência!                       -");
    System.out.println("- Tenha um ótimo dia!                                            -");
    System.out.println("-                                                                -");
    System.out.println("------------------------------------------------------------------");
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
      System.out.println("\n==================================================================");
      System.out.println("= Menu -> Tela Principal                                         =");
      System.out.println("==================================================================");
      System.out.println("-                                                                -");
      System.out.println("- Digite uma das opções abaixo:");
      System.out.println("- 1 - Cadastrar beneficiários");
      System.out.println("- 2 - Cadastrar cartões de benefício");
      System.out.println("- 3 - Adicionar saldo em um cartão de benefício");
      System.out.println("- 4 - Cadastrar transações em um cartão");
      System.out.println("- 5 - Alterar data de validade de um cartão");
      System.out.println("- 6 - Visualizar saldo dos cartões de benefício");
      System.out.println("- 7 - Visualizar extrato de um cartão");
      System.out.println("- 8 - Sair do programa");
      System.out.print("- Opção: ");
      int opcao1 = in.nextInt();
      System.out.println("-                                                                -");

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
    System.out.println("\n==================================================================");
    System.out.println("= Olá! Bem-vindo(a) ao gerenciador de benefícios da \"JavAlelo\"   =!");
    System.out.println("==================================================================");
    System.out.println("-                                                                -");
    System.out.println("-Para começar, você precisa cadastrar um beneficiário.           -");
    System.out.println("-Vamos lá!                                                       -");
    System.out.println("-                                                                -");

    //Invoca o método para cadastrar o primeiro beneficiário
    Beneficiario.cadastrarBeneficiarioPrimeiraVez();

    System.out.println("- Perfeito!                                                      -");
    System.out.println("- Agora precisamos cadastrar os 3 cartões desse beneficiário.    -");
    System.out.println("------------------------------------------------------------------\n");


    //Invoca o método para realizar o cadastro de cartões do primeiro beneficiário
    Ferramentas.cadastrarCartoesBeneficioPrimeiravez();

    System.out.println("- Perfeito!                                                      -");
    System.out.println("- Carregando o módulo principal do gerenciador...                -");

    //Invoca o método para iniciar o menu principal do programa
    Ferramentas.inicializaMenuPrincipal();
  }
}