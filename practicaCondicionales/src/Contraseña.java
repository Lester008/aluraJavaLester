import java.util.Scanner;

public class Contraseña {
    public static void main(String[] args){
        String password = "C0ntr453n4";
        String passUser = "";

        Scanner userInput = new Scanner(System.in);

        System.out.println("Por favor ingresa tu contraseña");
        passUser = userInput.nextLine();

        if (!password.equals(passUser)) {
            System.out.println("¡Acceso denegado!");
        } else {
            System.out.println("¡Acceso permitido!");
        }
    }
}
