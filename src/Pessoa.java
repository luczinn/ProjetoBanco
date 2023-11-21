public class Pessoa {

    private static int counter = 1;

    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;

        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Pessoa.counter = counter;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "\nNome: " + getNome()
                + "\nCPF: " + getCpf()
                + "\nEmail: " + getEmail();
    }
}
