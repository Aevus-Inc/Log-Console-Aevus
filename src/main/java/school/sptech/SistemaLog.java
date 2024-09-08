package school.sptech;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaLog {
    void log(String tipoMensagem, String mensagem){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatar);

        System.out.println(timestamp + " - " + tipoMensagem + " - " + mensagem);
    }

    Boolean validarEmail(String email){
        if (email.contains("@") && (email.endsWith(".com") || email.endsWith(".school"))) {
            log("INFO", "Email validado com sucesso.");
            return true;
        } else {
            log("ERROR", "Email inválido: " + email);
            return false;
        }
    }

    Boolean validarSenha(String senha, String confirmarSenha){
        if (!senha.equals(confirmarSenha)) {
            log("ERROR", "As senhas não coincidem.");
            return false;
        }
        if (!senha.matches(".*[A-Z].*")) {
            log("ERROR", "A senha deve conter uma letra maiúscula.");
            return false;
        }
        if (!senha.matches(".*[a-z].*")) {
            log("ERROR", "A senha deve conter uma letra minúscula.");
            return false;
        }
        if (!senha.matches(".*\\d.*")) {
            log("ERROR", "A senha deve conter um número.");
            return false;
        }
        if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            log("ERROR", "A senha deve conter um caractere especial.");
            return false;
        }

        log("INFO", "Senha validada com sucesso.");
        return true;
    }

    void registarConta(String email, String senha, String confirmarSenha){
        log("INFO", "Iniciando cadastro de conta.");
        if (validarEmail(email) && validarSenha(senha, confirmarSenha)) {
            log("INFO", "Cadastro realizado com sucesso.");
        } else {
            log("WARN", "Falha no cadastro de conta.");
        }
    }
}
