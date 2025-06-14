import java.util.Scanner;

public class Sangre {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese la edad del donante:");
        int edad = userInput.nextInt();

        System.out.println("Ingrese el peso del donante");
        double peso = userInput.nextDouble();

        if (edad > 17 && edad < 66){
            if (peso > 49.99){
                System.out.println("Si puede donar.");
            } else {
                System.out.println("El donante no es compatible.");
                System.out.println("\nMotivo: Debe pesar mas de 50 kg.");
            }
        } else {
            System.out.println("El donante no es compatible.");
            System.out.println("\nMotivo: Debe de tener entre 18 y 65 años");
        }
    }
}
