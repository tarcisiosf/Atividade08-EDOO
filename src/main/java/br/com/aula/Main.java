package br.com.aula;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" SIMULAÇÃO DA FILA DE PRIORIDADE");
        System.out.println("=================================================\n");

        FilaDePrioridadePacientes filaPrioridade = new FilaDePrioridadePacientes();
        ListaDeAtendidos listaDeAtendidos = new ListaDeAtendidos();

        System.out.println("--> Chegada de pacientes na clínica:\n");
        filaPrioridade.enqueue(new Paciente("Tarcísio Santos", 22));  // Normal
        filaPrioridade.enqueue(new Paciente("Fernando", 80));           // Prioridade (Idoso)
        filaPrioridade.enqueue(new Paciente("Anna Luiza PMPA", 22));    // Normal
        filaPrioridade.enqueue(new Paciente("Júlia", 31, true));        // Prioridade (Urgente)
        filaPrioridade.enqueue(new Paciente("João", 65));               // Prioridade (Idoso)
        filaPrioridade.enqueue(new Paciente("Beatriz", 19));            // Normal
        filaPrioridade.enqueue(new Paciente("Ana", 45, true));       // Prioridade (Urgente)
        filaPrioridade.enqueue(new Paciente("Roberto", 55));            // Normal

        System.out.println("--> Iniciando atendimentos (ordem de prioridade):\n");
        while (!filaPrioridade.isEmpty()) {
            Paciente atendido = filaPrioridade.dequeue();
            System.out.println("Atendendo agora: " + atendido);
            listaDeAtendidos.adicionar(atendido);
        }

        System.out.println("\nTodos os pacientes foram atendidos!\n");

        System.out.println("=================================================");
        System.out.println(" ESTATÍSTICAS E RELATÓRIO FINAL ");
        System.out.println("=================================================\n");

        System.out.println(listaDeAtendidos.gerarRelatorioDiario());

        listaDeAtendidos.exportarRelatorioTxt("relatorio_clinica.txt");
    }
}