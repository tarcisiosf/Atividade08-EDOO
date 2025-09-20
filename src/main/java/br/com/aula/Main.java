package br.com.aula;

public class Main {

    public static void main(String[] args) {
        FilaDePacientes filaDeEspera = new FilaDePacientes(10);
        ListaDeAtendidos listaDeAtendidos = new ListaDeAtendidos();

        System.out.println(">>> INÍCIO DO DIA NA CLÍNICA UNIVERSITÁRIA <<<\n");

        System.out.println("1. Cinco pacientes chegam e entram na fila de espera...");
        filaDeEspera.enqueue(new Paciente("Tarcísio Santos", 22));
        filaDeEspera.enqueue(new Paciente("Anna Luiza PMPA", 22));
        filaDeEspera.enqueue(new Paciente("João", 65));
        filaDeEspera.enqueue(new Paciente("Ana", 45));
        filaDeEspera.enqueue(new Paciente("Beatriz", 19));
        System.out.println("Fila de espera agora tem " + filaDeEspera.size() + " pacientes.\n");

        System.out.println("2. Médico inicia os atendimentos...");
        for (int i = 0; i < 3; i++) {
            Paciente pacienteASerAtendido = filaDeEspera.dequeue();

            if (pacienteASerAtendido != null) {
                System.out.println("Chamando para consulta: " + pacienteASerAtendido.getNome());
                listaDeAtendidos.adicionar(pacienteASerAtendido);
            }
        }
        System.out.println("Atendimentos finalizados. Fila agora tem " + filaDeEspera.size() + " pacientes.\n");

        System.out.println("3. Verificando quem é o próximo da fila...");
        Paciente proximo = filaDeEspera.peek();
        if (proximo != null) {
            System.out.println("Próximo paciente a ser chamado: " + proximo.getNome() + "\n");
        } else {
            System.out.println("Não há mais ninguém na fila.\n");
        }

        System.out.println("4. Exibindo relatório de pacientes já atendidos no dia:");
        listaDeAtendidos.exibirTodos();

        System.out.println("\n>>> DESAFIO EXTRA: ESTATÍSTICAS <<<\n");
        System.out.println("Total de pacientes atendidos até agora: " + listaDeAtendidos.getTotalAtendidos());
        System.out.printf("Média de idade dos pacientes atendidos: %.2f anos\n", listaDeAtendidos.calcularMediaIdade());

        System.out.println("\nVerificando se 'João' já foi atendido: " + listaDeAtendidos.pesquisar("João"));
        System.out.println("Verificando se 'Lucas' já foi atendido: " + listaDeAtendidos.pesquisar("Lucas"));
    }
}