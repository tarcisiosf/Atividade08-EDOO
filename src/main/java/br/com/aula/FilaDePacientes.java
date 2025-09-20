package br.com.aula;

public class FilaDePacientes {
    private Paciente[] pacientes;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public FilaDePacientes(int capacidade) {
        this.capacidade = capacidade;
        this.pacientes = new Paciente[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public void enqueue(Paciente paciente) {
        if (tamanho == capacidade) {
            System.out.println("Erro: A fila de espera está cheia!");
            return;
        }
        fim = (fim + 1) % capacidade;
        pacientes[fim] = paciente;
        tamanho++;
    }


    public Paciente dequeue() {
        if (tamanho == 0) {
            System.out.println("A fila de espera está vazia.");
            return null;
        }
        Paciente pacienteRemovido = pacientes[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return pacienteRemovido;
    }


    public Paciente peek() {
        if (tamanho == 0) {
            return null;
        }
        return pacientes[inicio];
    }


    public boolean isEmpty() {
        return tamanho == 0;
    }


    public int size() {
        return tamanho;
    }
}