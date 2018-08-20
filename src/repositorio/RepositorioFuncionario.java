package repositorio;

import negocio.entidade.Funcionario;
import java.util.ArrayList;
import negocio.entidade.Gerente;
import negocio.entidade.Mecanico;
import repositorio.interfaces.IRepositorioFuncionario;

public class RepositorioFuncionario implements IRepositorioFuncionario{

    private ArrayList<Funcionario> listaFuncionarios;

    public RepositorioFuncionario() {
        this.listaFuncionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.listaFuncionarios.add(funcionario);
    }

    public Funcionario buscarFuncionario(String cpf) {
        for (int i = 0; i < this.listaFuncionarios.size(); i++) {
            if (this.listaFuncionarios.get(i).getCpf().equals(cpf)) {
                return this.listaFuncionarios.get(i);
            }
        }
        return null;
    }

    public void removerFuncionario(Funcionario funcionario) {
        listaFuncionarios.remove(funcionario);
    }

    public void alterarFuncionario(Funcionario funcionario) {
        int indice = this.indiceFuncionario(funcionario.getCpf());

        listaFuncionarios.set(indice, funcionario);
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
        ArrayList<Funcionario> lista = new ArrayList<>();

        for (int i = 0; i < listaFuncionarios.size(); i++) {
            lista.add(listaFuncionarios.get(i));
        }

        return lista;
    }
    
    @Override
    public ArrayList<Mecanico> recuperarMecanicos(){
        ArrayList<Mecanico> lista = new ArrayList<>();
        
        for (int i = 0; i < listaFuncionarios.size(); i++){
            Funcionario f = listaFuncionarios.get(i);
            if ( f instanceof Mecanico){
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
