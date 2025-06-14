import java.util.Scanner;

public class Permiso {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el código de acceso:");
        int accessCode = userInput.nextInt();

        System.out.println("Ingrese el nivel de permiso");
        int permisseLevel = userInput.nextInt();

        boolean access = accessCode == 2023;
        boolean level = permisseLevel > 0 && permisseLevel < 4;

        if (!access && level){
            System.out.println("Acceso denegado, el codigo de acceso no es correcto");
        }
        if (access && !level){
            System.out.println("Acceso denegado, el nivel de permiso es invalido");
        }

        if (access && level) {
            System.out.println("Acceso permitido ¡Bienvenido al sistema!");
        }
        if (!access && !level) {
            System.out.println("Acceso denegado, ningun dato es correcto");
        }
    }
}
