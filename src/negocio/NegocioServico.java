package negocio;

import java.util.ArrayList;
import negocio.entidade.Servico;
import negocio.execao.servico.ServicoInvalidoException;
import negocio.execao.servico.ServicoJaExisteException;
import negocio.execao.servico.ServicoNaoExisteException;
import repositorio.RepositorioServico;

public class NegocioServico {

    private RepositorioServico repositorio;

    public NegocioServico() {
        this.repositorio = new RepositorioServico();
    }

    public void cadastrarServico(Servico servico) throws ServicoInvalidoException, ServicoJaExisteException {
        Servico s = this.repositorio.recuperarServico(servico.getCodigo());

        if (servico.getNome().equals("") && servico.getValor() == 0 && servico.getMecanico() == null) {
            throw new ServicoInvalidoException();
        } else if (s == null) {
            this.repositorio.cadastrarServico(servico);
        } else {
            throw new ServicoJaExisteException();
        }
    }

    public void alterarServico(Servico servico) throws ServicoNaoExisteException {
        int indice = this.repositorio.indiceServico(servico.getCodigo());

        if (indice != -1) {
            this.repositorio.alterarServico(indice, servico);
        } else {
            throw new ServicoNaoExisteException();
        }
    }

    public void removerServico(int codigo) throws ServicoNaoExisteException {
        Servico s = this.repositorio.recuperarServico(codigo);

        if (s != null) {
            this.repositorio.removerServico(s);
        } else {
            throw new ServicoNaoExisteException();
        }
    }

    public Servico buscarServico(int codigo) throws ServicoNaoExisteException {
        Servico servico = this.repositorio.recuperarServico(codigo);

        if (servico != null) {
            return servico;
        } else {
            throw new ServicoNaoExisteException();
        }
    }

    public ArrayList<Servico> listaServicos() {
        return this.repositorio.recuperarTodos();
    }
}
