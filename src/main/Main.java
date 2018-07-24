package main;

import java.util.Scanner;
import javax.swing.JOptionPane;
import negocio.NegocioCliente;
import negocio.NegocioFuncionario;
import negocio.NegocioProduto;
import negocio.NegocioServico;
import negocio.NegocioVenda;
import negocio.entidade.Cliente;
import negocio.entidade.Funcionario;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.entidade.Venda;

public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        NegocioFuncionario negocioFun = new NegocioFuncionario();
        NegocioCliente negocioCli = new NegocioCliente();
        NegocioProduto negocioProd = new NegocioProduto();
        NegocioServico negocioServ = new NegocioServico();
        NegocioVenda negocioVenda = new NegocioVenda();
        String nome = "", cpf = "", telefone = "", cargo = "";
        double valor;
        
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer:\n\n"
                    + "1-Cadastar Funcionário\n"
                    + "2-Cadastar Cliente\n"
                    + "3-Cadastrar Produto\n"
                    + "4-Cadstrar Serviço\n"
                    + "5-Realizar Venda\n"
                    + "0-Sair"));

            if (opcao == 1 || opcao == 2) {
                nome = JOptionPane.showInputDialog(null, "Digite o nome");
                cpf = JOptionPane.showInputDialog(null, "Digite o cpf");
                telefone = JOptionPane.showInputDialog(null, "Digite o telefone");
            }

            switch (opcao) {
                case 1:
                    cargo = JOptionPane.showInputDialog(null, "Digite o cargo");

                    Funcionario f = new Funcionario(nome, cpf, telefone, cargo);
                    negocioFun.cadastrarFuncionario(f);
                    break;
                case 2:
                    Cliente c = new Cliente(nome, cpf, telefone);
                    negocioCli.cadastrarCliente(c);
                    break;
                case 3:
                    nome = JOptionPane.showInputDialog(null,"Digite o nome");
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor"));
                    
                    Produto p = new Produto(valor, nome);
                    negocioProd.cadastrarProduto(p);
                    break;
                case 4:
                    nome = JOptionPane.showInputDialog(null,"Digite o nome");
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor"));
                    
                    Servico s = new Servico(valor, nome);
                    negocioServ.cadastrarServico(s);
                    break;
                case 5:
                    String produtos = "", servicos = "";
                    
                    for(int i = 0; i < negocioProd.listaProduto().size(); i++){
                        produtos += negocioProd.listaProduto().get(i).toString()+"\n";
                    }
                    
                    for(int i = 0; i < negocioServ.listaServicos().size(); i++){
                        servicos += negocioServ.listaServicos().get(i).toString()+"\n";
                    }
                    
                    Venda v = new Venda();
                    
                    int indiceProd = Integer.parseInt(JOptionPane.showInputDialog("Escolha o produto:\n" + produtos ));
                    int indiceServ = Integer.parseInt(JOptionPane.showInputDialog("Escolha o servico:\n" + servicos));
                    
                    v.adicionarProduto(negocioProd.buscarProduto(indiceProd));
                    v.adicionarServico(negocioServ.buscarServico(indiceServ));
                    JOptionPane.showMessageDialog(null,"Valor Total: "+v.getValorTotal());
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!");
            }

        } while (opcao != 0);
    }
}
