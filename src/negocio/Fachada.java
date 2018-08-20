package negocio;

import java.util.List;
import negocio.entidade.Carro;
import negocio.entidade.Cliente;
import negocio.entidade.Funcionario;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.Venda;
import negocio.execao.carro.CarroInvalidoException;
import negocio.execao.carro.CarroJaExisteException;
import negocio.execao.carro.CarroNaoExisteException;
import negocio.execao.cliente.ClienteInvalidoException;
import negocio.execao.cliente.ClienteJaExisteException;
import negocio.execao.cliente.ClienteNaoExisteException;
import negocio.execao.funcionario.FuncionarioInvalidoException;
import negocio.execao.funcionario.FuncionarioJaExisteException;
import negocio.execao.funcionario.FuncionarioNaoExisteException;
import negocio.execao.pessoa.PessoaInvalidaException;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.produto.ProdutoJaExisteException;
import negocio.execao.produto.ProdutoNaoExisteException;
import negocio.execao.servico.ServicoInvalidoException;
import negocio.execao.servico.ServicoJaExisteException;
import negocio.execao.servico.ServicoNaoExisteException;
import negocio.execao.venda.VendaInvalidaException;
import negocio.execao.venda.VendaJaExisteException;
import negocio.execao.venda.VendaNaoExisteException;

public class Fachada {

    private NegocioFuncionario negocioFun;
    private NegocioCliente negocioCli;
    private NegocioProduto negocioProd;
    private NegocioServico negocioServ;
    private NegocioVenda negocioVenda;
    private NegocioCarro negocioCarro;

    private static Fachada myself = null;

    private Fachada() {
        this.negocioCli = new NegocioCliente();
        this.negocioFun = new NegocioFuncionario();
        this.negocioProd = new NegocioProduto();
        this.negocioServ = new NegocioServico();
        this.negocioVenda = new NegocioVenda();
        this.negocioCarro = new NegocioCarro();
    }

    public static Fachada getnstance() {
        if (myself == null) {
            myself = new Fachada();
        }
        return myself;
    }

    public void cadastrarFuncionario(String nome, String cpf, String telefone, double salario) throws FuncionarioJaExisteException, PessoaInvalidaException {
        this.negocioFun.cadastrarFuncionario(nome, cpf, telefone, salario);
    }

    public void cadastrarCliente(String nome, String cpf, String telefone) throws PessoaInvalidaException, ClienteJaExisteException {
        this.negocioCli.cadastrarCliente(nome, cpf, telefone);
    }

    public void cadastrarProduto(Produto produto) throws ProdutoInvalidoException, ProdutoJaExisteException {
        this.negocioProd.cadastrarProduto(produto);
    }

    public void cadastrarServico(Servico servico) throws ServicoInvalidoException, ServicoJaExisteException {
        this.negocioServ.cadastrarServico(servico);
    }

    public void cadastrarVenda(Venda venda) throws VendaInvalidaException, VendaJaExisteException {
        this.negocioVenda.cadastrarVenda(venda);
    }

    public void cadastrarCarro(String placa) throws CarroInvalidoException, CarroJaExisteException {
        this.negocioCarro.cadastrarCarro(placa);
    }

    public void alterarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
        this.negocioFun.alterarFuncionario(funcionario);
    }

    public void alterarCliente(Cliente cliente) throws ClienteNaoExisteException {
        this.negocioCli.alterarCliente(cliente);
    }

    public void alterarProduto(Produto produto) throws ProdutoNaoExisteException {
        this.negocioProd.alterarProduto(produto);
    }

    public void alterarServico(Servico servico) throws ServicoNaoExisteException {
        this.negocioServ.alterarServico(servico);
    }

    public void alterarVenda(Venda venda) throws VendaNaoExisteException {
        this.negocioVenda.alterarVenda(venda);
    }

    public void alterarCarro(Carro carro) throws CarroNaoExisteException {
        this.negocioCarro.alterarCarro(carro);
    }

    public Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoExisteException {
        return this.negocioFun.buscarFuncionario(cpf);
    }

    public Cliente buscarCliente(String cpf) throws ClienteNaoExisteException {
        return this.negocioCli.buscarCliente(cpf);
    }

    public Produto buscarProduto(int codigo) throws ProdutoNaoExisteException {
        return this.negocioProd.buscarProduto(codigo);
    }

    public Servico buscarServico(int codigo) throws ServicoNaoExisteException {
        return this.negocioServ.buscarServico(codigo);
    }

    public Venda buscarVenda(int codigo) throws VendaNaoExisteException {
        return this.negocioVenda.buscarVenda(codigo);
    }

    public Carro buscarCarro(String placa) throws CarroNaoExisteException {
        return this.negocioCarro.buscarCarro(placa);
    }

    public void removerFuncionario(String cpf) throws FuncionarioNaoExisteException {
        this.negocioFun.removerFuncionario(cpf);
    }

    public void removerCliente(String cpf) throws ClienteNaoExisteException {
        this.negocioCli.removerCliente(cpf);
    }

    public void removerProduto(int codigo) throws ProdutoNaoExisteException {
        this.negocioProd.removerProduto(codigo);
    }

    public void removerServico(int codido) throws ServicoNaoExisteException {
        this.negocioServ.removerServico(codido);
    }

    public void removerVenda(int codigo) throws VendaNaoExisteException {
        this.negocioVenda.removerVenda(codigo);
    }

    public void removerCarro(String placa) throws CarroNaoExisteException {
        this.negocioCarro.removerCarro(placa);
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

    public List<Carro> listarCarros() {
        return this.negocioCarro.listaCarros();
    }
}
