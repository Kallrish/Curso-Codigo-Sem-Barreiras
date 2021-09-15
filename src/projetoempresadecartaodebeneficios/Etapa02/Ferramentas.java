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

  public static Double valorAleatorioEntre200e100() {

    Random aleatorio = new Random();
    Double valor;
    Integer valor1 = aleatorio.nextInt(1000 - 200) + 200;
    valor = Double.valueOf(valor1);
    return valor;
  }

  public static Boolean verificaIdentificadorEstabelecimento(Integer index4, String identificador1) {

    return Estabelecimento.listaEstabelecimentos.get(index4).getIdentificadorEstabelecimento().contains(identificador1);
  }

  public static Boolean verificaValorVA(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeAlimentacao.listaTransacoes.get(index4).getValorDaTransacao();
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.contains(valorComparacaoString2);
  }

  public static Boolean verificaValorVR(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeRefeicao.listaTransacoes.get(index4).getValorDaTransacao();
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.contains(valorComparacaoString2);
  }

  public static Boolean verificaValorVC(Integer index4, Double valor1) {

    Double valorComparacaoDouble = ValeCombustivel.listaTransacoes.get(index4).getValorDaTransacao();
    String valorComparacaoString1 = valorComparacaoDouble.toString();
    String valorComparacaoString2 = valor1.toString();

    return valorComparacaoString1.contains(valorComparacaoString2);
  }

  //Método para gerenciar o submenu 2: cadastro de cartões
  public static void cadastrarCartoesBeneficio() {

    System.out.println("\n==================================================================");
    System.out.println("Menu -> Cadastrar: Novos cartões de benefício");
    System.out.println("==================================================================\n");

    Scanner in = new Scanner(System.in);

      //Instancia classes para efetuar o cadastro dos cartões
      ValeAlimentacao va = new ValeAlimentacao();
      ValeRefeicao vr = new ValeRefeicao();
      ValeCombustivel vc = new ValeCombustivel();

      //Declara variáveis necessárias
      String nome, senha;
      LocalDate data1, data2;
      char opcao = 's';

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Cadastrar: Vale Alimentação");
        System.out.println("==================================================================\n");
        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nome = in.nextLine().trim();
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Digite uma senha para usar o cartão:");
        System.out.print("Senha: ");
        senha = in.nextLine().trim();

        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < Beneficiario.listaBeneficiarios.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().contains(nome) &&
                  !ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().contains(nome)) {

            //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
            va.identificadorCartao = ValeAlimentacao.incrementoIdentificadorVA;

            //this.senhaCartao = senhaCartao;
            va.senhaCartao = senha;

            Double valorAleatorioSaldo = Ferramentas.valorAleatorioEntre200e100();
            va.saldoCartao = valorAleatorioSaldo;
            va.criaDataDeCadastro();
            data1 = va.dataDoCadastro;
            data2 = va.validadeCartao;
            va.criaDataDeValidade();
            ValeAlimentacao.listaCartoesVA.add(new ValeAlimentacao(ValeAlimentacao.incrementoIdentificadorVA++, nome, senha,
                    valorAleatorioSaldo, data1, data2));

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.println("\n==================================================================");
            System.out.println("Menu -> Cadastrar: Vale Refeição");
            System.out.println("==================================================================\n");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Digite uma senha para usar o cartão:");
            System.out.print("Senha: ");
            senha = in.nextLine().trim();

            //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
            vr.identificadorCartao = ValeRefeicao.incrementoIdentificadorVR;

            //this.senhaCartao = senhaCartao;
            vr.senhaCartao = senha;

            Double valorAleatorioSaldo2 = Ferramentas.valorAleatorioEntre200e100();
            vr.saldoCartao = valorAleatorioSaldo2;
            vr.criaDataDeCadastro();
            data1 = vr.dataDoCadastro;
            data2 = vr.validadeCartao;
            vr.criaDataDeValidade();
            ValeRefeicao.listaCartoesVR.add(new ValeRefeicao(ValeRefeicao.incrementoIdentificadorVR++, nome, senha,
                    valorAleatorioSaldo2, data1, data2));

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("-----------------------------------------------------------------");

            System.out.println("\n==================================================================");
            System.out.println("Menu -> Cadastrar: Vale Combustível");
            System.out.println("==================================================================\n");
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("Digite uma senha para usar o cartão:");
            System.out.print("Senha: ");
            senha = in.nextLine().trim();

            //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
            vc.identificadorCartao = ValeCombustivel.incrementoIdentificadorVC;

            //this.senhaCartao = senhaCartao;
            vc.senhaCartao = senha;

            Double valorAleatorioSaldo3 = Ferramentas.valorAleatorioEntre200e100();
            vc.saldoCartao = valorAleatorioSaldo3;
            vc.criaDataDeCadastro();
            data1 = vc.dataDoCadastro;
            data2 = vc.validadeCartao;
            vc.criaDataDeValidade();
            ValeCombustivel.listaCartoesVC.add(new ValeCombustivel(ValeCombustivel.incrementoIdentificadorVC++, nome, senha,
                    valorAleatorioSaldo3, data1, data2));

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("-----------------------------------------------------------------\n");

            //Retorna mensagem de erro caso não encontra o beneficiário
          } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Não foi possível realizar o cadastro.%nBeneficiário não existe ou cartão já existe!%n");
            System.out.println("Deseja tentar digitar outro nome?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);

          }
        }
      } while (opcao == 's');

      Ferramentas.inicializaMenuPrincipal();
  }

  //Método que cadastra os cartões na primeira vez que o programa é executado
  public static void cadastrarCartoesBeneficioPrimeiravez() {

    System.out.println("\n==================================================================");
    System.out.println("Menu -> Cadastrar: Novos cartões de benefício");
    System.out.println("==================================================================\n");

    Scanner in = new Scanner(System.in);

      //Instancia classes para efetuar o cadastro dos cartões
      ValeAlimentacao va1 = new ValeAlimentacao();
      ValeRefeicao vr1 = new ValeRefeicao();
      ValeCombustivel vc1 = new ValeCombustivel();

      //Declara variáveis necessárias
      String nome1, senha1;
      LocalDate data10, data20;
      char opcao1 = 's';

      System.out.println("\n==================================================================");
      System.out.println("Menu -> Cadastrar: Vale Alimentação");
      System.out.println("==================================================================\n");
      nome1 = Beneficiario.listaBeneficiarios.get(0).getNomeBeneficiario();
      System.out.println("Digite uma senha para usar o cartão:");
      System.out.print("Senha: ");
      senha1 = in.nextLine().trim();

      //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
      va1.identificadorCartao = ValeAlimentacao.incrementoIdentificadorVA;
      va1.senhaCartao = senha1;

      Double valorAleatorioSaldoA = Ferramentas.valorAleatorioEntre200e100();
      va1.saldoCartao = valorAleatorioSaldoA;
      va1.criaDataDeCadastro();
      data10 = va1.dataDoCadastro;
      data20 = va1.validadeCartao;
      va1.criaDataDeValidade();
      ValeAlimentacao.listaCartoesVA.add(new ValeAlimentacao(ValeAlimentacao.incrementoIdentificadorVA++, nome1, senha1,
              valorAleatorioSaldoA, data10, data20));

      System.out.println("\n---------------------------------------------------------------");
      System.out.println("Cadastro realizado com sucesso!");
      System.out.println("-----------------------------------------------------------------\n");


      System.out.println("\n==================================================================");
      System.out.println("Menu -> Cadastrar: Vale Refeição");
      System.out.println("==================================================================\n");
      System.out.println("Digite uma senha para usar o cartão:");
      System.out.print("Senha: ");
      senha1 = in.nextLine().trim();

      //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
      vr1.identificadorCartao = ValeRefeicao.incrementoIdentificadorVR;
      vr1.senhaCartao = senha1;

      Double valorAleatorioSaldoB = Ferramentas.valorAleatorioEntre200e100();
      vr1.saldoCartao = valorAleatorioSaldoB;
      vr1.criaDataDeCadastro();
      data10 = vr1.dataDoCadastro;
      data20 = vr1.validadeCartao;
      vr1.criaDataDeValidade();
      ValeRefeicao.listaCartoesVR.add(new ValeRefeicao(ValeRefeicao.incrementoIdentificadorVR++, nome1, senha1,
              valorAleatorioSaldoB, data10, data20));

      System.out.println("\n---------------------------------------------------------------");
      System.out.println("Cadastro realizado com sucesso!");
      System.out.println("-----------------------------------------------------------------\n");

      System.out.println("\n==================================================================");
      System.out.println("Menu -> Cadastrar: Vale Combustível");
      System.out.println("==================================================================\n");
      System.out.println("Digite uma senha para usar o cartão:");
      System.out.print("Senha: ");
      senha1 = in.nextLine().trim();

      //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
      vc1.identificadorCartao = ValeCombustivel.incrementoIdentificadorVC;
      vc1.senhaCartao = senha1;

      Double valorAleatorioSaldoC = Ferramentas.valorAleatorioEntre200e100();
      vc1.saldoCartao = valorAleatorioSaldoC;
      vc1.criaDataDeCadastro();
      data10 = vc1.dataDoCadastro;
      data20 = vc1.validadeCartao;
      vc1.criaDataDeValidade();
      ValeCombustivel.listaCartoesVC.add(new ValeCombustivel(ValeCombustivel.incrementoIdentificadorVC++, nome1, senha1,
              valorAleatorioSaldoC, data10, data20));

      System.out.println("\n---------------------------------------------------------------");
      System.out.println("Cadastro realizado com sucesso!");
      System.out.println("-----------------------------------------------------------------\n");
  }

  //Método para gerenciar o submenu 3: adicionar saldo em benefício
  public static void adicionarSaldoBeneficio() {

    //Instancia classes para efetuar o cadastro dos cartões
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();

    //Cria as variáveis necessárias
    String vale, nome;
    Double valorParaAdicionar;
    char option = 's';

    Scanner in = new Scanner(System.in);

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Adicionar: Saldo em um cartão de benefício");
        System.out.println("==================================================================\n");
        System.out.println("Digite o código do benefício:");
        System.out.println("\"VA\" - Vale Alimentação");
        System.out.println("\"VR\" - Vale Refeição");
        System.out.println("\"VC\" - Vale Combustível");
        System.out.print("Opção: ");
        vale = in.nextLine().trim();
        System.out.println("\nDigite o nome do beneficiário:");
        nome = in.nextLine().trim();
        System.out.println("\nDigite o valor a ser adicionado: ");
        valorParaAdicionar = in.nextDouble();

        if (vale.contains("VA")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size() - 1; i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().contains(nome) && valorParaAdicionar > 0) {
              va.adicionaSaldoVA(valorParaAdicionar);
              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.printf("%nValor de %f adicionado com sucesso!%n", valorParaAdicionar);
              System.out.printf("%nAgora o saldo do Vale Alimentação de%n%s é %f!%n", nome, va.getSaldoVA());

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário não existe ou o valor é negativo!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else if (vale.contains("VR")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeRefeicao.listaCartoesVR.size() - 1; i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().contains(nome) && valorParaAdicionar > 0) {
              vr.adicionaSaldoVR(valorParaAdicionar);
              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.printf("%nValor de %f adicionado com sucesso!%n", valorParaAdicionar);
              System.out.printf("%nAgora o saldo do Vale Refeição de%n%s é %f!%n", nome, vr.getSaldoVR());

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário não existe ou o valor é negativo!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else if (vale.contains("VC")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeCombustivel.listaCartoesVC.size() - 1; i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().contains(nome) && valorParaAdicionar > 0) {
              vc.adicionaSaldoVC(valorParaAdicionar);
              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.printf("%nValor de %f adicionado com sucesso!%n", valorParaAdicionar);
              System.out.printf("%nAgora o saldo do Vale Combustível de%n%s é %f!%n", nome, vc.getSaldoVC());

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------\n");
              System.out.println("O beneficiário não existe ou o valor é negativo!");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else {
          System.out.println("-----------------------------------------------------------------\n");
          System.out.println("Opção inválida! Digite uma opção dentre as disponíveis!\n");
        }
      } while (option == 's');
      Ferramentas.inicializaMenuPrincipal();
  }

  //Método para gerenciar o submenu 4: cadastrar transacoes em um cartão
  public static void cadastrarTransacoesCartao() {
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();
    char opcao = 's';

    Scanner in = new Scanner(System.in);
      System.out.println("\n==================================================================");
      System.out.println("Menu -> Cadastrar: Transações de um Cartão");
      System.out.println("==================================================================\n");
      do {
        System.out.println("Em qual cartão você gostaria de adicionar a transação? [VA] [VR] [VC]");
        String resposta = in.nextLine().trim();

        if (resposta.equals("VA")) {
          va.adicionarTransacao();
        } else if (resposta.equals("VR")) {
          vr.adicionarTransacao();
        } else if (resposta.equals("VC")) {
          vc.adicionarTransacao();
        } else {
          System.out.println("Opção incorreta!");
          System.out.println("Deseja tentar novamente? [s] [n]");
          opcao = in.nextLine().trim().toLowerCase().charAt(0);
        }
      } while (opcao == 's');
      Ferramentas.inicializaMenuPrincipal();
  }

  //Método para gerenciar o submenu 5: expirar validade de um cartão
  public static void alterarValidadeCartao() {

    //Instancia classes para efetuar o cadastro dos cartões
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();

    //Cria as variáveis necessárias
    String vale, nome;
    Double valorParaAdicionar;
    char option = 's';

    Scanner in = new Scanner(System.in);

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Expirar: Validade de um cartão");
        System.out.println("==================================================================\n");
        System.out.println("Digite o código do benefício:");
        System.out.println("\"VA\" - Vale Alimentação");
        System.out.println("\"VR\" - Vale Refeição");
        System.out.println("\"VC\" - Vale Combustível");
        System.out.print("Opção: ");
        vale = in.nextLine().trim();
        System.out.println("\nDigite o nome do beneficiário:");
        nome = in.nextLine().trim();

        if (vale.contains("VA")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size() - 1; i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().contains(nome)) {
              va.validadeCartao = va.dataDoCadastro.minusDays(1);
              ValeAlimentacao.listaCartoesVA.get(i).setValidadeCartaoVA(va.validadeCartao);
              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.printf("A data de validade do cartão foi alterada!%n");
              System.out.printf("%nData de validade expirada com sucesso!");

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário e/ou o cartão não existe!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else if (vale.contains("VR")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeRefeicao.listaCartoesVR.size() - 1; i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().contains(nome)) {
              vr.validadeCartao = vr.dataDoCadastro.minusDays(1);
              ValeRefeicao.listaCartoesVR.get(i).setValidadeCartaoVR(vr.validadeCartao);
              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.printf("A data de validade do cartão foi alterada!%n");
              System.out.printf("%nData de validade expirada com sucesso!");

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário e/ou o cartão não existe!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else if (vale.contains("VC")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeCombustivel.listaCartoesVC.size() - 1; i++) {

            //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
            if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().contains(nome)) {
              vc.validadeCartao = vc.dataDoCadastro.minusDays(1);
              ValeCombustivel.listaCartoesVC.get(i).setValidadeCartaoVC(vc.validadeCartao);
              System.out.println("\n-----------------------------------------------------------------\n");
              System.out.printf("A data de validade do cartão foi alterada!%n");
              System.out.printf("%nData de validade expirada com sucesso!");

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário e/ou o cartão não existe!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else {
          System.out.println("-----------------------------------------------------------------\n");
          System.out.println("Opção inválida! Digite uma opção dentre as disponíveis!\n");
        }
      } while (option == 's');
      Ferramentas.inicializaMenuPrincipal();
  }

  //Método para gerenciar o submenu 6: alterar validade de um cartão
  public static void mostrarSaldos() {

    String nome;
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();

    Scanner in = new Scanner(System.in);

      char opcao = 's';

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Visualizar: Saldo dos cartões de benefício");
        System.out.println("==================================================================\n");
        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nome = in.nextLine().trim();

        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < Beneficiario.listaBeneficiarios.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().contains(nome)) {

            Double saldoAtualVA = ValeAlimentacao.listaCartoesVA.get(i).getSaldoVA();
            Double saldoAtualVR = ValeRefeicao.listaCartoesVR.get(i).getSaldoVR();
            Double saldoAtualVC = ValeCombustivel.listaCartoesVC.get(i).getSaldoVC();
            System.out.println("-----------------------------------------------------------------\n");
            System.out.printf("%s,%n", nome);
            System.out.println("Aqui estão os saldos atuais dos seus benefícios:");
            va.mostrarSaldo(saldoAtualVA);
            vr.mostrarSaldo(saldoAtualVR);
            vc.mostrarSaldo(saldoAtualVC);
            System.out.println("\n-----------------------------------------------------------------\n");
            System.out.println("Deseja cadastrar outro beneficiário?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);

            //Retorna mensagem de erro caso não encontra o beneficiário
          } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("Não foi possível realizar o cadastro.%nBeneficiário %s não encontrado!%n", nome);
            System.out.println("Deseja digitar o nome de outro beneficiário?");
            System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
            System.out.print("Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);

          }
        }
      } while (opcao == 's');
  }

  //Método para gerenciar o submenu 7: Visualizar extrato de um cartão
  public static void visualizarExtratoCartao() {
    //Instancia classes para efetuar o cadastro dos cartões
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();

    //Cria as variáveis necessárias
    String vale, nome;
    Double valorParaAdicionar;
    char option = 's';

    Scanner in = new Scanner(System.in);

      do {
        System.out.println("\n==================================================================");
        System.out.println("Menu -> Menu -> Emitir: Extrato de transações");
        System.out.println("==================================================================\n");
        System.out.println("Digite o código do benefício:");
        System.out.println("\"VA\" - Vale Alimentação");
        System.out.println("\"VR\" - Vale Refeição");
        System.out.println("\"VC\" - Vale Combustível");
        System.out.print("Opção: ");
        vale = in.nextLine().trim();
        System.out.println("\nDigite o nome do beneficiário:");
        nome = in.nextLine().trim();

        if (vale.contains("VA")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeAlimentacao.listaCartoesVA.size() - 1; i++) {

            //Se encontra o beneficiário, imprime a lista
            if (ValeAlimentacao.listaCartoesVA.get(i).getNomeBeneficiarioVA().contains(nome)) {

              System.out.println("\n==================================================================");
              System.out.println("Vale Alimentação - Extrato de transações");
              System.out.println("==================================================================\n");

              System.out.print("Número da transação: ");
              System.out.println(ValeAlimentacao.listaTransacoes.get(i).getIdentificadorDaTransacao());
              System.out.print("Número do cartão: ");
              System.out.println(ValeAlimentacao.listaTransacoes.get(i).getIdentificadorDoCartao());
              System.out.print("Data e hora da transação: ");
              LocalDateTime dataEHora = ValeAlimentacao.listaTransacoes.get(i).getDataHoraTransacao();
              formatarDataHoraPadrao(dataEHora);
              System.out.print("Identificador do estabelecimento: ");
              System.out.println(ValeAlimentacao.listaTransacoes.get(i).getIdenticadorDoEstabelecimento());
              System.out.print("Tipo do estabelecimento: ");
              System.out.println(ValeAlimentacao.listaTransacoes.get(i).getTipoDoEstabelecimento());
              System.out.print("Localização do estabelecimento: ");
              System.out.println(ValeAlimentacao.listaTransacoes.get(i).getLocalizacaoDoEstabelecimento());
              System.out.print("Valor da transação: ");
              System.out.println(ValeAlimentacao.listaTransacoes.get(i).getValorDaTransacao());
              System.out.println("");

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário e/ou o cartão não existe!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else if (vale.contains("VR")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeRefeicao.listaCartoesVR.size() - 1; i++) {

            //Se encontra o beneficiário, imprime a lista
            if (ValeRefeicao.listaCartoesVR.get(i).getNomeBeneficiarioVR().contains(nome)) {

              System.out.println("\n==================================================================");
              System.out.println("Vale Refeição - Extrato de transações");
              System.out.println("==================================================================\n");

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
              System.out.println("");

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário e/ou o cartão não existe!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else if (vale.contains("VC")) {
          //Laço para percorrer a lista de beneficiários
          for (int i = 0; i < ValeCombustivel.listaCartoesVC.size() - 1; i++) {

            //Se encontra o beneficiário, imprime a lista
            if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().contains(nome)) {

              System.out.println("\n==================================================================");
              System.out.println("Vale Refeição - Extrato de transações");
              System.out.println("==================================================================\n");

              System.out.print("Número da transação: ");
              System.out.println(ValeCombustivel.listaTransacoes.get(i).getIdentificadorDaTransacao());
              System.out.print("Número do cartão: ");
              System.out.println(ValeCombustivel.listaTransacoes.get(i).getIdentificadorDoCartao());
              System.out.print("Data e hora da transação: ");
              LocalDateTime dataEHora = ValeCombustivel.listaTransacoes.get(i).getDataHoraTransacao();
              formatarDataHoraPadrao(dataEHora);
              System.out.print("Identificador do estabelecimento: ");
              System.out.println(ValeCombustivel.listaTransacoes.get(i).getIdenticadorDoEstabelecimento());
              System.out.print("Tipo do estabelecimento: ");
              System.out.println(ValeCombustivel.listaTransacoes.get(i).getTipoDoEstabelecimento());
              System.out.print("Localização do estabelecimento: ");
              System.out.println(ValeCombustivel.listaTransacoes.get(i).getLocalizacaoDoEstabelecimento());
              System.out.print("Valor da transação: ");
              System.out.println(ValeCombustivel.listaTransacoes.get(i).getValorDaTransacao());
              System.out.println("");

              //Retorna mensagem de erro caso não encontra o beneficiário
            } else {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("O beneficiário e/ou o cartão não existe!%n");
              System.out.println("Deseja tentar digitar outro nome?");
              System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
              System.out.print("Opção: ");
              option = in.nextLine().trim().toLowerCase().charAt(0);
            }
          }
        } else {
          System.out.println("-----------------------------------------------------------------\n");
          System.out.println("Opção inválida! Digite uma opção dentre as disponíveis!\n");
        }
      } while (option == 's');
      Ferramentas.inicializaMenuPrincipal();
  }

  //Método para gerenciar o submenu 8: Sair do programa
  public static void sairPrograma() {
    System.out.println("\n==================================================================");
    System.out.println("\nObrigado por usar nossos serviços.\n");
    System.out.println("==================================================================\n");
    System.out.println("A \"JavAlelo\" agradece a sua preferência!");
    System.out.println("Tenha um ótimo dia!\n");
    System.out.println("-----------------------------------------------------------------");
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
        System.out.println("Menu -> Tela Principal");
        System.out.println("==================================================================\n");
        System.out.println("Digite uma das opções abaixo:");
        System.out.println("1 - Cadastrar beneficiários");
        System.out.println("2 - Cadastrar cartões de benefício");
        System.out.println("3 - Adicionar saldo em um cartão de benefício");
        System.out.println("4 - Cadastrar transações em um cartão");
        System.out.println("5 - Alterar data de validade de um cartão");
        System.out.println("6 - Visualizar saldo dos cartões de benefício");
        System.out.println("7 - Visualizar extrato de um cartão");
        System.out.println("8 - Sair do programa");
        int opcao1 = in.nextInt();

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
          default -> System.out.println("Escolha um número entre 1 a 8!");
        }
      } while (!escolhaValidaMenu);
  }

  //Método para inicializar o programa na classe Main
  public static void inicializaPrograma() {

    //Invoca o método para inicializar os estabelecimentos com dados pré-preenchidos
    Estabelecimento.inicializaEstabelecimentos();

    //Inicio do programa com retorno ao usuário
    System.out.println("\n==================================================================");
    System.out.println("Olá! Bem-vindo(a) ao gerenciador de benefícios da \"JavAlelo\"!");
    System.out.println("==================================================================\n");
    System.out.println("Para começar, você precisa cadastrar um beneficiário.");
    System.out.println("Vamos lá!");
    System.out.println("");

    //Invoca o método para cadastrar o primeiro beneficiário
    Beneficiario.cadastrarBeneficiario();

    System.out.println("\n---------------------------------------------------------------");
    System.out.println("Perfeito!");
    System.out.println("Agora precisamos cadastrar os 3 cartões desse beneficiário.");
    System.out.println("---------------------------------------------------------------\n");

    //Invoca o método para realizar o cadastro de cartões do primeiro beneficiário
    Ferramentas.cadastrarCartoesBeneficioPrimeiravez();

    System.out.println("\n---------------------------------------------------------------");
    System.out.println("Perfeito!");
    System.out.println("Carregando o módulo principal do gerenciador...");
    System.out.println("---------------------------------------------------------------\n");
    Ferramentas.inicializaMenuPrincipal();
  }

}