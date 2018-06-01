package br.inf.sefaz.portalfiscal;

public enum  WebServicesAmbiente {
    PRODUCAO("1"), HOMOLOGACAO("2");

    private String codigo;

    WebServicesAmbiente(String codigo) {

        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
