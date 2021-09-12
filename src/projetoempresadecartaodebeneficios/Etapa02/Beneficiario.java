package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beneficiario {

  //Cria as variáveis necessárias
  public String nomeBeneficiario;
  private String senhaBeneficiario;
  public String vaIdentificador;
  public String vrIdentificador;
  public String vcIdentificador;

  //Cria uma lista com os beneficiários
  public static List<Beneficiario> listaBeneficiarios = new ArrayList<>();


  public Beneficiario(String nomeBeneficiario, String senhaBeneficiario) {
    this.nomeBeneficiario = nomeBeneficiario;
    this.senhaBeneficiario = senhaBeneficiario;
  }

  public static void cadastrarBeneficiario(String nomeBeneficiario1, String senhaBeneficiario1){

    listaBeneficiarios.add(new Beneficiario(nomeBeneficiario1, senhaBeneficiario1));
  }

  public String getNomeBeneficiario() {
    return nomeBeneficiario;
  }

  public void setNomeBeneficiario(String nomeBeneficiario) {
    this.nomeBeneficiario = nomeBeneficiario;
  }

  public String getSenhaBeneficiario() {
    return senhaBeneficiario;
  }

  public void setSenhaBeneficiario(String senhaBeneficiario) {
    this.senhaBeneficiario = senhaBeneficiario;
  }

  public String getVaIdentificador() {
    return vaIdentificador;
  }

  public void setVaIdentificador(String vaIdentificador) {
    this.vaIdentificador = vaIdentificador;
  }

  public String getVrIdentificador() {
    return vrIdentificador;
  }

  public void setVrIdentificador(String vrIdentificador) {
    this.vrIdentificador = vrIdentificador;
  }

  public String getVcIdentificador() {
    return vcIdentificador;
  }

  public void setVcIdentificador(String vcIdentificador) {
    this.vcIdentificador = vcIdentificador;
  }

}