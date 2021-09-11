package projetoempresadecartaodebeneficios.Etapa02;

public class ValeAlimentacao extends CartaoDeBeneficio implements ICartaoDeBeneficio{

  @Override
  public void comprar(Double valor) {

    this.saldo -= valor;
    this.saldo += valor * 0.015;
    System.out.printf("Compra efetuada com sucesso!%n");
    System.out.printf("Você recebeu R$%.2f de cashback.", valor * 0.015);
    System.out.printf("Seu saldo atual: R$%.2f.", this.saldo);
  }

  @Override
  public void mostrarSaldo() {

    System.out.printf("Seu saldo atual é: R$%.2f.", this.saldo);
  }
}
