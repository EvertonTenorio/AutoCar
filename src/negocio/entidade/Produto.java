package negocio.entidade;

public class Produto {

    private int codigo;
    private double valor;
    private String nome;

    private static int GerarCodigo = 1;

    public Produto(double valor, String nome) {
        this.codigo = GerarCodigo++;
        this.valor = valor;
        this.nome = nome;
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

}
