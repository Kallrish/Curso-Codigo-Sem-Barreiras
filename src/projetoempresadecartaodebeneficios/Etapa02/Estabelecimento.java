package projetoempresadecartaodebeneficios.Etapa02;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {

  //Cria as variáveis necessárias para classe
  private final String identificadorEstabelecimento;
  private String nomeEstabelecimento;
  private String tipoEstabelecimento;
  private String localizacaoEstabelecimento;

  //Cria uma lista de dados inicializada com os estabelecimentos
  public static List<Estabelecimento> listaEstabelecimentos = new ArrayList<>();

  //Método para cadastrar estabelecimentos
  public Estabelecimento(String identificadorEstabelecimento, String nomeEstabelecimento,
                         String tipoEstabelecimento, String localizacaoEstabelecimento) {

    this.identificadorEstabelecimento = identificadorEstabelecimento;
    this.nomeEstabelecimento = nomeEstabelecimento;
    this.tipoEstabelecimento = tipoEstabelecimento;
    this.localizacaoEstabelecimento = localizacaoEstabelecimento;
  }

  public static void inicializaEstabelecimentos() {

    //Posto de gasolina
    listaEstabelecimentos.add(new Estabelecimento("PO01", "Posto Delta",
            "combustivel", "São Paulo/SP"));
    //Mercearia
    listaEstabelecimentos.add(new Estabelecimento("ME01", "Mercearia São José",
            "mercearia", "Blumenau/SC"));
    //Supermercado
    listaEstabelecimentos.add(new Estabelecimento("SU01", "Supermercado ABC",
            "supermercado", "Divinópolis/MG"));
    //Padaria
    listaEstabelecimentos.add(new Estabelecimento("PA01", "Padaria Sonhos",
            "padaria", "Rio de Janeiro/RJ"));
    //Restaurante
    listaEstabelecimentos.add(new Estabelecimento("RE01", "Restaurante La Marmita",
            "restaurante", "Lauro de Freitas/BA"));
  }

  public static String buscaEstabelecimento(String codigoEstabelecimento) {
    for (int i = 0; i < listaEstabelecimentos.size(); i++) {
      if (listaEstabelecimentos.get(i).identificadorEstabelecimento.equals(codigoEstabelecimento)) {
        return listaEstabelecimentos.get(i).nomeEstabelecimento;
      }
    }
    System.out.println("-----------------------------------------------------------------");
    System.out.println("- O código digitado está errado!                                -");
    System.out.println("-----------------------------------------------------------------");
    return "";
  }

  public static String buscaLocalizacaoEstabelecimento(String codigoEstabelecimento) {
    for (int i = 0; i < listaEstabelecimentos.size(); i++) {
      if (listaEstabelecimentos.get(i).identificadorEstabelecimento.equals(codigoEstabelecimento)) {
        return listaEstabelecimentos.get(i).localizacaoEstabelecimento;
      }
    }
    System.out.println("-----------------------------------------------------------------");
    System.out.println("- O código digitado está errado!                                -");
    System.out.println("-----------------------------------------------------------------");
    return "";
  }

  public String getIdentificadorEstabelecimento() {
    return identificadorEstabelecimento;
  }

  public String getNomeEstabelecimento() {
    return nomeEstabelecimento;
  }

  public String getTipoEstabelecimento() {
    return tipoEstabelecimento;
  }

  public String getLocalizacaoEstabelecimento() {
    return localizacaoEstabelecimento;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof Estabelecimento))
      return false;

    if (obj == this)
      return true;

    Estabelecimento p = (Estabelecimento) obj;

    // Aqui você implementa como deve se feita a comparação.
    // Verifica se os nomes dos produtos são iguais, ids e etc.

    if (p.identificadorEstabelecimento == this.identificadorEstabelecimento) {
      return true;
    } else {
      return false;
    }
  }
}