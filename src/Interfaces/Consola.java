/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Model.CentroExposicoes;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author maurobarros
 */
public class Consola {
    
        
    public void menuPrinicpal(){
        System.out.print("\n*** MENU PRINCIPAL ***\n");
         System.out.print("Selecione uma opção? "+"\n"+"Atribuir Candidatura (1) "+"\n"+"Decidir Candidatura (2) "+
            "\n"+"Registar candidatura (3)"+"\n"+"->");
    }
    
    
    public String[] menuLogin(){
        Scanner entrada=new Scanner(System.in);
        String user=null;
        String email=null;
        String pass=null;
        System.out.print("\n**** MENU LOGIN ****");
        System.out.print("\nUSER: ");
        user=entrada.nextLine();
        System.out.print("\nEMAIL: ");
        email=entrada.nextLine();
        System.out.print("\nPASSWORD: ");
        pass=entrada.nextLine();
       
       
         String[] valores={user, email, pass};
        return valores;  
    }
    
    public void menuExposicoesDoOrgnizador(ArrayList al){
        Scanner entrada2=new Scanner(System.in);
    
            for(int i=0;i<al.size();i++){
            if(i==0){
                System.out.print("\n*** LISTA DAS EXPOSICOES DO ORGANIZADOR ***\n");
                System.out.print(al.get(i)+"\n");
           
            }else{
                System.out.print(al.get(i)+"\n");
            }
           
        }
        System.out.print("\n->");
        String leituraDeDados=entrada2.nextLine();
        boolean check= verificaDadosMenuExposicoesDoOrganizador(al,leituraDeDados);
        if(check==false){
            menuExposicoesDoOrgnizador(al);
        }
    }

    
    public boolean verificaDadosMenuExposicoesDoOrganizador(ArrayList al, String leituraDeDados){
         for(int i=0;i<al.size();i++){
             if(leituraDeDados.equals(al.get(i))){
                 return true;
             }
         }  
        return false;
    }
}
