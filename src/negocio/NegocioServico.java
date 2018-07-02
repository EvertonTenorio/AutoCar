package negocio;

import java.util.ArrayList;
import negocio.entidade.Servico;
import repositorio.RepositorioServico;

public class NegocioServico {
    private RepositorioServico repositorio;

    public NegocioServico() {
        this.repositorio = new RepositorioServico();
    }
    
    public void cadastrarServico(Servico servico){
        Servico s = this.repositorio.recuperarServico(servico.getCodigo());
        
        if(s == null){
            this.repositorio.cadastrarServico(servico);
        }else{
            System.out.println("Não foi possivel cadastrar!");
        }
    }
    
    public void alterarServico(Servico servico){
        int indice = this.repositorio.indiceServico(servico.getCodigo());
        
        if(indice != -1){
            this.repositorio.alterarServico(indice, servico);
        }else{
            System.out.println("Não foi possivel alterar!");
        }
    }
    
    public void removerServico(int codigo){
        Servico s = this.repositorio.recuperarServico(codigo);
        
        if(s != null){
            this.repositorio.removerServico(s);
        }else{
            System.out.println("Não foi possivel remover");
        }
    }
    
    public Servico buscarServico(int codigo){
        Servico servico = this.repositorio.recuperarServico(codigo);
        
        if(servico != null){
            return servico;
        }else{
            System.out.println("Servico não encontrado");
            return null;
        }
    }
    
    public ArrayList<Servico> listaServicos(){
        return this.repositorio.recuperarTodos();
    }
}
