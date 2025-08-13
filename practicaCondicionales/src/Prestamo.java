import java.util.Scanner;

public class Prestamo {
    public static void main(String[] args){
        int valueUser = 0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el monto del préstamo");
        valueUser = userInput.nextInt();

        if (valueUser < 1000 || valueUser > 5000){
            System.out.println("El valor " + valueUser + " no esta dentro del rango permitido para el prestamo");
        } else {
            System.out.println("La solicitud sera revisada");
        }
    }
}
