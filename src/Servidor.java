import java.util.ArrayList;

public class Servidor extends Pessoa{
    private String siape;

    public Servidor() {
    }

    public Servidor(long codigo, String nome, String siape, ArrayList<Contato> contatos) {
        super(codigo, nome, contatos);
        this.siape = siape;
    }

    public Servidor(long codigo, String nome, String siape) {
        super(codigo, nome);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }
    
    public void setSiape(String siape) {
        this.siape = siape;
    }

    @Override
    public String toString() {
        return "Servidor: siape=" + siape + "\n" + super.toString();
    }
}
