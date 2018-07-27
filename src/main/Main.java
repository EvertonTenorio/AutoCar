package main;

import javax.swing.JOptionPane;
import negocio.entidade.CargosEnum;
import negocio.entidade.Cliente;
import negocio.entidade.Funcionario;
import negocio.entidade.Pessoa;
import negocio.entidade.Servico;
import negocio.entidade.Venda;
import negocio.Fachada;

public class Main {
    
    public static void main(String[] args) {
        Servico s = new Servico(20.0, "troca de oleo", null);
        Pessoa p = new Cliente("jenilson", "21454323", "8369484636");
        Funcionario p2 = new Funcionario("everton", "1245364523425", "3472857825", CargosEnum.Mecanico);
        Venda v = new Venda(p);
        try{
            Fachada.getnstance().cadastrarServico(s);
            
            v.adicionarServico(s, p2);
            
            System.out.println(Fachada.getnstance().buscarServico(1).getMecanico().getNome());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
