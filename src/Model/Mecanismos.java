/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Interfaces.Consola;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author maurobarros
 */
public class Mecanismos {
    
   public static final String FILE_CANDIDATURAS="Candidaturas.txt";
   public static final String FILE_EXPOSICOES="Exposicoes.txt";
   public static final String FILE_FAE="FAE.txt";

    public Mecanismos() {
    }
    
    public void numeroDeParticipacoesComoFAES(ArrayList lstCandidaturasParaExpo, ArrayList LstFaesParaExpo) throws FileNotFoundException{
        
        System.out.println(LstFaesParaExpo);
  
       String[][]  MatrizFAEParticipacoes=ordenarCrescenteParticipacoesFAE(LstFaesParaExpo);
       for(int i=0;i<MatrizFAEParticipacoes.length;i++){
           for(int u=0;u<MatrizFAEParticipacoes.length;u++){
               System.out.print(MatrizFAEParticipacoes[i][u]);
           }System.out.print("\n");
       }
       

    }
  
       

    
    public void desempenhoDosFAES(String Expo,CentroExposicoes ce1){
        
    }
    
    public void areasDeExperienciaFAES(String Expo,CentroExposicoes ce1){
        
        
    }
    
    public ArrayList obterListaCandidaturasParaExpo(String Expo) throws FileNotFoundException{
        ArrayList LstCandidaturas = new ArrayList();
        Scanner ler = new Scanner(new File(FILE_CANDIDATURAS));
        int marcador = 0;
        while (ler.hasNext()) {
            String linha = ler.nextLine();
            if (!linha.isEmpty()) {
                if (marcador != 0) {
                    String[] separa2 = linha.split(";");
                    if (separa2.length <= 1) {
                        marcador=0;
                    } else {
                        LstCandidaturas.add(separa2[0]);
                    }
                } else {
                    String[] separa = linha.split("-");
                    if (separa.length > 1) {
                        if (separa[1].equals(Expo)) {
                            marcador = 1;
                        }
                    }

                }

            }

        }
        
        
        return LstCandidaturas;
    }
    
    private ArrayList obterFAESParaExpo(String Expo) throws FileNotFoundException{
        ArrayList LstFAES = new ArrayList();
        ArrayList LstOrganizadoresDaExpo = new ArrayList();
        
       
        
        int marcador=0;
        
        Scanner ler = new Scanner(new File(FILE_EXPOSICOES));
       
        
        //Obter todos os  organizadores da Expo selecionada
        while (ler.hasNext()) {
            String linha = ler.nextLine();
            if (!linha.isEmpty()) {
                String [] separa=linha.split(";");
                if(separa[0].equals(Expo)){
                    String [] separa2=separa[5].split("-");
                    for(int i=0;i<separa2.length;i++){
                        LstOrganizadoresDaExpo.add(separa2[i]);
                    }
                }
            }

        }ler.close();
        //obter todos os outros Utilizadores e  organizadores que nao da Expo selecionada
        
       // System.out.println("\n*** LISTA DOS Organizadores *** \n"+LstOrganizadoresDaExpo);
         Scanner ler2 = new Scanner(new File(FILE_EXPOSICOES));
         while (ler2.hasNext()) {
            String linha = ler2.nextLine();
            if (!linha.isEmpty()) {
                String [] separa=linha.split(";");
                if(!separa[0].equals(Expo)){
                    String [] separa2=separa[5].split("-");
                    for(int i=0;i<separa2.length;i++){                  
                            for(int a=0;a<LstOrganizadoresDaExpo.size();a++){
                                if(separa2[i].trim().equals(LstOrganizadoresDaExpo.get(a))){
                                    marcador=1;
                                }
                                 
                        }
                            if(marcador!=1){
                                    LstFAES.add(separa2[i]);
                                   
                                }else{
                                      marcador=0;
                                 }
                        
                        
                        
                        
                    }
                }
            }

        }
        

        return LstFAES;
    }
    
    private boolean verificaFAE(String Expo,String nome) throws FileNotFoundException{
       ArrayList LstFAE=obterFAESParaExpo(Expo); 
       for(int i=0;i<LstFAE.size();i++){
           if(LstFAE.get(i).equals(nome)){
               return true;
           }
       }
       return false;
    }
    
    private String [][] ordenarCrescenteParticipacoesFAE(ArrayList LstFaesParaExpo) throws FileNotFoundException{
         
        Scanner ler = new Scanner(new File(FILE_FAE));
        String [][]MatrizFAEParticipacoes=new String [2][LstFaesParaExpo.size()];
        int a=0,b=0;
         while (ler.hasNext()) {
            String linha = ler.nextLine();
            if (!linha.isEmpty()) {
                String [] separa=linha.split(";");
                for(int i=0;i<LstFaesParaExpo.size();i++){
                    if(LstFaesParaExpo.get(i).equals(separa[0])){
                        //FAE
                        MatrizFAEParticipacoes[0][b]=separa[0]; 
                        //participacoes do FAE
                        MatrizFAEParticipacoes[1][b]=separa[1];
                        System.out.print(MatrizFAEParticipacoes[0][b]+": "+MatrizFAEParticipacoes[1][b]+"\n");
                        b++;
                    }
                }
        
    
    }
      }
         //ordenacao crescente
         
             for(int y=0; y<MatrizFAEParticipacoes.length-1;y++){
                 
                 if(Integer.parseInt(MatrizFAEParticipacoes[1][y])>Integer.parseInt(MatrizFAEParticipacoes[1][y+1])){
                     
                     String tempParticipacoes=MatrizFAEParticipacoes[1][y];
                     String tempFAE=MatrizFAEParticipacoes[0][y];
                     
                     MatrizFAEParticipacoes[1][y]=MatrizFAEParticipacoes[1][y+1];  
                     MatrizFAEParticipacoes[1][y+1]=tempParticipacoes;
                     
                      MatrizFAEParticipacoes[0][y]=MatrizFAEParticipacoes[0][y+1];
                       MatrizFAEParticipacoes[0][y+1]= MatrizFAEParticipacoes[1][y];
                     
                     
                 }
             }
         
         
         
         return MatrizFAEParticipacoes;
    }
    
  

    public void gestorDeMecanismos(int opcaoMenuMecanismo,String ExpoSelecionada,CentroExposicoes ce1) throws FileNotFoundException{
          
          ArrayList lstCandidaturasParaExpo=obterListaCandidaturasParaExpo(ExpoSelecionada);
          ArrayList LstFaesParaExpo=obterFAESParaExpo(ExpoSelecionada);
      
      
      if(opcaoMenuMecanismo==1){
         
          numeroDeParticipacoesComoFAES(lstCandidaturasParaExpo,LstFaesParaExpo);
      }
      if(opcaoMenuMecanismo==2){
          
      }
      if(opcaoMenuMecanismo==3){
          
      }
      
  }
    
    
}
