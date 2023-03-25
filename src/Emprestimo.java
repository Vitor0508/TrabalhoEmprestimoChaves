
import java.time.LocalDateTime;

public class Emprestimo {
    private long codigo;
    private LocalDateTime retirada;
    private LocalDateTime devolucao;
    private Pessoa pessoaDevolucao;
    private Pessoa pessoaRetirada;
    private Chave chave;

    public Emprestimo() {
    }

    public Emprestimo(long codigo, LocalDateTime devolucao, Pessoa pessoaDevolucao, Pessoa pessoaRetirada, Chave chave) {
        this.codigo = codigo;
        this.retirada = LocalDateTime.now();
        this.devolucao = devolucao;
        this.pessoaDevolucao = pessoaDevolucao;
        this.chave = chave;
        this.pessoaRetirada = pessoaRetirada;
    }

    public Emprestimo(long codigo, Pessoa pessoaRetirada, Chave chave) {
        this.codigo = codigo;
        this.retirada = LocalDateTime.now();
        this.pessoaRetirada = pessoaRetirada;
        this.chave = chave;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getRetirada() {
        return retirada;
    }

    public void setRetirada(LocalDateTime retirada) {
        chave.retirarChave();
        this.retirada = retirada;
    }

    public LocalDateTime getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDateTime devolucao) {
        this.devolucao = devolucao;
    }

    public Pessoa getPessoaDevolucao() {
        return pessoaDevolucao;
    }

    public void setPessoaDevolucao(Pessoa pessoaDevolucao) {
        this.pessoaDevolucao = pessoaDevolucao;
    }

    public Pessoa getPessoaRetirada() {
        return pessoaRetirada;
    }

    public void setPessoaRetirada(Pessoa pessoaRetirada) {
        this.pessoaRetirada = pessoaRetirada;
    }

    public Chave getChave() {
        return chave;
    }

    public void setChave(Chave chave) {
        this.chave = chave;
    }
    
    public void setRetirada() {
        this.retirada = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Emprestimo " + codigo +":\ncodigo=" + codigo + "\nchave=" + chave + "\ndevolucao=" + devolucao + "\npessoaDevolucao=" + pessoaDevolucao + "\npessoaRetirada=" + pessoaRetirada + "\nretirada=" + retirada + "\n";
    }


}
