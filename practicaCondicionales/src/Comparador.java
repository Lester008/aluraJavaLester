import java.util.Scanner;

public class Comparador {
    public static void main(String[] args){
        // Se declaran las variables a utilizar
        int firstNumber = 0;
        int secondNumber = 0;

        // Se declara el metodo para solicitar la entrada del usuario
        Scanner userInput = new Scanner(System.in);

        //Se imprime el mensaje para solicitar el primer numero y se guarda en la variable
        System.out.println("Ingrese el primer numero");
        firstNumber = userInput.nextInt();

        //Se imprime un nuevo mensaje para solicitar el segundo numero y se guarda en la variabel
        System.out.println("Ingrese el segundo numero");
        secondNumber = userInput.nextInt();

        // Se declara la condición y se imprime el mensaje según sea el caso
        if (firstNumber > secondNumber) {
            System.out.println("El numero mayor es: " + firstNumber);
        } else if (firstNumber < secondNumber){
            System.out.println("El numero mayor es: " + secondNumber);
        } else {
            System.out.println("Los numeros son iguales");
        }
    }
}
