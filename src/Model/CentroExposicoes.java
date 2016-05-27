/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author maurobarros
 */
public class CentroExposicoes {
   
    private final List<Utilizador> m_lUtilizadores;
    private final List<Exposicao> m_lExposicoes;
    public int  contador=0;
    
    public static final String FILE_UTILIZADORES="Utilizadores.txt";
   public static final String FILE_EXPOSICOES="Exposicoes.txt";
    
    public CentroExposicoes()
    {
        this.m_lUtilizadores = new ArrayList<>();
        this.m_lExposicoes = new ArrayList<>();
     
    }
    
    
    public List<Utilizador> getListaUtilizadores() throws FileNotFoundException{
      
        Scanner ler=new Scanner(new File(FILE_UTILIZADORES));

        while(ler.hasNext()){
            String linha=ler.nextLine();
             if (!linha.isEmpty()) {
                String[] separa = linha.split(";");
                Utilizador utlz =new Utilizador (separa[0],separa[1],Boolean.parseBoolean(separa[2]));
                m_lUtilizadores.add(utlz);
                
        }
          
    }
        return m_lUtilizadores;
    }
    
    
 public ArrayList getAssociacaoOrganizadoresExposicao(String u){
     
        ArrayList al=new ArrayList();
        try {
            Scanner ler=new Scanner(new File(FILE_EXPOSICOES));
            
         
            while(ler.hasNext()){
                String linha=ler.nextLine();
                if (!linha.isEmpty()) {
                    String[] separa = linha.split(";");
                    String[] separa2 =separa[5].split("-");
                            for(int i=0; i<separa2.length;i++){
                                if(separa2[i].equals(u)){
                                    al.add(separa[0]);
                                }
                            }                    
                }
      
            } 
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CentroExposicoes.class.getName()).log(Level.SEVERE, null, ex);
        }

return al;
 }
}