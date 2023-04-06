import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.sql.*;
import java.sql.DriverManager;

public class App {

    private static long codigoChave = 1;
    private static long codigoPessoa = 1;
    private static long codigoEmprestimo = 1;
    private static long codigoContato = 1;

    private static ArrayList<Chave> chaves = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        /* 
        Pessoa pessoa1 = new Pessoa(codigoPessoa++, "João");
        Chave chave = new Chave(codigoChave++, "Chave 1", true);
        Emprestimo emprestimo;
        pessoa1.addContato(new Contato(1, tipoContato.EMAIL, "fulano@gmail.com"));
        pessoa1.addContato(new Contato(2, tipoContato.CELULAR, "999999999"));
        emprestimo = new Emprestimo(codigoEmprestimo++, pessoa1, chave);
        emprestimo.setRetirada(LocalDateTime.now());
        Pessoa pessoa2 = new Pessoa(codigoPessoa++, "Maria");
        pessoa2.addContato(new Contato(1, tipoContato.EMAIL, "maria@gmail.com"));
        ----------------------------------------------
        */

        int i = 0;
        //Inicializando o banco de dados
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String url = "jdbc:postgres://ybnlwgqg:ITAn0N_xfyedmS7ea4jtD6FkFACV-iOC@babar.db.elephantsql.com/ybnlwgqg";
        String username = "ybnlwgqg";
        String password = "ITAn0N_xfyedmS7ea4jtD6FkFACV-iOC";

        Connection connection = DriverManager.getConnection(url, username, password);

        // Cria uma declaração SQL
        Statement statement = connection.createStatement();

        // Executa a query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM pessoa");

        // Itera sobre os resultados
        while (resultSet.next()) {
            System.out.println(resultSet.getString("nome"));
        }

        // Fecha a conexão
        statement.close();
        resultSet.close();
        connection.close();

        while(i != 8){
            
            System.out.println("1 - Cadastrar Chave");
            System.out.println("2 - Cadastrar Pessoa");
            System.out.println("3 - Emprestar Chave");
            System.out.println("4 - Devolver Chave");
            System.out.println("5 - Listar Chaves");
            System.out.println("6 - Listar Pessoas");
            System.out.println("7 - Listar Emprestimos");
            System.out.println("8 - Sair");
            i = scanner.nextInt();
            
            switch(i){
                case 1:
                    cadastrarChave();
                    break;
                case 2:
                    cadastrarPessoa();
                    break;
                case 3:
                    emprestarChave();
                    break;
                case 4:
                    devolverChave();
                    break;
                case 5:
                    listarChaves();
                    break;
                case 6:
                    listarPessoas();
                    break;
                case 7:
                    listarEmprestimos();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }


    }
    private static void cadastrarChave(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a sala da chave: ");
        String nome = scanner.nextLine();
        if(verificarExistenciaChave(nome)){
            System.out.println("Chave ja cadastrada");
            return;
        }
        Chave chave = new Chave(codigoChave++, nome);
        chaves.add(chave);
        clearScreen();
    }

    private static void cadastrarPessoa(){
        System.out.println("Selecione a categoria da pessoa: ");
        System.out.println("1 - Servidor");
        System.out.println("2 - Terceirizado");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        if(i == 1){
            System.out.println("Digite o siape da pessoa: ");
            String siape = scanner.nextLine();
            Pessoa pessoa = new Servidor(codigoPessoa++, nome, siape);
            /*if(verificarIgualdadePessoa(pessoa)){
                System.out.println("Pessoa ja cadastrada");
                
                return;}
            pessoas.add(pessoa);*/
        }else if(i == 2){
            System.out.println("Digite o nome da empresa: ");
            String empresa = scanner.nextLine();
            Pessoa terceirizado = new Tercerizado(codigoPessoa++, nome, empresa);
            /*if(verificarIgualdadePessoa(terceirizado)){
                System.out.println("Pessoa ja cadastrada");
                return;}*/
            pessoas.add(terceirizado);
        }
        clearScreen();
    }
    
    private static void emprestarChave(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        if(!verificarExistenciaPessoa(nome)){
            System.out.println("Pessoa nao cadastrada");
            return;
        }
        System.out.println("Digite a sala da chave: ");
        String sala = scanner.nextLine();
        if(!verificarExistenciaChave(sala)){
            System.out.println("Chave nao cadastrada");
            return;
        }
        Pessoa pessoa = new Pessoa();
        Chave chave = new Chave();
        for (Pessoa p : pessoas) {
            if(p.getNome().equals(nome)){
                pessoa = p;
                
            }
        }
        for (Chave c : chaves) {
            if(c.getSala().equals(sala)){
                chave = c;
                //c.setDisponivel(false);
            }
        }
        for(int i = 0; i < chaves.size(); i++){
            if(chaves.get(i).getSala().equals(sala)){
                chaves.get(i).setDisponivel(false);
            }
        }            
        Emprestimo emprestimo = new Emprestimo(codigoEmprestimo++, pessoa, chave);
        emprestimo.setRetirada(LocalDateTime.now());
        emprestimos.add(emprestimo);
        clearScreen();
    }

    private static void devolverChave(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        if(!verificarExistenciaPessoa(nome)){
            System.out.println("Pessoa nao cadastrada");
            return;
        }
        System.out.println("Digite a sala da chave: ");
        String sala = scanner.nextLine();
        if(!verificarExistenciaChave(sala)){
            System.out.println("Chave nao cadastrada");
            return;
        }
        Pessoa pessoa = new Pessoa();
        Chave chave = new Chave();
        for (Pessoa p : pessoas) {
            if(p.getNome().equals(nome)){
                pessoa = p;
            }
        }
        for (Chave c : chaves) {
            if(c.getSala().equals(sala)){
                chave = c;
            }
        }
        for(int i = 0; i < chaves.size(); i++){
            if(chaves.get(i).getSala().equals(sala)){
                chaves.get(i).setDisponivel(true);
            }
        } 
        for (Emprestimo e : emprestimos) {
            if(e.getPessoaRetirada().equals(pessoa) && e.getChave().equals(chave)){
                e.setDevolucao(LocalDateTime.now());
            }
        }
        for(int i = 0; i < emprestimos.size(); i++){
            if(emprestimos.get(i).getPessoaRetirada().equals(pessoa) && emprestimos.get(i).getChave().equals(chave)){
                emprestimos.get(i).setPessoaDevolucao(pessoa);
            }
        }
        clearScreen();
    }

    private static void listarChaves(){
        for (Chave c : chaves) {
            System.out.println(c);
        }
    }

    private static void listarPessoas(){
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }

    private static void listarEmprestimos(){
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static boolean verificarExistenciaPessoa(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarExistenciaChave(String sala) {
        for (Chave chave : chaves) {
            if (chave.getSala().equals(sala)) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarIgualdadePessoa(Pessoa pessoa) {
        for (Pessoa p : pessoas) {
            if (pessoa.equals(p)) {
                return true;
            }
        }
        return false;
    }
}
