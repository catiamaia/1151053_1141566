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
public class Utilizador {
    private String m_sNome;
    private String m_sEmail;
    private String m_sUserName;
    private String m_sPassword;
    private Boolean m_bRegistado;
    
   
    
    public Utilizador(String sNome, String sEmail, Boolean bRegistado)
    {
        this.m_sNome = sNome;
        this.m_sEmail = sEmail;
        this.m_sUserName = sEmail;
        this.m_bRegistado = bRegistado;
    }
    /*
    public Utilizador(String sID, String sNome, String sEmail)
    {
        this.m_sNome = sNome;
        this.m_sEmail = sEmail;
        this.m_sUserName = sID;
    } */
    
    public boolean hasID(String strId)
    {
        return m_sUserName.equalsIgnoreCase(strId);
    }
    
    public String getID()
    {
        return m_sUserName;
    }

    public String getNome() {
        return m_sNome;
    }

    public void setNome(String nome) {
        this.m_sNome = nome;
    }

    public String getEmail() {
        return m_sEmail;
    }

    public void setEmail(String email) {
        this.m_sEmail = email;
    }

    public String getUsername() {
        return m_sUserName;
    }

    public void setUsername(String username) {
        this.m_sUserName = username;
    }

    public String getPassword() {
        return m_sPassword;
    }

    public void setPassword(String password) {
        this.m_sPassword = password;
    }

    public Boolean getRegistado() {
        return m_bRegistado;
    }

    public void setRegistado(Boolean registado) {
        this.m_bRegistado = registado;
    }
    
    @Override
    public String toString(){
        return String.format("[%s, %s, %s]", m_sNome, m_sEmail, m_sUserName, m_sPassword);
    }

    public boolean valida(){
        return true;
    }

    public boolean equals(Utilizador u)
    {
        if (this == u)
            return true;
        if (u != null)
            return hasID(u.m_sUserName);
        return false;
    } 
}
