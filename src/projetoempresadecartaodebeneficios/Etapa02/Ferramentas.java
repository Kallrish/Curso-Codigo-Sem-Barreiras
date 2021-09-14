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
  public static boolean verificaTempoUmMinuto(LocalTime ultimaCompra, LocalTime t2) {

    long tempoQuePassou = ChronoUnit.MINUTES.between(ultimaCompra, LocalTime.now());

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
    System.out.println("Menu -> Cadastrar: Novo cartão de benefício");
    System.out.println("==================================================================\n");


  }

  //Método para gerenciar o submenu 3: adicionar saldo em benefício
  public static void adicionarSaldoBeneficio() {
    System.out.println("\n==================================================================");
    System.out.println("Menu -> Adicionar: Saldo em um cartão de benefício");
    System.out.println("==================================================================\n");


  }

  //Método para gerenciar o submenu 4: cadastrar transacoes em um cartão
  public static void cadastrarTransacoesCartao() {
    System.out.println("\n==================================================================");
    System.out.println("Menu -> Cadastrar: Transações de um Cartão");
    System.out.println("==================================================================\n");


  }

  //Método para gerenciar o submenu 5: alterar validade de um cartão
  public static void alterarValidadeCartao() {
    System.out.println("\n==================================================================");
    System.out.println("Menu -> Alterar: Validade de Cartão");
    System.out.println("==================================================================\n");


  }

  //Método para gerenciar o submenu 6: alterar validade de um cartão
  public static void mostrarSaldos() {

    String nome;
    ValeAlimentacao va = new ValeAlimentacao();
    ValeRefeicao vr = new ValeRefeicao();
    ValeCombustivel vc = new ValeCombustivel();

    try (Scanner in = new Scanner(System.in)) {

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
  }

  //Método para gerenciar o submenu 7: Visualizar extrato de um cartão
  public static void visualizarExtratoCartao() {
    System.out.println("\n==================================================================");
    System.out.println("Menu -> Visualizar: Extrato de um cartão de benefício");
    System.out.println("==================================================================\n");


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

  public static Boolean validaUsuarioSenha() {

    try (Scanner in = new Scanner(System.in)) {

      String nome, senha;
      char opcao = 's';

      do {

        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nome = in.nextLine().trim();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Digite uma senha para usar o cartão:");
        System.out.print("Senha: ");
        senha = in.nextLine().trim();
        if () {

        } else {
          System.out.println("-----------------------------------------------------------------");
          System.out.printf("Não foi possível realizar o cadastro.%nBeneficiário %s não encontrado!%n", nome);
          System.out.println("Deseja tentar digitar usuário e senha outra vez?");
          System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
          System.out.print("Opção: ");
          opcao = in.nextLine().trim().toLowerCase().charAt(0);
        }

      } while (opcao == 's');
    }
  }

  public static void inicializaMenuPrincipal() {

    try (Scanner in = new Scanner(System.in)) {

      boolean escolhaValidaMenu;

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
  }

  public static void inicializaPrograma() {

    Estabelecimento.inicializaEstabelecimentos();

    //Inicio do programa com retorno ao usuário
    System.out.println("\n==================================================================");
    System.out.println("Olá! Bem-vindo(a) ao gerenciador de benefícios da \"JavAlelo\"!");
    System.out.println("==================================================================\n");
    System.out.println("Para começar, você precisa cadastrar um beneficiário.");
    System.out.println("Vamos lá!");
    System.out.println("");

    //Chama método para cadastrar beneficiário
    Beneficiario.cadastrarBeneficiario();

    System.out.println("\n---------------------------------------------------------------");
    System.out.println("Perfeito!");
    System.out.println("Agora precisamos cadastrar os 3 cartões desse beneficiário.");
    System.out.println("---------------------------------------------------------------\n");

    Ferramentas.cadastrarCartoesBeneficio();

    System.out.println("\n---------------------------------------------------------------");
    System.out.println("Perfeito!");
    System.out.println("Carregando o módulo principal do gerenciador...");
    System.out.println("---------------------------------------------------------------\n");
  }

}
