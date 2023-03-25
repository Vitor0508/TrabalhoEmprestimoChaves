import java.util.ArrayList;

public class Pessoa {
    private long codigo;
    private String nome;
    private ArrayList<Contato> contatos = new ArrayList<Contato>();
    
    public Pessoa() {
    }

    public Pessoa(long codigo, String nome, ArrayList<Contato> contatos) {
        this.codigo = codigo;
        this.nome = nome;
        this.contatos = contatos;
    }
    public Pessoa(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    public void removeContato(Contato contato) {
        this.contatos.remove(contato);
    }

    @Override
    public String toString() {
        return "Pessoa:"+ nome +"\ncodigo=" + codigo + "\ncontatos=" + contatos + "\n";
    }

    public Pessoa getPessoa(){
        return this;
    }

}
