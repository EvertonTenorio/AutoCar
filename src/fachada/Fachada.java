package fachada;

import java.util.List;
import negocio.NegocioCliente;
import negocio.NegocioFuncionario;
import negocio.NegocioProduto;
import negocio.NegocioServico;
import negocio.NegocioVenda;
import negocio.entidade.Cliente;
import negocio.entidade.Funcionario;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.Venda;

public class Fachada {

    private NegocioFuncionario negocioFun;
    private NegocioCliente negocioCli;
    private NegocioProduto negocioProd;
    private NegocioServico negocioServ;
    private NegocioVenda negocioVenda;

    private static Fachada myself = null;

    private Fachada() {
        this.negocioCli = new NegocioCliente();
        this.negocioFun = new NegocioFuncionario();
        this.negocioProd = new NegocioProduto();
        this.negocioServ = new NegocioServico();
        this.negocioVenda = new NegocioVenda();
    }

    public static Fachada getnstance() {
        if (myself == null) {
            myself = new Fachada();
        }
        return myself;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.negocioFun.cadastrarFuncionario(funcionario);
    }

    public void cadastrarCliente(Cliente cliente) {
        this.negocioCli.cadastrarCliente(cliente);
    }

    public void cadastrarProduto(Produto produto) {
        this.negocioProd.cadastrarProduto(produto);
    }

    public void cadastrarServico(Servico servico) {
        this.negocioServ.cadastrarServico(servico);
    }

    public void cadastrarVenda(Venda venda) {
        this.negocioVenda.cadastrarVenda(venda);
    }

    public void alterarFuncionario(Funcionario funcionario) {
        this.negocioFun.alterarFuncionario(funcionario);
    }

    public void alterarCliente(Cliente cliente) {
        this.negocioCli.alterarCliente(cliente);
    }

    public void alterarProduto(Produto produto) {
        this.negocioProd.alterarProduto(produto);
    }

    public void alterarServico(Servico servico) {
        this.negocioServ.alterarServico(servico);
    }

    public void alterarVenda(Venda venda) {
        this.negocioVenda.alterarVenda(venda);
    }

    public Funcionario buscarFuncionario(String cpf) {
        return this.negocioFun.buscarFuncionario(cpf);
    }

    public Cliente buscarCliente(String cpf) {
        return this.negocioCli.buscarCliente(cpf);
    }

    public Produto buscarProduto(int codigo) {
        return this.negocioProd.buscarProduto(codigo);
    }

    public Servico buscarServico(int codigo) {
        return this.negocioServ.buscarServico(codigo);
    }

    public Venda buscarVenda(int codigo) {
        return this.negocioVenda.buscarVenda(codigo);
    }

    public void removerFuncionario(String cpf) {
        this.negocioFun.removerFuncionario(cpf);
    }

    public void removerCliente(String cpf) {
        this.negocioCli.removerCliente(cpf);
    }

    public void removerProduto(int codigo) {
        this.negocioProd.removerProduto(codigo);
    }

    public void removerServico(int codido) {
        this.negocioServ.removerServico(codido);
    }

    public void removerVenda(int codigo) {
        this.negocioVenda.removerVenda(codigo);
    }

    public List<Funcionario> listarFuncionarios() {
        return this.negocioFun.listaFuncionario();
    }

    public List<Cliente> listarClientes() {
        return this.negocioCli.listaClientes();
    }

    public List<Produto> listarprodutos() {
        return this.negocioProd.listaProdutos();
    }

    public List<Servico> listarServicos() {
        return this.negocioServ.listaServicos();
    }

    public List<Venda> listarVendas() {
        return this.negocioVenda.listaVendas();
    }
}
