package impressao_numeros;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o primeiro numero:");
            int parametroUm = sc.nextInt();

            System.out.println("Digite o segundo numero:");
            int parametroDois = sc.nextInt();

            subtrair(parametroUm, parametroDois);




        } catch (ParametrosInvalidosException e) {
            System.out.println(e);
        }

    }

    static void subtrair(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        int subtracao = parametroDois - parametroUm;

        if (parametroDois < parametroUm) {
            throw new ParametrosInvalidosException();
        }
        
        for (int i = 1; i <= subtracao; i++) {
            System.out.println("Imprimindo o numero:" + i);
        }
    }
}
