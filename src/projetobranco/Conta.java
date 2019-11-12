/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobranco;

//import javax.swing.JOptionPane;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.DecimalFormat; 
import java.util.ArrayList;

public class Conta {
    private int numero;
    private double saldo;
    private double limite;
    ArrayList<Pessoa> titular = new ArrayList<Pessoa>();
    private StringBuilder log = new StringBuilder();
    
    public Conta(){
        this.numero = 0;
        this.saldo = 0;
        this.limite = 0;
        this.titular.add(new Pessoa());
        this.log = new StringBuilder();
    }
    
    public Conta(int numero, double saldo, double limite, String nome, String endereco, String cpf){
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.titular.add(new Pessoa(nome));
    }
    
    public Conta(int numero, String nome){
        this.numero = numero;
        this.saldo = 0;
        this.limite = 0;
        this.titular.add(new Pessoa(nome));
        this.log = new StringBuilder();
    }
    
    public Conta(int numero){
        this.numero = 0;
        this.saldo = 0;
        this.limite = 0;
        this.titular.add(new Pessoa(""));
        this.log = new StringBuilder();        
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public double getLimite(){
        return limite;
    }
    public void setLimite(double limite){
        this.limite = limite;
    }
    
    public ArrayList<Pessoa> getTitular(){
        return titular;    
    }
    public void setTitular(ArrayList<Pessoa> titular ){
        this.titular = titular;
    }
    
    // Método de encapsulamento que permite manipular o atributo setNome sem a necessidade de chamar o getTitulo
    public void setNome(String nome){
        this.titular.add(new Pessoa(nome));
    }
    
    public StringBuilder getLog(){
        return log;
    }
    public void setLog(StringBuilder log){
        this.log = log;
    }
    
    
    public boolean saque(double valor, Pessoa titular, Funcionario funcionario) throws ParseException{
        if((this.saldo + this.limite)< valor){
            GravaLog("Saque", "FALHA", valor, titular, funcionario, this);
            return false;
        }
        else{
            this.saldo-=valor;
            GravaLog("Saque", "OK", valor, titular, funcionario, this);
            return true;
        }
    }
    
    public void deposito(double valor, Pessoa titular, Funcionario funcionario) throws ParseException{
        if(this.limite >= (this.saldo + valor)){
            this.saldo += valor;
            GravaLog("Deposito", "OK", valor, titular, funcionario, this);
        }
        else{
            
           GravaLog("Deposito", "Falha", valor, titular, funcionario, this);
        }
        
    }
    
    public boolean transferencia(double valor, Conta destino, Pessoa titular, Funcionario funcionario ) throws ParseException{
        if(this.saque(valor, titular, funcionario)){
            destino.deposito(valor, titular, funcionario); // destino é a  segunda conta a qual recebera o transferencia/depósito
            GravaLog("Transferência", "OK", valor, titular, funcionario, destino);
            return true;
        }
        else{         
            GravaLog("Transferência", "OK", valor, titular, funcionario, destino);
            return false;
        }
    }
    
    
    public void GravaLog(String operacao, String status, double valor, Pessoa titular, Funcionario funcionario, Conta destino) {   
        Date data = new Date(); 
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DecimalFormat df = new DecimalFormat("R$"+"#,###.00");
        log.append( dateFormat.format(new Date() + operacao + status + valor + titular + funcionario + destino + "\n"));
        
        System.out.println( "Registros LOG: \n" + log );
    }
    
    @Override
    public String toString(){
        return "Conta Nº: "+this.numero+"\n" +"Saldo(R$): "+this.saldo+"\n" +"Limite(R$): "+this.limite+"\n" + "Titular: " + this.titular;
        //return "Conta Nº: "+this.numero+"\n";
    }
    
   
    
/*    public void mostrarConta(int numero_x, String titular_nome, double saldo_x){
        this.numero = numero_x; 
        this.titular.setNome(titular_nome);
        this.saldo = saldo_x;
        
        System.out.println("Numero da conta: "+numero_x+" Titular: "+titular_nome +" Saldo: "+saldo_x+"\n" );
        
    }*/


}
