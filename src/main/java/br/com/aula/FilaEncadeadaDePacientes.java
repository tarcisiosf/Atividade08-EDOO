package br.com.aula;

public class FilaEncadeadaDePacientes {

    private static class No {
        Paciente paciente;
        No proximo;

        public No(Paciente paciente) {
            this.paciente = paciente;
            this.proximo = null;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaEncadeadaDePacientes() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enqueue(Paciente paciente) {
        No novoNo = new No(paciente);
        if (isEmpty()) {
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
    }

    public Paciente dequeue() {
        if (isEmpty()) {
            return null;
        }
        Paciente pacienteRemovido = inicio.paciente;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return pacienteRemovido;
    }

    public Paciente peek() {
        if (isEmpty()) return null;
        return inicio.paciente;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }
}
