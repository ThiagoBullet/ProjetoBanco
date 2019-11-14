/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobranco;

import java.util.logging.Logger;

public class Pessoa {
    protected String nome;
    protected String endereco;
    protected String cpf;
    
 
    public Pessoa(){
        this.nome ="";
        this.endereco ="";
        this.cpf="";
    }
    
    
    public Pessoa(String nome, String endereco, String cpf){
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    
    public Pessoa(String nome){
        this.nome = nome;
        this.endereco ="";
        this.cpf ="";
    }

    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    
    @Override
    public String toString(){
        return this.nome + "\n";
    }
        
}
