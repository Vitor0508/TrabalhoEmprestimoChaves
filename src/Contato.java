public class Contato {
    private long id;
    private tipoContato tipo;
    private String valor;

    public Contato() {
    }
    public Contato(long id, tipoContato tipo, String valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public tipoContato getTipo() {
        return tipo;
    }
    public void setTipo(tipoContato tipo) {
        this.tipo = tipo;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Contato [id=" + id + ", tipo=" + tipo + ", valor=" + valor + "]";
    }

}
