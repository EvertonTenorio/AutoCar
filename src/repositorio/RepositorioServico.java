package repositorio;

import java.util.ArrayList;
import negocio.entidade.Servico;
import repositorio.interfaces.IRepositorioServico;

/* Thaís: Não faria sentido buscar por serviços periódicos? Como isso poderia ser feito para evitar o uso de instanceof?*/
public class RepositorioServico implements IRepositorioServico{

    private ArrayList<Servico> listaServicos;

    public RepositorioServico() {
        this.listaServicos = new ArrayList<>();
    }

    @Override
    public void cadastrarServico(Servico servico) {
        this.listaServicos.add(servico);
    }

    @Override
    public void removerServico(Servico servico) {
        this.listaServicos.remove(servico);
    }

    @Override
    public Servico recuperarServico(int codigo) {
        for (Servico s : this.listaServicos) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void alterarServico(int indice, Servico servico) {
        this.listaServicos.set(indice, servico);
    }

    public ArrayList<Servico> recuperarTodos() {
        return listaServicos;
    }

    public int indiceServico(int codigo) {
        for (int i = 0; i < listaServicos.size(); i++) {
            if (listaServicos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
}
