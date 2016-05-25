/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtribuirCandidaturasUI;

import AtribuirCandidaturasController.CandidaturasController;
import Interfaces.Consola;
import Model.CentroExposicoes;
import Model.Utilizador;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author maurobarros
 */
public class CandidaturasUI {
    
    public void menuConsola() throws Exception{
    
    Scanner entrada=new Scanner(System.in);
        //cria objeto do tipoconsola
               Consola c1= new Consola();
               //chamo o menuPrinicpal() do objeto c1 para apresentar o menu principal
               c1.menuPrinicpal();
        int ler=0;
        do{
           ler=entrada.nextInt();
           if(ler==1 || ler ==2 || ler ==3 ) {
               //retornou os valores do login
               String []valores=c1.menuLogin();            
               //crio um objeto CandidaturasController
              CandidaturasController CandidaturasController1=new CandidaturasController();
              //crio um objeto centro de exposições em canddidaturasController
              CentroExposicoes ce1=CandidaturasController1.CriarNovoCentroExposicoes();
             //Dos valores inseridos pelo utilizador do menu principal crio um objeto do tipo utilizador
            Utilizador utlzAvaliado=new Utilizador(valores[0], valores[1],Boolean.parseBoolean(valores[2])); 
            //apresenta a lista de utilizadores
             List<Utilizador> Utilizadores=ce1.getListaUtilizadores();
             //verificar se o utilizador é organizador e se sim listar a listas de exposicoes associadas a ele (organizador)
            
             for(int i=0;i<Utilizadores.size();i++){  
               
                if(Utilizadores.get(i).getNome().equals(valores[0])){
                ArrayList al= CandidaturasController1.AssociacaoOrganizadoresExposicao(valores[0],ce1);
                c1.menuExposicoesDoOrgnizador(al);
                CandidaturasController1.getMecanismos();
                
                 break;
                 }else{
                     System.out.print("Não é Utilizador");
                 }
                    
             }
             
             
           }else{
               System.out.print("Opção inválida");
           }
        }while(ler !=1 || ler !=2 || ler !=3 );
    }
    
                 
                
             
    
   
    
}
