package br.com.aula;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAtendidos {
    private List<Paciente> atendidos;

    public ListaDeAtendidos() {
        this.atendidos = new ArrayList<>();
    }


    public void adicionar(Paciente paciente) {
        atendidos.add(paciente);
    }


    public void exibirTodos() {
        if (atendidos.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
            return;
        }
        System.out.println("----- Pacientes Atendidos Hoje -----");
        for (Paciente p : atendidos) {
            System.out.println(p.toString());
        }
        System.out.println("------------------------------------");
    }


    public boolean pesquisar(String nomePaciente) {
        for (Paciente p : atendidos) {
            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                return true;
            }
        }
        return false;
    }


    public int getTotalAtendidos() {
        return atendidos.size();
    }


    public double calcularMediaIdade() {
        if (atendidos.isEmpty()) {
            return 0.0;
        }

        int somaIdades = 0;
        for (Paciente p : atendidos) {
            somaIdades += p.getIdade();
        }

        return (double) somaIdades / atendidos.size();
    }
}