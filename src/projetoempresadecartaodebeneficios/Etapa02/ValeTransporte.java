package projetoempresadecartaodebeneficios.Etapa02;

public class ValeTransporte extends CartaoDeBeneficio implements ICartaoDeBeneficio{

  @Override
  public void comprar(Double valor) {

    this.saldo -= valor;
    System.out.printf("Compra efetuada com sucesso!%n");
    System.out.printf("Seu saldo atual: R$%.2f.", this.saldo);
  }

  @Override
  public void mostrarSaldo() {

    System.out.printf("Seu saldo atual é: R$%.2f.", this.saldo);
  }
}
