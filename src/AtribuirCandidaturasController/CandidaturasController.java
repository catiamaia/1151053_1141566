/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtribuirCandidaturasController;

import Model.CentroExposicoes;
import static Model.CentroExposicoes.FILE_UTILIZADORES;
import Model.Exposicao;
import Model.Utilizador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author maurobarros
 */
public class CandidaturasController {
  
    
   
    
    public CentroExposicoes CriarNovoCentroExposicoes(){
     
        CentroExposicoes ce1=new CentroExposicoes();
        return ce1;
    }
    
    public Exposicao CriarNovaExposicao(){
        Exposicao exp1=new Exposicao();
        return exp1;
    }
    
    
  
    public ArrayList AssociacaoOrganizadoresExposicao(String u, CentroExposicoes ce1){
        ArrayList al=ce1.getAssociacaoOrganizadoresExposicao(u);

        return al;
    }
    
    public void getRegistoCandidaturas(){
        
    }
    
    public void getRegistoFAES(){
        
    }
    
    
}
