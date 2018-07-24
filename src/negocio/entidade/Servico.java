package negocio.entidade;

public class Servico {

    private int codigo;
    private double valor;
    private String nome;
    private Funcionario mecanico;

    private static int GerarCodigo = 1;

    public Servico(double valor, String nome, Funcionario mecanico) {
        this.codigo = GerarCodigo++;
        this.valor = valor;
        this.nome = nome;
        this.mecanico = mecanico;
    }

    public Funcionario getMecanico() {
        return mecanico;
    }

    public void setMecanico(Funcionario mecanico) {
        this.mecanico = mecanico;
    }

    public static int getGerarCodigo() {
        return GerarCodigo;
    }

    public static void setGerarCodigo(int GerarCodigo) {
        Servico.GerarCodigo = GerarCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Servico) {
            Servico servico = (Servico) obj;
            if (this.codigo == servico.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " Nome: " + this.nome + " Valor: " + this.valor;   
    }

}