/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author maurobarros
 */
public class Organizador {
    private Utilizador m_oUtilizador;
    
    public Organizador()
    {
    }
    
    public void setUtilizador(Utilizador u)
    {
        this.m_oUtilizador = u;
    }
    
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
 
    @Override
    public String toString()
    {
        return this.m_oUtilizador.toString();
    }

    public boolean isUtilizador(Utilizador u)
    {
        if (this.m_oUtilizador != null)
        {
            return this.m_oUtilizador.equals(u);
        }
        return false;
    }
}
