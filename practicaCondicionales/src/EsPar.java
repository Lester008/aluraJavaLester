import java.util.Scanner;

public class EsPar {
    public static void main(String[] args){
        //Se define el metodo para pedir el numero al usuario
        Scanner usuario = new Scanner(System.in);
        // Se declara la variable a utilizar
        int valor = 0;

        // Se imprime el mensaje para el usuario y se asigna la respuesta a nuestra variable
        System.out.println("Agrega el numero a consultar:");
        valor = usuario.nextInt();


        //Se ejecuta la funcion para saber si es par o impar
        if (valor % 2 == 0){
            System.out.println("El numero " + valor + " es par.");
        }
        else {
            System.out.println("El numero " + valor + " es impar.");
        }
    }
}
