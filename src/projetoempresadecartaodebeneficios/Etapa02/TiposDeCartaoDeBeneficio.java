package projetoempresadecartaodebeneficios.Etapa02;

public enum TiposDeCartaoDeBeneficio {

  VA {
    @Override
    public InterfaceCartaoDeBeneficio fabricar() {
      return new ValeAlimentacao();
    }
  },
  VR {
    @Override
    public InterfaceCartaoDeBeneficio fabricar() {
      return new ValeRefeicao();
    }
  },
  VT {
    @Override
    public InterfaceCartaoDeBeneficio fabricar() {
      return new ValeCombustivel();
    }
  };

  abstract InterfaceCartaoDeBeneficio fabricar();

}
