package school.sptech;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        SistemaLog sistema = new SistemaLog();

        sistema.log("INFO", "Aplicação iniciada.");

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        sistema.validarEmail(email);


        System.out.print("Digite a sua senha: ");
        String senha = sc.nextLine();
        System.out.print("Confirme sua senha: ");
        String confirmarSenha = sc.nextLine();
        sistema.validarSenha(senha, confirmarSenha);
        Thread.sleep(5000);

        sistema.registarConta(email, senha, confirmarSenha);

        sistema.log("INFO", "Aplicação finalizada.");
    }
}