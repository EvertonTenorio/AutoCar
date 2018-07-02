package negocio;

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
}
