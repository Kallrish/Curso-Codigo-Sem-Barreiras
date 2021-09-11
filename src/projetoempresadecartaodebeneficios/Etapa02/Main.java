package projetoempresadecartaodebeneficios.Etapa02;

public class Main {

  public static void main(String[] args) {

    Beneficiario.cadastrarBeneficiario();

  }
//   try (
//  Scanner scanner = new Scanner(System.in)) {
//
//    String escape;
//
//    do {
//
//      System.out.println("Em qual cartão você deseja gastar? [VA, VR, VT, VHO]");
//      String tipoCartao = scanner.next();
//
//      ICartaoDeBeneficio cartaoDeBeneficio = TiposDeCartaoDeBeneficio.valueOf(tipoCartao).fabricar();
//
//      System.out.println("Qual o valor da compra?");
//      var valorDaCompra = scanner.nextDouble();
//
//      cartaoDeBeneficio.comprar(valorDaCompra);
//
//      cartaoDeBeneficio.mostrarSaldo();
//
//      System.out.println("Deseja continuar gastando? [s, n]");
//      escape = scanner.next();
//
//    } while (!escape.equals("n"));
  }