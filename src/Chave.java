public class Chave {
    private long codigo;
    private String sala;
    private Boolean disponivel;
    
    public Chave() {
    }

    public Chave(long codigo, String sala, Boolean disponivel) {
        this.codigo = codigo;
        this.sala = sala;
        this.disponivel = disponivel;
    }

    public Chave(long codigo, String sala) {
        this.codigo = codigo;
        this.sala = sala;
        this.disponivel = true;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    
    @Override
    public String toString() {
        return "Chave:"+ sala +"\ncodigo=" + codigo + "\ndisponivel=" + disponivel + "\n";
    }

    public void retirarChave() {
        this.disponivel = false;
    }

    public void devolverChave() {
        this.disponivel = true;
    }


}
