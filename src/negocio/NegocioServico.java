package negocio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Servico;
import negocio.execao.produto.ProdutoInvalidoException;
import negocio.execao.servico.ServicoInvalidoException;
import negocio.execao.servico.ServicoJaExisteException;
import negocio.execao.servico.ServicoNaoExisteException;
import repositorio.RepositorioServico;
import repositorio.interfaces.IRepositorioServico;

public class NegocioServico {

    private IRepositorioServico repositorio;

    public NegocioServico() {
        this.repositorio = new RepositorioServico();
    }

    public void cadastrarServico(double valor, String nome) throws ServicoInvalidoException, ServicoJaExisteException, ProdutoInvalidoException {
        Servico servico = new Servico(valor, nome);

        Servico s = repositorio.recuperarServico(servico.getCodigo());

        if (s == null) {
            repositorio.cadastrarServico(servico);
        } else {
            throw new ServicoJaExisteException();
        }
    }

    public void alterarServico(Servico servico) throws ServicoNaoExisteException {
        Servico s = this.repositorio.recuperarServico(servico.getCodigo());

        if (s != null) {
            this.repositorio.alterarServico(servico);
        } else {
            throw new ServicoNaoExisteException();
        }
    }

    public void removerServico(int codigo) throws ServicoNaoExisteException {
        Servico s = this.buscarServico(codigo);

        this.repositorio.removerServico(s);
    }

    public Servico buscarServico(int codigo) throws ServicoNaoExisteException {
        Servico servico = this.repositorio.recuperarServico(codigo);

        if (servico != null) {
            return servico;
        } else {
            throw new ServicoNaoExisteException();
        }
    }

    public List<Servico> listaServicos() {
        return this.repositorio.recuperarTodos();
    }
}
