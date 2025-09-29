package br.com.aula;

public class Paciente {
    private String nome;
    private int idade;
    private boolean urgente;

    public Paciente(String nome, int idade) {
        this(nome, idade, false);
    }

    public Paciente(String nome, int idade, boolean urgente) {
        this.nome = nome;
        this.idade = idade;
        this.urgente = urgente;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isUrgente() {
        return urgente;
    }

    @Override
    public String toString() {
        return "Paciente [Nome: " + nome + ", Idade: " + idade + ", Urgente: " + urgente + "]";
    }
}