package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("O que deseja fazer:\n\n"
                    + "1-Cadastar Funcionário"
                    + "2-Cadastar Cliente"
                    + "3-Cadastrar Produto"
                    + "4-Cadstrar Serviço"
                    + "5-Realizar Venda"
                    + "0-Sair");
            
            opcao = sc.nextInt();
            
            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;  
                default:
            }
            
        }while(opcao !=0);
    }
}
