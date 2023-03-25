public enum tipoContato {

    CELULAR("Celular"),
    EMAIL("Email");

    private String tipo;

    private tipoContato(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
