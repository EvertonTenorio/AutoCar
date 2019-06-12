package repositorio;

import java.util.ArrayList;
import java.util.List;
import negocio.entidade.Servico;
import repositorio.dao.ServicoDAO;
import repositorio.interfaces.IRepositorioServico;


public class RepositorioServico implements IRepositorioServico{

    private ServicoDAO servicosDAO;

    public RepositorioServico() {
        this.servicosDAO = new ServicoDAO();
    }

    @Override
    public void cadastrarServico(Servico servico) {
        this.servicosDAO.cadastrar(servico);
    }

    @Override
    public void removerServico(Servico servico) {
        this.servicosDAO.remover(servico);
    }

    @Override
    public Servico recuperarServico(int codigo) {
        return null;
    }

    @Override
    public void alterarServico(Servico servico) {
        this.servicosDAO.alterar(servico);
    }
    
    
    public List<Servico> recuperarTodos() {
        return null;
    }

}
