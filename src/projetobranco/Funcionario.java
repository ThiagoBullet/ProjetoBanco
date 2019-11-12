/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobranco;

public class Funcionario extends Pessoa{
    private String matricula;
    private double salario;
    
    public Funcionario(){
        this.matricula="";
        this.salario = 0;
    }   

    public Funcionario(String matricula, double salario, String nome, String cpf, String endereco) {
        super(nome, cpf, endereco);
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    

}
