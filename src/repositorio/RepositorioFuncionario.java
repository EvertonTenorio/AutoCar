package repositorio;

import negocio.entidade.Funcionario;
import java.util.ArrayList;
import negocio.entidade.Gerente;
import negocio.entidade.Mecanico;
import repositorio.dao.FuncionarioDAO;
import repositorio.interfaces.IRepositorioFuncionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {

    private FuncionarioDAO funcionariosDAO;

    public RepositorioFuncionario() {
        this.funcionariosDAO = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.funcionariosDAO = new FuncionarioDAO();
    }

    public Funcionario buscarFuncionario(String cpf) {
        return null;
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionariosDAO.remover(funcionario);
    }

    public void alterarFuncionario(Funcionario funcionario) {
        this.funcionariosDAO.alterar(funcionario);
    }

    public Funcionario logarGerente(String login, String senha) {

        for (int i = 0; i < this.listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i) instanceof Gerente) {
                Gerente gerente = (Gerente) listaFuncionarios.get(i);

                if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                    return gerente;
                }
            }
        }
        return null;
    }

    public ArrayList<Funcionario> recuperarTodos() {
        return null;
    }

    @Override
    public ArrayList<Mecanico> recuperarMecanicos() {
        ArrayList<Mecanico> lista = new ArrayList<>();

        for (int i = 0; i < listaFuncionarios.size(); i++) {
            Funcionario f = listaFuncionarios.get(i);
            if (f instanceof Mecanico) {
                Mecanico m = (Mecanico) listaFuncionarios.get(i);
                lista.add(m);
            }
        }
        return lista;
    }

    private int indiceFuncionario(String cpf) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

}
