package candidatura;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // for (int i = 0; 3 >= i; i++){
        // System.out.println("Digite o seu salario pretendido:");
        // double salario = sc.nextDouble();

        // analisarCandidato(salario);
        // }
        System.out.println("Processo Seletivo");
        selecionarCandidato();

        imprimirSelecionados(selecionarCandidato());

        for (String candidato : selecionarCandidato()) {
            ligarCandidatos(candidato);
        }
    }

    static void ligarCandidatos(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas);
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(String[] candidatos) {
        // String [] candidatos = {"FELIPE","CURTI","YAN","ANDRE","HEITOR"};
        System.out.println("Imprimir os candidatos selecionados, informando a posição deles:");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de posição " + (i + 1) + " é o " + candidatos[i]);
        }
    }

    static String[] selecionarCandidato() {
        String[] candidatos = { "FELIPE", "CURTI", "YAN", "ANDRE", "HEITOR", "VINI", "VEIGA", "CALLERI", "JULIA",
                "MARCOS", "MARCELA", "RENATA", "YASMIN", "BRUNA", "VITORIA" };

        int candidatoSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        String[] selecionados = new String[5];

        while (candidatoSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato" + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                selecionados[candidatoSelecionados] = candidato;
                candidatoSelecionados++;
            }
            candidatoAtual++;
        }
        return selecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
