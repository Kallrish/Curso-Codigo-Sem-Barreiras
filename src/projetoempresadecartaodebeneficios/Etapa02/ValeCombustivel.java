package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValeCombustivel extends CartaoDeBeneficio implements InterfaceCartaoDeBeneficio {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorVC = 1;
  public static Integer incrementoIdentificadorTransacoesVC = 1;
  int index = 0;

  //Cria uma lista para armazenar as transações do VC
  public static List<ValeCombustivel> listaCartoesVC = new ArrayList<>();

  public ValeCombustivel() {

  }

  public ValeCombustivel(Integer identificadorCartao, String nomeBeneficiario, String senhaCartao,
                         Double saldoCartao, LocalDate dataDoCadastro, LocalDate validadeCartao) {

    this.identificadorCartao = identificadorCartao;
    this.saldoCartao = saldoCartao;
    this.senhaCartao = senhaCartao;
    this.criaDataDeCadastro();
    this.criaDataDeValidade();
    this.nomeBeneficiario = nomeBeneficiario;
  }

  public void cadastrarVC() {

    Scanner in = new Scanner(System.in);

      String nome, senha;
      char opcao = 's';
      LocalDate data1, data2;

      do {
        System.out.println("=================================================================");
        System.out.println("= Menu -> Cadastrar: Vale Combustível                           =");
        System.out.println("=================================================================");
        System.out.println("- Insira o nome do(a) beneficiário(a):                          -");
        System.out.print("- Nome: ");
        nome = in.nextLine().trim();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("- Digite uma senha para usar o cartão:                          -");
        System.out.print("- Senha: ");
        senha = in.nextLine().trim();
        System.out.println("-                                                               -");

        //Laço para percorrer a lista de beneficiários
        for (int i = 0; i < Beneficiario.listaBeneficiarios.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().equals(nome)) {

            //Armazena no cartão: identificador, saldo inicial, senha e cria data de cadastro e validade
            this.identificadorCartao = incrementoIdentificadorVC;

            //this.senhaCartao = senhaCartao;
            this.senhaCartao = senha;

            Double valorAleatorioSaldo = Ferramentas.valorAleatorioEntre200e1000();
            this.saldoCartao = valorAleatorioSaldo;
            this.criaDataDeCadastro();
            data1 = this.dataDoCadastro;
            data2 = this.validadeCartao;
            this.criaDataDeValidade();
            listaCartoesVC.add(new ValeCombustivel(incrementoIdentificadorVC++, nome, senha,
                    valorAleatorioSaldo, data1, data2));

            System.out.println("-----------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("- Deseja cadastrar outro beneficiário?                          -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
            System.out.print("- Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                               -");

            //Retorna mensagem de erro caso não encontra o benefiário
          } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("- Não foi possível realizar o cadastro.                         -");
            System.out.printf("- Beneficiário %s não encontrado!%n", nome);
            System.out.println("- Deseja cadastrar outro beneficiário?                          -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
            System.out.print("- Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                               -");
          }
        }
      } while (opcao == 's');
  }


  @Override
  public void criaDataDeCadastro() {

    //Cria a data de cadastro pegando a data atual do momento do cadastro
    this.dataDoCadastro = LocalDate.now();

  }

  @Override
  public void criaDataDeValidade() {

    //Cria a validade do cartão, definindo 2 anos como padrão.
    this.validadeCartao = dataDoCadastro.plusYears(2);

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

        for (int i = 0; i < ValeCombustivel.listaCartoesVC.size() - 1; i++) {

          //Se encontra o beneficiário, armazena o identificador ao cartão ao beneficiário na lsita
          if (ValeCombustivel.listaCartoesVC.get(i).getNomeBeneficiarioVC().equals(nome) &&
                  ValeCombustivel.listaCartoesVC.get(i).getSenhaVC().equals(senha)) {

            identificadorDoCartao = listaCartoesVC.get(i).identificadorCartao;

            System.out.println("=================================================================");
            System.out.println("= Menu -> Cadastrar: Transação no Vale Combustível              =");
            System.out.println("=================================================================");
            String continua;
            System.out.println("-                                                               -");

            do {

              LocalDate dataCadastroCartao = ValeAlimentacao.listaCartoesVA.get(i).dataDoCadastro;
              String identificadorUltimoEstabelecimento = ValeAlimentacao.listaTransacoes.get(index).getIdenticadorDoEstabelecimento();
              Double valorUltimaCompra = ValeAlimentacao.listaTransacoes.get(index).getValorDaTransacao();

              LocalDateTime dataHoraUltimaCompra = ValeAlimentacao.listaTransacoes.get(index).getDataHoraTransacao();
              LocalTime horaUltimaCompra = dataHoraUltimaCompra.toLocalTime();

              System.out.println("-                                                               -");
              System.out.println("- Digite o código do estabelecimento onde foi efetuada a compra:-");
              System.out.println("- [PO01] - Posto Delta                                          -");
              System.out.println("- [ME01] - Mercearia São José                                   -");
              System.out.println("- [SU01] - Supermercado ABC                                     -");
              System.out.println("- [PA01] - Padaria Sonhos                                       -");
              System.out.println("- [RE01] - Restaurante La Marmita                               -");
              System.out.print("- Código: ");
              String codigoEstabelecimento = in.nextLine().trim();
              System.out.println("-                                                               -");

              String identicadorDoEstabelecimento = Estabelecimento.buscaEstabelecimento(codigoEstabelecimento);
              String localizacaoEstabelecimento = Estabelecimento.buscaLocalizacaoEstabelecimento(codigoEstabelecimento);

              System.out.println("Qual o valor da transação?");
              Double valorDaTransacao = in.nextDouble();


              //Regra específica 1 do VC: Verifica se é posto de combustível
              if (!identicadorDoEstabelecimento.equals("Posto Delta")) {
                System.out.println("-                                                               -");
                System.out.println("- Só é possível usar este benefício neste em postos de          -");
                System.out.println("- combustível!                                                  -");
                System.out.println("-                                                               -");

                //Verifica se é valor negativo
              } else if (valorDaTransacao < 0) {
                System.out.println("-                                                               -");
                System.out.println("- Digite um valor maior que zero!                               -");
                System.out.println("-                                                               -");

                //Verifica a validade do cartão
              } else if (!Ferramentas.verificaValidade(dataCadastroCartao)) {
                System.out.println("-                                                               -");
                System.out.println("- Cartão vencido! Não é possível realizar essa transação!       -");
                System.out.println("-                                                               -");

                //Verifica se saldo é suficiente para transação
              } else if (valorDaTransacao > this.saldoCartao) {
                System.out.println("-                                                               -");
                System.out.println("- Você não tem saldo suficiente para realizar esta operação!    -");
                System.out.println("-                                                               -");

                //Verifica se houve duas compras do mesmo valor em menos de 30 segundos
              } else if (Ferramentas.verificaTempoSegundos(horaUltimaCompra) &&
                      Ferramentas.verificaIdentificadorEstabelecimento(i, identificadorUltimoEstabelecimento) &&
                      Ferramentas.verificaValorVC(i, valorUltimaCompra)) {
                System.out.println("-                                                               -");
                System.out.println("- Você só pode realizar uma transação de mesmo valor.           -");
                System.out.println("- a cada 30 segundos!                                           -");
                System.out.println("-                                                               -");

                //Verifica se houve três compras do mesmo valor em menos de 1 minuto
              } else if (Ferramentas.verificaTempoUmMinuto(horaUltimaCompra)) {
                System.out.println("-                                                               -");
                System.out.println("- Você não pode realizar mais que duas compras em 1 minuto!     -");
                System.out.println("-                                                               -");

                //Regra específica 2 do VC: Uma compra a cada 2 minutos
              } else if (!Ferramentas.verificaTempoDoisMinutos(horaUltimaCompra)) {
                System.out.println("-                                                               -");
                System.out.println("- Você só pode realizar uma transação a cada 2 minutos!         -");
                System.out.println("-                                                               -");

              } else {
                // Armazena os dados da transação no lista de transações
                LocalDateTime dataDoCadastroTransacao = LocalDateTime.now();
                listaTransacoes.add(new Transacao(incrementoIdentificadorTransacoesVC++, nome, identificadorDoCartao,
                        dataDoCadastroTransacao, identicadorDoEstabelecimento, localizacaoEstabelecimento,
                        codigoEstabelecimento, valorDaTransacao));

                this.saldoCartao -= valorDaTransacao;
                //Regra específica 3 do VC: Desconta R$1 de taxa do saldo.
                this.saldoCartao -= 1.00;

                System.out.println("-----------------------------------------------------------------");
                System.out.println("- Compra efetuada com sucesso!                                  -");
                System.out.println("- Você pagou uma taxa de R$1,00 pelo abastecimento.             -");
                System.out.printf("- Seu saldo atual: R$%.2f.", this.saldoCartao);
                System.out.println("-                                                               -");
              }

              System.out.println("-----------------------------------------------------------------");
              System.out.println("- Deseja cadastrar outra transação?                             -");
              System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
              System.out.print("- Opção: ");
              opcao = in.nextLine().trim().toLowerCase().charAt(0);
              System.out.println("-                                                               -");

            } while (opcao != 'n');

          } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("- Nome e/ou senha estão incorretos!                             -");
            System.out.println("- Deseja tentar digitar usuário e senha outra vez?              -");
            System.out.println("- Digite [s] para SIM e [n] para NÃO.                           -");
            System.out.print("- Opção: ");
            opcao = in.nextLine().trim().toLowerCase().charAt(0);
            System.out.println("-                                                               -");

          }
        }
      } while (opcao == 's');
  }

  public static void mostrarSaldo(Double saldoAtual1) {
    System.out.println("-                                                               -");
    System.out.printf("- Vale Combustível: R$%.2f.%n", saldoAtual1);
    System.out.println("-                                                               -");
  }

  public Double getSaldoVC() {
    return saldoCartao;
  }

  public LocalDate getDatadoCadastroVC() {
    return dataDoCadastro;
  }

  public String getNomeBeneficiarioVC() {
    return nomeBeneficiario;
  }

  public String getSenhaVC() {
    return senhaCartao;
  }

  public LocalDate getValidadeCartaoVC() {
    return validadeCartao;
  }

  public void setValidadeCartaoVC(LocalDate validadeCartao) {
    this.validadeCartao = validadeCartao;
  }

  public static void adicionaSaldoVC(Integer index, Double valor) {

    Double pegaValorAtual = ValeCombustivel.listaCartoesVC.get(index).saldoCartao;
    ValeCombustivel.listaCartoesVC.get(index).saldoCartao = pegaValorAtual + valor;

  }


  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof ValeRefeicao))
      return false;

    if (obj == this)
      return true;

    ValeRefeicao p = (ValeRefeicao) obj;

    // Aqui você implementa como deve se feita a comparação.
    // Verifica se os nomes dos produtos são iguais, ids e etc.

    if (p.nomeBeneficiario == this.nomeBeneficiario) {
      return true;
    } else {
      return false;
    }
  }

}