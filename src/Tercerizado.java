import java.util.ArrayList;

public class Tercerizado extends Pessoa {
    private String empresa;

    public Tercerizado() {
    }

    public Tercerizado(long codigo, String nome, String empresa, ArrayList<Contato> contatos) {
        super(codigo, nome, contatos);
        this.empresa = empresa;
    }

    public Tercerizado(long codigo, String nome, String empresa) {
        super(codigo, nome);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Tercerizado: empresa=" + empresa + "\n" + super.toString();
    }
}
