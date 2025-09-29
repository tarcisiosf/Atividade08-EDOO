package br.com.aula;

public class FilaDePrioridadePacientes {

    private static class No {
        Paciente paciente;
        No proximo;
        public No(Paciente paciente) { this.paciente = paciente; }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public void enqueue(Paciente paciente) {
        No novoNo = new No(paciente);
        boolean temPrioridade = paciente.getIdade() > 60 || paciente.isUrgente();

        if (isEmpty()) {
            inicio = fim = novoNo;
        } else if (temPrioridade) {
            novoNo.proximo = inicio;
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    public Paciente dequeue() {
        if (isEmpty()) return null;

        Paciente pacienteRemovido = inicio.paciente;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return pacienteRemovido;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}