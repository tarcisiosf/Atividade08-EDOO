package br.com.aula;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

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


    public Paciente encontrarPacienteMaisIdoso() {
        if (atendidos.isEmpty()) return null;

        Paciente maisIdoso = atendidos.get(0);
        for (int i = 1; i < atendidos.size(); i++) {
            if (atendidos.get(i).getIdade() > maisIdoso.getIdade()) {
                maisIdoso = atendidos.get(i);
            }
        }
        return maisIdoso;
    }

    public String gerarRelatorioDiario() {
        if (atendidos.isEmpty()) {
            return "Nenhum paciente foi atendido para gerar relatório.";
        }
        Paciente maisIdoso = encontrarPacienteMaisIdoso();

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("--- RELATÓRIO DIÁRIO DA CLÍNICA ---\n");
        relatorio.append("Total de pacientes atendidos: ").append(getTotalAtendidos()).append("\n");
        relatorio.append(String.format("Média de idade: %.2f anos\n", calcularMediaIdade()));
        relatorio.append("Paciente mais idoso atendido: ").append(maisIdoso.getNome()).append(" (").append(maisIdoso.getIdade()).append(" anos)\n");
        relatorio.append("-------------------------------------\n");

        return relatorio.toString();
    }

    public void exportarRelatorioTxt(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println(gerarRelatorioDiario());
            System.out.println("Relatório exportado com sucesso para '" + nomeArquivo + "'");
        } catch (IOException e) {
            System.err.println("Erro ao exportar o relatório: " + e.getMessage());
        }
    }
}